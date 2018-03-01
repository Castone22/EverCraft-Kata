package model

import enums.Alignment
import enums.CharacterStates

class GameCharacter {
    Alignment alignment
    Integer armorClass = 10
    Integer hitPoints = 5
    String name
    CharacterStates states = CharacterStates.ALIVE

    def rollDie(){
        Math.abs(new Random().nextInt() % 20) + 1
    }
}
