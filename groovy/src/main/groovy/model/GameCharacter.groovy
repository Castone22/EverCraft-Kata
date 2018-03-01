package model

import enums.AbilityScore
import enums.Alignment
import enums.CharacterStates

import static enums.AbilityScore.*

class GameCharacter {
    Alignment alignment
    Integer armorClass = 10
    Integer hitPoints = 5
    String name
    CharacterStates states = CharacterStates.ALIVE
    def abilityScores = [:]

    GameCharacter(){
        AbilityScore.values().each{it ->
            abilityScores[it] = 10
        }
    }

    def static rollDie(){
        Math.abs(new Random().nextInt() % 20) + 1
    }
}
