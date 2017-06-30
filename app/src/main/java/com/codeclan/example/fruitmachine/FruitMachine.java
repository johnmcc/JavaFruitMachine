package com.codeclan.example.fruitmachine;

import java.util.Random;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachine {
    int money; // Total cash held by the machine
    int credits;
    final int costPerPlay = 1;

    public FruitMachine(int money) {
        this.money = money;
        this.credits = 0;
    }

    public int getCredits() {
        return credits;
    }

    public void addCredits(int cashAmount){
        this.money += cashAmount;
        this.credits += cashAmount / costPerPlay;
    }

    public int getMoney() {
        return money;
    }

    public void fillUp(int amount) {
        this.money += amount;
    }

    public int payout(Symbol result[]) {
        int payoutAmount = result[0].getMultiplier() * costPerPlay;
        this.money -= payoutAmount;
        return payoutAmount;
    }

    public Symbol getResultSymbol(){
        // we're abstracting this to a separate method so that we can use Mockito properly
        Symbol values[] = Symbol.values();

        Random random = new Random();
        int index = random.nextInt(values.length);
        return values[index];
    }

    public Symbol[] spin() {
        Symbol result[] = new Symbol[3];
        if(this.credits > 0){
            this.credits -= 1;

            for(int i=0; i<3; i++){
                result[i] = getResultSymbol();
            }
        }

        return result;
    }

    public boolean didPlayerWin(Symbol result[]) {
        return (result[0] == result[1] && result[1] == result[2]);
    }
}
