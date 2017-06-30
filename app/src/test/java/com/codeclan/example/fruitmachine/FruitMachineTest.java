package com.codeclan.example.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

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

        Mockito.when(spyFruitMachine.getResultSymbol()).thenReturn(Symbol.JACKPOT);

        player = new Player(10);
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
        Symbol result[] = new Symbol[]{Symbol.JACKPOT, Symbol.JACKPOT, Symbol.JACKPOT};
        int payout = fruitMachine.payout(result);
        assertEquals(10, payout);
        assertEquals(40, fruitMachine.getMoney());
    }

    @Test
    public void testInitialCredits() throws Exception {
        assertEquals(0, fruitMachine.getCredits());
    }

    @Test
    public void testPlayerEnterMoney() throws Exception {
        player.addMoneyToFruitMachine(fruitMachine, 5);
        assertEquals(5, player.getMoney());
        assertEquals(55, fruitMachine.getMoney());
        assertEquals(5, fruitMachine.getCredits());
    }

    @Test
    public void testSpin() throws Exception {
        Symbol result[] = fruitMachine.spin();
        assertNotNull(result);
    }

    @Test
    public void testWinCondition() throws Exception {
        Symbol result[] = spyFruitMachine.spin();
        assertEquals(true, fruitMachine.didPlayerWin(result));
    }

    @Test
    public void testWin() throws Exception {
        player.addMoneyToFruitMachine(spyFruitMachine, 5);
        player.play(spyFruitMachine);

        // Player buys 5 credits, spins once (4 credits), wins 10 * stake - £10

        assertEquals(4, spyFruitMachine.getCredits());
        assertEquals(45, spyFruitMachine.getMoney());
        assertEquals(15, player.getMoney());
    }

    @Test
    public void testMachineOnlyPaysOutUpToCashAmount(){
        spyFruitMachine.setMoney(0);

        player.addMoneyToFruitMachine(spyFruitMachine, 5);
        try {
            player.play(spyFruitMachine);
            fail("The fruit machine didn't throw a NoMoneyInFruitMachine error.");
        } catch (NoMoneyInFruitMachineException e) {}
    }
}
