package com.codeclan.example.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachineTest {
    FruitMachine fruitMachine;

    @Before
    public void setUp() throws Exception {
        fruitMachine = new FruitMachine(50);
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
}
