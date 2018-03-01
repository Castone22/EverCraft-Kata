package controller

import model.GameCharacter

class CombatController {
    def static standardAttack(GameCharacter attacker, GameCharacter defender){
        def result = attacker.rollDie() >= defender.armorClass
        if(result){ defender.hitPoints -= 1 }
    }

}
