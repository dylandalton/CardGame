package com.trebletreble;

public class Card {
    Suit suit;
    Value value;
    public Card(Suit s, Value v){
        this.suit=s;
        this.value=v;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
