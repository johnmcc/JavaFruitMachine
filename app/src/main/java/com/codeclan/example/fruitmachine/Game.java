package com.codeclan.example.fruitmachine;

import java.util.InputMismatchException;

/**
 * Created by user on 30/06/2017.
 */

public class Game {
    private Player player;
    private FruitMachine fruitMachine;
    private UI ui;

    public Game(Player player, FruitMachine fruitMachine, UI ui) {
        this.player = player;
        this.fruitMachine = fruitMachine;
        this.ui = ui;
    }

    public void start() {
        ui.setup();
        ui.displayPlayerMoney(player);

        askForMoney();

        while(player.getMoney() > 0 || fruitMachine.getCredits() > 0){
            String option = ui.showOptions();
            execute(option);
        }

        ui.walkAway(player);
    }

    private void execute(String option) {
        option = option.toLowerCase();
        switch(option){
            case "s":
                if(fruitMachine.getCredits() > 0){
                    takeTurn();
                }else{
                    ui.tellUserNoCredits();
                    askForMoney();
                }
                break;
            case "a":
                askForMoney();
                break;
            case "w":
                ui.walkAway(player);
                System.exit(0);
            default:
                ui.badInput();
        }
    }

    private void takeTurn() {
        Symbol result[] = new Symbol[0];

        try {
            result = fruitMachine.spin();
            ui.showResult(result);

        } catch (NoMoneyInFruitMachineException e) {
            ui.handleException(e.getMessage());
        }

        if(fruitMachine.didPlayerWin(result)){
            int cash = fruitMachine.payout(result);
            player.addMoney(cash);
        }

        ui.showPlayerCash(player);
        ui.showCredits(fruitMachine);
    }

    public void askForMoney(){
        int amount = ui.askForMoney();
        player.addMoneyToFruitMachine(fruitMachine, amount);
        ui.showPlayerCash(player);
        ui.showCredits(fruitMachine);
    }
}