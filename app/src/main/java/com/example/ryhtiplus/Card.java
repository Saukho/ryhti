package com.example.ryhtiplus;
/**
 * @author roman, pavel, mihail, sami
 */


 //alustaa korttisivuston tiedot
 //nimi, kuva ja teksti

public class Card {
    private String name;
    private int image;
    private String cardText;

    /**
     *
     * @param name
     * @param image
     * @param cardText
     */
    public Card(String name, int image, String cardText) {
        this.name = name;
        this.image = image;
        this.cardText = cardText;
    }

    public int getImage(){return image;}

    public String getCardText() {
        return cardText;
    }

    public String getCardName() {
        return name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
