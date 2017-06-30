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

    public void setMoney(int money) {
        this.money = money;
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

    public Symbol[] spin() throws NoMoneyInFruitMachineException {
        Symbol result[] = new Symbol[3];
        this.credits -= 1;

        for(int i=0; i<3; i++){
            result[i] = getResultSymbol();
        }

        if(this.money >= (result[0].getMultiplier() * costPerPlay)){
            return result;
        }else{
            String message = "Sorry, there's not enough money in the machine! Speak to the cigarette smoking man at the front desk.";
            throw new NoMoneyInFruitMachineException(message);
        }
    }

    public boolean didPlayerWin(Symbol result[]) {
        return (result[0] == result[1] && result[1] == result[2]);
    }
}
