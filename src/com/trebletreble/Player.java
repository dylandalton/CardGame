package com.trebletreble;

import java.util.ArrayList;

public class Player {

    String Name;
    int score;
    int balance;


    boolean bust;
    boolean hasStuck;

    ArrayList<Card> hand;

    public Player(String Name, int balance){
        this.Name=Name;
        this.score=0;
        this.balance=balance;
        hand = new ArrayList<>(0);
        bust=false;
        hasStuck=false;
    }

    public boolean isBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        this.bust = bust;
    }

    public boolean addCard(Card c){
        boolean isBust=false;
        int val=0;
        val = getValue();
        if(val + c.getValue().getValue() > 21){
            return false;
        }else{
            this.hand.add(c);
            return true;
        }

    }

    public int getValue(){
        int val=0;
        for(Card ca : hand){
            val+=ca.getValue().getValue();
        }
        return val;
    }
    public String getHandString(){
        return hand.toString();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getBalance(){
        return balance;
    }

    public String getName() {
        return Name;
    }
    public boolean isHasStuck() {
        return hasStuck;
    }

    public void setHasStuck(boolean hasStuck) {
        this.hasStuck = hasStuck;
    }

}
