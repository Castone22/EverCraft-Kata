package model

enum Alignment {
    EVIL('Evil'),
    NEUTRAL('Neutral'),
    GOOD('Good')

    String text
    Alignment(String text){
        this.text = text
    }

}