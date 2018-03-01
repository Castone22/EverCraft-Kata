package model

import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.greaterThanOrEqualTo
import static org.hamcrest.Matchers.is
import static org.hamcrest.Matchers.lessThanOrEqualTo
import static org.hamcrest.core.AllOf.allOf
import static org.hamcrest.core.IsEqual.equalTo

class GameCharacterSpec extends Specification {
    def character = new GameCharacter(name: 'Barley', alignment: Alignment.NEUTRAL)

    def 'A character can get their name'() {
        expect: 'That we can get their name'
        assertThat character.name, equalTo('Barley')
    }

    def 'A character can change their name'() {
        character.name = 'Heins'
        expect: 'That their name is updated'
        assertThat character.name, equalTo('Heins')
    }

    def 'A character has an alignment'() {
        expect:
        assertThat character.alignment, equalTo(Alignment.NEUTRAL)
    }

    def 'A character may have their alignment updated'() {
        character.alignment = Alignment.EVIL
        expect:
        assertThat character.alignment, equalTo(Alignment.EVIL)
    }

    def 'A character has an Armor class, it defaults to 10'() {
        expect:
        assertThat character.armorClass, equalTo(10)
    }

    def 'They also have hit points, these default to 5'(){
        expect:
        assertThat character.hitPoints, equalTo(5)
    }

    def 'A character can roll a die, it must land between 1 and 20'() {
        expect:
        400.times {
            assertThat character.rollDie(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(20))
        }
    }

    def 'An attack with a higher roll than armor class hits'(){
        def roll = 11
        def result = character.attack(character, roll)
        expect: result is(true)
    }

    def 'An attack with a lower roll than armor class misses'(){
        def roll = 9
        def result = character.attack(character, roll)
        expect: result is(false)
    }

    def 'Attacker also wins if roll is the same as armor class'(){
        def roll = 10
        def result = character.attack(character, roll)
        expect: result is(true)
    }
}
