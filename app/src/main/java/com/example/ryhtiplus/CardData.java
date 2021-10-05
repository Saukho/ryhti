package com.example.ryhtiplus;

import java.util.ArrayList;

public class CardData {
    private static final CardData ourInstance = new CardData();
    private ArrayList<Card> cards;

    public static CardData getInstance(){ return ourInstance;}

    private CardData(){
        cards = new ArrayList<>();
        cards.add(new Card("Yoga", R.drawable.a1,"Yoga positions" ));
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
