package com.trebletreble;

public enum Suit {
    Hearts("♥"),
    Spades("♠"),
    Clubs("♣"),
    Diamonds("♦");
    private Suit(String icon){
        this.icon=icon;
    }
    String icon;

    public String getIcon(){
        return icon;
    }
}
