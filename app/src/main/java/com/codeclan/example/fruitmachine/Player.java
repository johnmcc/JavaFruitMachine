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

    public void addMoneyToFruitMachine(FruitMachine fruitMachine, int amount) {
        if(amount <= this.money){
            fruitMachine.addCredits(amount);
            this.money -= amount;
        }
    }

    public void play(FruitMachine fruitMachine) throws NoMoneyInFruitMachineException {
        Symbol result[] = fruitMachine.spin();
        if(fruitMachine.didPlayerWin(result)){
            int cash = fruitMachine.payout(result);
            addMoney(cash);
        }
    }
}
