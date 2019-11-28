package tests;

import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

import static org.junit.jupiter.api.Assertions.*;


public class TestDeck {
    @Test
    public void testShuffle(){
        Deck deck1 = new Deck();
        deck1.createDeck();
        Deck deck2 = deck1;
        assertNotEquals("Shuffled deck shouldnt equal deck", deck1.getDeck(),deck2.getDeck());
    }
    @Test
    public void testCreateDeck(){
        Deck deck = new Deck();
        assertTrue(deck.getDeck().size() > 0);
    }

    @Test
    public void Deal(){
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card c = deck.deal();



    }

    @Test
    public void DealNum(){

    }

    @Test
    public void DealAll(){

    }

    @Test
    public void canPlay(){

    }
}
