package model

class GameCharacter {
    Alignment alignment
    Integer armorClass = 10
    Integer hitPoints = 5
    String name

    def rollDie(){
        Math.abs(new Random().nextInt() % 20) + 1
    }
}
