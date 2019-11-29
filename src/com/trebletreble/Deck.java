package com.trebletreble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    int numCards;
    ArrayList<Card> deck;

    static Deck singleDeck;
    public Deck(int num){
        deck = new ArrayList<Card>(0);
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card deal(){
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }
    public ArrayList<Card> dealMultiple(int num){
        ArrayList<Card> tempList = new ArrayList<>(0);
        for(int i = 0; i < num; i++){
            tempList.add(deal());
        }
        return tempList;
    }
    public void createDeck(){

    }

    public static Deck getInstance(){
        if(singleDeck==null){
            singleDeck = new Deck(52);
            return singleDeck;
        }else{
            return singleDeck;
        }
    }

}
