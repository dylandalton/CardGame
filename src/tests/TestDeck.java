package tests;

import com.trebletreble.Deck;
import com.trebletreble.Card;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestDeck {
    @Test
    public void testShuffle(){
        Deck deck1 = new Deck(52);
        deck1.createDeck();
        Deck deck2 = new Deck(52);
        deck2.createDeck();
        deck2.shuffle();
        assertFalse(deck1.getDeck().equals(deck2.getDeck()));
    }
    @Test
    public void testCreateDeck(){
        Deck deck = new Deck(52);
        deck.createDeck();
        assertTrue(deck.getDeck().size() > 0);
    }

    @Test
    public void testCardGeneration(){
        
    }
    @Test
    public void Deal(){
        Deck deck = new Deck(52);
        deck.createDeck();
        deck.shuffle();
        Card c = deck.deal();
        assertFalse(deck.getDeck().contains(c));
    }

    @Test
    public void DealNum(){
        Deck deck = new Deck(52);
        deck.createDeck();
        deck.shuffle();
        List<Card> c = deck.dealMultiple(4);
        assertFalse(deck.getDeck().contains(c));
    }

    @Test
    public void DealAll(){
        Deck deck = new Deck(52);
        deck.createDeck();
        deck.shuffle();
       // Card[] c = deck.dealAll(4);
       // assertFalse(deck.getDeck().contains(c));
    }

}
