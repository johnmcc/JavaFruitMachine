package com.codeclan.example.fruitmachine;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 30/06/2017.
 */

public class SymbolTest {
    @Test
    public void testSymbolValue() throws Exception {
        Symbol symbol = Symbol.JACKPOT;
        assertEquals(100, symbol.getMultiplier());
    }
}
