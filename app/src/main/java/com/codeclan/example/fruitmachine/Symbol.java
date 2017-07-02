package com.codeclan.example.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public enum Symbol {
    JACKPOT(100),
    SEVEN(50),
    CHERRY(40),
    BAR(30),
    LIME(20),
    BELL(20),
    HORSESHOE(5);

    private final int multiplier;

    Symbol(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
