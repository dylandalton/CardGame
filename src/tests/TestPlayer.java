package tests;

import org.junit.jupiter.api.Test;

public class TestPlayer {

    @Test
    public void testHit(){
        int handCount = player1.getHandCount();
        Player player1 = new Player();
        player1.hit();
        assertTrue(handCount > 2);
    }

    @Test
    public void testSortHand(){

    }
}
