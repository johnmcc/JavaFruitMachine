package com.codeclan.example.fruitmachine;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachine {
    private int money; // Total cash held by the machine
    private int credits;
    private final int costPerPlay = 1;

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
        // Reduce the number of credits
        this.credits -= 1;

        // Construct an array of three random symbols
        Symbol result[] = new Symbol[3];
        for(int i=0; i<3; i++){
            result[i] = getResultSymbol();
        }

        // Check that we have enough money to pay out, otherwise throw an exception
        int potentialPrizeAmount = result[0].getMultiplier() * costPerPlay;

        if(this.money >= potentialPrizeAmount){
            return result;
        }else{
            String message = "Sorry, there's not enough money in the machine! " +
                    "Speak to the cigarette smoking man at the front desk.";
            throw new NoMoneyInFruitMachineException(message);
        }
    }

    public boolean didPlayerWin(Symbol result[]) {
        return (result[0] == result[1] && result[1] == result[2]);
    }


    public Symbol[] nudge(Symbol[] result, int index) {
        // Get all symbols, as a list
        Symbol values[] = Symbol.values();

        // Get the symbol that the user wants to change
        Symbol currentSymbol = result[index];

        // Get the current symbol's position in the array of all symbols
        int currentIndex = 0;
        for(int i=0; i<values.length; i++){
            if(values[i] == currentSymbol){
                currentIndex = i;
                break;
            }
        }

        // Get the index of the next symbol, looping back round to zero if necessary
        int nextIndex = currentIndex + 1;
        if(nextIndex >= values.length) {
            nextIndex = 0;
        }

        // Set the new symbol in the result array at the appropriate index
        result[index] = values[nextIndex];
        return result;
    }

    public Symbol[] holdAndSpin(Symbol[] result, int[] toHold) {
        // for each Symbol in the result array...
        for(int i = 0; i<3; i++){

            // check to see if the index is in the array toHold
            boolean found = false;
            for(int j : toHold){
                if(i == j){
                    found = true;
                }
            }

            // if the index isn't in toHold, get a new symbol for this index
            if(!found){
                result[i] = getResultSymbol();
            }
        }

        return result;
    }
}
