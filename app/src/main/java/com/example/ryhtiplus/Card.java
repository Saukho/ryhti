package com.example.ryhtiplus;

public class Card {
    private String name;
    private int image;
    private String cardText;

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
