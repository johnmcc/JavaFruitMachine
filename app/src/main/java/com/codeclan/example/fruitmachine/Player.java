package com.codeclan.example.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class Player {
    private int money;

    public Player(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount){
        this.money += amount;
    }
}
