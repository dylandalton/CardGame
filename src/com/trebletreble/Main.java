package com.trebletreble;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    Deck deck;
    Player[] players;
    Scanner scanner;
    Dealer dealer;
    int numPlayers;
    public Main(){
        scanner = new Scanner(System.in);
        System.out.println("How many players");
        numPlayers = scanner.nextInt();
        players=new Player[numPlayers];
        deck = new Deck(52);

    }
    public void setup(){
        deck.createDeck();
        deck.shuffle();
        for(int i = 0; i < numPlayers;i++){
            System.out.println("Player " + (i+1) + " what is your name?");
            String name = scanner.next();
            players[i] = new Player(name, 100);
            players[i].addCard(deck.deal());
            players[i].addCard(deck.deal());
        }
    }
    public void run(){
        boolean isRunning=true;
        while(isRunning){
            for(int i = 0; i < players.length;i++) {
                if (!players[i].isBust()) {
                    System.out.println(ANSI_RED+players[i].getName() + "'s turn"+ANSI_RESET);
                    System.out.println(ANSI_BLUE + players[i].getHand().toString() + "-" + players[i].getValue() + ANSI_RESET);
                    System.out.println("What would you like to do?");
                    System.out.println("1. Hit");
                    System.out.println("2. Stick");
                    int choice = scanner.nextInt();
                    if (choice == 2) {
                        continue;
                    } else {
                        Card tempCard = deck.deal();
                        System.out.println("New Card: "+tempCard.toString());
                        if (players[i].addCard(tempCard)) {
                            System.out.println(ANSI_GREEN+"Card dealt!"+ANSI_RESET);
                        } else {
                            System.out.println(ANSI_YELLOW+"You've went bust!"+ANSI_RESET);
                            players[i].setBust(true);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
	    Main main = new Main();
	    main.setup();
	    main.run();
    }
}
