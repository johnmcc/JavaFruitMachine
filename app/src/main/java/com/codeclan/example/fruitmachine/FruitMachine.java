package com.codeclan.example.fruitmachine;

import java.util.Random;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachine {
    int money; // Total cash held by the machine

    public FruitMachine(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void fillUp(int amount) {
        this.money += amount;
    }

    public int payout(int amount) {
        this.money -= amount;
        return amount;
    }

    public Symbol[] spin() {
        Symbol values[] = Symbol.values();
        Symbol result[] = new Symbol[3];

        for(int i=0; i<3; i++){
            Random random = new Random();
            int index = random.nextInt(values.length);
            result[i] = values[index];
        }

        return result;
    }

    public boolean didPlayerWin(Symbol result[]) {
        return (result[0] == result[1] && result[1] == result[2]);
    }
}
