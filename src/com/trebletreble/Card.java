package com.trebletreble;

public class Card {
    String suit;
    String value;
    public Card(String s, String v){
        this.suit=s;
        this.value=v;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
