package com.example.ryhtiplus;

import java.util.ArrayList;

/**
 * @author roman, pavel, mihail, sami
 */
public class CardData {

    private static final CardData ourInstance = new CardData();
    private ArrayList<Card> cards;

    /**
     * @return ourInstance
     */
    public static CardData getInstance(){ return ourInstance;}

    /**
     * @return  lisää korttilistaan tiedot
     */
    private CardData(){
        cards = new ArrayList<>();
        cards.add(new Card("Suojaa selkääsi",R.mipmap.a1,"Hallitse keskivartaloasi"));
        cards.add(new Card("Päivittäiset harjoitukset",R.drawable.a2,"vahvista kroppaasi näillä harjoituksilla"));
        cards.add(new Card("Oikea istumisasento",R.drawable.a3,"Istu suorassa, pidä taukoja ja nouse välillä penkistä"));
        cards.add(new Card("Päätetyöharjoitukset",R.mipmap.a4,"Nouse ylös penkistä ja suorista selkääsi"));

    }

    /**
     *
     * @return cards with name, image and text
     */
    public ArrayList<Card> getCards() {
        return cards;
    }


}
