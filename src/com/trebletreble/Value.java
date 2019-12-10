package com.trebletreble;

public enum Value {

    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    King(10),
    Queen(10),
    Jack(10);

    private int value;
    private Value(int v){
        this.value=v;
    }
    public int getValue(){
        return this.value;
    }
}
