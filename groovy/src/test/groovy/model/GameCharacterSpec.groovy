package model

import enums.Alignment
import spock.lang.Specification

import static enums.AbilityScore.*
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.greaterThanOrEqualTo
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

    def 'A character has ability scores which default to 10'() {
        expect:
        def abilityScores = character.abilityScores
        assertThat abilityScores[STRENGTH], equalTo(10)
        assertThat abilityScores[CONSTITUTION], equalTo(10)
        assertThat abilityScores[CHARISMA], equalTo(10)
        assertThat abilityScores[INTELLIGENCE], equalTo(10)
        assertThat abilityScores[WISDOM], equalTo(10)
        assertThat abilityScores[DEXTERITY], equalTo(10)
    }
}
