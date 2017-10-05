package com.codeclan.example.fruitmachine;

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
            String option = ui.showInitialOptions();
            execute(option);
        }

        // the player has run out of money, and fruit machine credits. Sad times :(
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
            result = handlePlayerSecondPassOptions(result);
            ui.showResult(result);

        } catch (NoMoneyInFruitMachineException e) {
            ui.handleException(e.getMessage());
        }

        if(fruitMachine.didPlayerWin(result)){
            int cash = fruitMachine.payout(result);
            ui.showWin(cash);
            player.addMoney(cash);
        }

        ui.showPlayerCash(player);
        ui.showCredits(fruitMachine);
    }

    private Symbol[] handlePlayerSecondPassOptions(Symbol[] result) {
        String option = ui.showPlayerSecondPassOptions().toLowerCase();

        if(option.equals("n")) {
            // we're doing -1 here because the barrels are zero-indexed
            int nudgePos = ui.askForNudge() - 1;
            result = fruitMachine.nudge(result, nudgePos);

        }else if(option.equals("h")){
            int toHold[] = ui.askWhichToHold();
            result = fruitMachine.holdAndSpin(result, toHold);

        }else if(option.equals("s")){
            // we need to use holdAndSpin here, as it doesn't reduce the number of credits
            result = fruitMachine.holdAndSpin(result, new int[0]);
        }

        return result;
    }

    public void askForMoney(){
        int amount = ui.askForMoney();
        player.addMoneyToFruitMachine(fruitMachine, amount);
        ui.showPlayerCash(player);
        ui.showCredits(fruitMachine);
    }
}