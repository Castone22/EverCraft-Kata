package controller

import model.Alignment
import model.GameCharacter
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo

class CombatControllerSpec extends Specification{
    def attacker = Mock(GameCharacter)
    def defender = new GameCharacter(name: 'Riley', alignment: Alignment.NEUTRAL)
    def 'If a character has been hit, they have 1 hit point subtracted'(){
        attacker.rollDie() >> 11
        CombatController.standardAttack(attacker, defender)
        expect: assertThat defender.hitPoints, equalTo(4)
    }

}
