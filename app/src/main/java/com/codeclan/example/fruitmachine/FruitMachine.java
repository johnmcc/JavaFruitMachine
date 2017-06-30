package com.codeclan.example.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachine {
    int money;

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
        return new Symbol[0];
    }
}
