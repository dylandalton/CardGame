package com.trebletreble;

import java.util.ArrayList;

public class Player {

    String Name;
    int score;
    int balance;
    ArrayList<Card> hand = new ArrayList<>(0);

    public Player(String Name, int score, int balance, Card[] hand){

    }

    public String hit(){
        
        cardDealt = Deck.deal();
        hand.add(cardDealt);

        return hand;
    }




}
