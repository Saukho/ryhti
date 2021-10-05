package com.example.ryhtiplus;

public class Card {
    private String header;
    private int image;
    private String cardText;

    public Card(String header, int image, String cardText) {
        this.header = header;
        this.image = image;
        this.cardText = cardText;
    }

    public int getImage() {
        return image;
    }

    public String getCardText() {
        return cardText;
    }

    public String getHeader() {
        return header;
    }
}
