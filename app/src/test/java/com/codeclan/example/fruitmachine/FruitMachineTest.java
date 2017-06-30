package com.codeclan.example.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachineTest {
    FruitMachine fruitMachine;
    FruitMachine spyFruitMachine;
    Player player;
    
    @Before
    public void setUp() throws Exception {
        fruitMachine = new FruitMachine(50);
        spyFruitMachine = Mockito.spy(fruitMachine);

        Symbol[] jackpot = new Symbol[] {Symbol.JACKPOT, Symbol.JACKPOT, Symbol.JACKPOT};
        Mockito.when(spyFruitMachine.spin()).thenReturn(jackpot);
        
        player = new Player(10);
        fruitMachine.setPlayer(player);
    }

    @Test
    public void testGetPlayer() throws Exception {
        assertEquals(player, fruitMachine.getPlayer());
    }

    @Test
    public void testGetMoney() throws Exception {
        assertEquals(50, fruitMachine.getMoney());
    }

    @Test
    public void testFillUpFruitMachine() throws Exception {
        fruitMachine.fillUp(50);
        assertEquals(100, fruitMachine.getMoney());
    }

    @Test
    public void testPayOut() throws Exception {
        int payout = fruitMachine.payout(10);
        assertEquals(10, payout);
        assertEquals(40, fruitMachine.getMoney());
    }

    @Test
    public void testSpin() throws Exception {
        Symbol result[] = fruitMachine.spin();
        assertNotNull(result);
    }

    @Test
    public void testWin() throws Exception {
        Symbol result[] = spyFruitMachine.spin();
        assertEquals(true, fruitMachine.didPlayerWin(result));
    }
}
