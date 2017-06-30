package com.codeclan.example.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public enum Symbol {
    JACKPOT(10),
    SEVEN(7),
    CHERRY(5),
    BAR(3),
    LIME(2),
    BELL(2),
    HORSESHOE(1);

    private final int multiplier;

    Symbol(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
