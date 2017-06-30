package com.codeclan.example.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 30/06/2017.
 */

public class PlayerTest {
    Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(10);
    }

    @Test
    public void testGetMoney() throws Exception {
        assertEquals(10, player.getMoney());
    }

    @Test
    public void testAddMoney() throws Exception {
        player.addMoney(5);
        assertEquals(15, player.getMoney());
    }
}