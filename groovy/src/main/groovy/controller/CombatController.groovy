package controller

import enums.CharacterStates
import model.GameCharacter

class CombatController {
    def static standardAttack(GameCharacter attacker, GameCharacter defender){
        def attackersRoll = attacker.rollDie()
        if(attackersRoll == 20) {
            defender.hitPoints -= 2
        } else if( attackersRoll >= defender.armorClass ) {
            defender.hitPoints -= 1
        }
        if(defender.hitPoints <= 0){
            defender.states = CharacterStates.DEAD
        }
    }
}
