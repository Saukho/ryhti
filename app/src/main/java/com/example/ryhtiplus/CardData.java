package com.example.ryhtiplus;

import java.util.ArrayList;

public class CardData {
    private static final CardData ourInstance = new CardData();
    private ArrayList<Card> cards;

    public static CardData getInstance(){ return ourInstance;}

    private CardData(){
        cards = new ArrayList<>();
        cards.add(new Card("Do your daily exercises correctly",R.drawable.a1,"Support your back and neck"));
        cards.add(new Card("Daily workout while break",R.drawable.a2,"strengthen your body with these exercises"));
        cards.add(new Card("Correct sitting position",R.drawable.a3,"Sit straight"));
        cards.add(new Card("Desk exercises",R.drawable.a4,"Support your back and lift your butt up"));

    }

    public ArrayList<Card> getCards() {
        return cards;
    }


}
