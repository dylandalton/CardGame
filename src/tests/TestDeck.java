package tests;

import com.trebletreble.Deck;
import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

import static org.junit.jupiter.api.Assertions.*;


public class TestDeck {
    @Test
    public void testShuffle(){
        Deck.getInstance()
        deck1.createDeck();
        Deck deck2 = deck1;
        assertNotEquals("Shuffled deck shouldn't equal deck", deck1.getDeck(),deck2.getDeck());
    }
    @Test
    public void testCreateDeck(){
        Deck deck = new Deck();
        assertTrue(deck.getDeck().size() > 0);
    }

    @Test
    public void testCardGeneration(){
        
    }
    @Test
    public void Deal(){
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card c = deck.deal();
        assertFalse(deck.getDeck().contains(c));
    }

    @Test
    public void DealNum(){
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card[] c = deck.dealNum(4);
        assertFalse(deck.getDeck().contains(c));
    }

    @Test
    public void DealAll(){
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        Card[] c = deck.dealAll(4);
        assertFalse(deck.getDeck().contains(c));
    }

}
