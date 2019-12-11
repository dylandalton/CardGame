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



    Player[] players;
    Scanner scanner;
    Dealer dealer;
    int numPlayers;
    public Main(){
        scanner = new Scanner(System.in);
        System.out.println("How many players");
        numPlayers = scanner.nextInt();
        players=new Player[numPlayers+1];
        Deck.getInstance().createDeck();

    }
    public void setup(){
        Deck.getInstance().createDeck();
        Deck.getInstance().shuffle();
        players[0] = new Player("Dealer",2000);
        players[0].addCard(Deck.getInstance().deal());
        players[0].addCard(Deck.getInstance().deal());
        for(int i = 1; i < numPlayers+1;i++){
            System.out.println("Player " + (i) + " what is your name?");
            String name = scanner.next();
            players[i] = new Player(name, 100);
            players[i].addCard(Deck.getInstance().deal());
            players[i].addCard(Deck.getInstance().deal());
        }
    }
    public void run(){
        boolean isRunning=true;
        int stuckStreak=0;
        while(isRunning){

            for(int i = 1; i < players.length;i++) {
                if (!players[i].isBust()) {
                    while(!players[i].isHasStuck() && !players[i].isBust()) {
                        System.out.println(ANSI_PURPLE + players[0].getHandString() + " - " + players[0].getValue() + ANSI_RESET);
                        System.out.println(ANSI_RED + players[i].getName() + "'s turn" + ANSI_RESET);
                        System.out.println(ANSI_BLUE + players[i].getHand().toString() + " - " + ANSI_GREEN + players[i].getValue() + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "What would you like to do?" + ANSI_RESET);
                        System.out.println("1. Hit");
                        System.out.println("2. Stick");
                        int choice = scanner.nextInt();
                        if (choice == 2) {
                            players[i].setHasStuck(true);
                            stuckStreak += 1;
                            continue;
                        } else {
                            Card tempCard = Deck.getInstance().deal();
                            System.out.println("New Card: " + tempCard.toString());
                            if (players[i].addCard(tempCard)) {
                                System.out.println(ANSI_GREEN + "Card dealt!" + ANSI_RESET);
                            } else {
                                System.out.println(ANSI_YELLOW + "You've went bust!" + ANSI_RESET);
                                stuckStreak += 1;
                                players[i].setBust(true);
                            }
                        }
                    }
                }
                }
            System.out.println("Streak: " + stuckStreak );
                if(stuckStreak==numPlayers) {
                   isRunning=false;
                }
            }
            while(players[0].getValue()<17){
                players[0].addCard(Deck.getInstance().deal());
               // System.out.println(players[0].getHandString());
            }
            System.out.println(ANSI_PURPLE + players[0].getHandString() + ANSI_RESET);
            for(int i =1;i<players.length;i++){
                if(!players[i].isBust()) {
                    if (players[i].getValue() > players[0].getValue()) {
                        System.out.println(players[i].getName() + " has won!");
                    } else if (players[i].getValue() == players[0].getValue()) {
                        System.out.println(players[i].getName() + " drew with the dealer");
                    } else {
                        System.out.println(players[i].getName() + " lost against the dealer");
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
