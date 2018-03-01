package controller

import enums.Alignment
import enums.CharacterStates
import model.GameCharacter
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class CombatControllerSpec extends Specification{
    def attacker = Mock(GameCharacter)
    def defender = new GameCharacter(name: 'Riley', alignment: Alignment.NEUTRAL)
    def 'If a character has been hit, they have 1 hit point subtracted'(){
        attacker.rollDie() >> 10
        CombatController.standardAttack(attacker, defender)
        expect: assertThat defender.hitPoints, equalTo(4)
    }

    def 'If a character has been missed, their hp will remain the same'(){
        attacker.rollDie() >> 9
        CombatController.standardAttack(attacker, defender)
        expect: assertThat defender.hitPoints, equalTo(5)
    }

    def 'A max roll from the attacker results in a crit'(){
        attacker.rollDie() >> 20
        CombatController.standardAttack(attacker, defender)
        expect: assertThat defender.hitPoints, equalTo(3)
    }

    def 'A character who has their hp reduced to zero is dead'() {
        attacker.rollDie() >> 11
        defender.hitPoints = 1
        CombatController.standardAttack(attacker, defender)
        expect: assertThat defender.states, equalTo(CharacterStates.DEAD)
    }




}
