package com.example.ryhtiplus;

import java.util.ArrayList;

public class CardData {
    private static final CardData ourInstance = new CardData();
    private ArrayList<Card> cards;

    public static CardData getInstance(){ return ourInstance;}

    private CardData(){
        cards = new ArrayList<>();
        cards.add(new Card("Suojaa selkääsi",R.drawable.a1,"Hallitse keskivartaloasi"));
        cards.add(new Card("Päivittäiset harjoitukset",R.drawable.a2,"vahvista kroppaasi näillä harjoituksilla"));
        cards.add(new Card("Oikea istumisasento",R.drawable.a3,"Istu suorassa, pidä taukoja ja nouse välillä penkistä"));
        cards.add(new Card("Päätetyöharjoitukset",R.drawable.a4,"Nouse ylös penkistä ja suorista selkääsi"));

    }

    public ArrayList<Card> getCards() {
        return cards;
    }


}
