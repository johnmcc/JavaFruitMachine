package com.codeclan.example.fruitmachine;

import java.util.Scanner;

/**
 * Created by user on 30/06/2017.
 */

public class UI {
    Scanner scanner;

    private final String welcome = "Welcome to Puggy!";
    private final String displayPlayerMoney = "You have £%d left.";
    private final String howMuchMoney = "How much money would you like to put in the puggy?";
    private final String displayCredits = "There are %d credits in the puggy.";
    private final String initialOptions = "press 's' to spin / 'a' to add money / 'w' to walk away";
    private final String resultString = "* %s / %s / %s *";
    private final String noCredits = "You have no credits left.";
    private final String leftWithMoney = "You left with some funds intact - £%d! Congratulations!";
    private final String leftWithNoMoney = "You leave with no money, hungry, cold, and alone.";
    private final String badInputString = "Please restrict your text to 's', 'a', or 'w'.";
    private final String playerSecondPassOptions = "Press 'h' to hold, 'n' to nudge, or 's' to re-spin all barrels.";
    private final String askForNudge = "Which barrel would you like to nudge? Type 1, 2, or 3.";
    private final String youWon = "Congratulations! You won £%d!";
    private final String askWhichToHold = "Which barrels would you like to hold? Enter numbers 1, 2, or 3 separated by a space.";

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void setup() {
        System.out.println(welcome);
    }

    public void displayPlayerMoney(Player player) {
        System.out.println(String.format(displayPlayerMoney, player.getMoney()));
        System.out.println();
    }

    public int askForMoney() {
        System.out.println(howMuchMoney);
        int amount = 0;
        if(scanner.hasNextInt()) {
            amount = scanner.nextInt();
        }

        return amount;
    }

    public void showPlayerCash(Player player) {
        System.out.println();
        System.out.println(String.format(displayPlayerMoney, player.getMoney()));
    }

    public void showCredits(FruitMachine fruitMachine) {
        System.out.println(String.format(displayCredits, fruitMachine.getCredits()));
        System.out.println();
    }

    public String showInitialOptions() {
        System.out.println(initialOptions);
        return scanner.next();
    }

    public void showResult(Symbol[] result) {
        String formatted = String.format(resultString, result[0], result[1], result[2]);
        int formattedLength = formatted.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<formattedLength; i++){
            sb.append("*");
        }

        System.out.println(sb.toString());
        System.out.println(formatted);
        System.out.println(sb.toString());
    }

    public void handleException(String message) {
        System.out.println(message);
    }

    public void tellUserNoCredits() {
        System.out.println(noCredits);
    }

    public void walkAway(Player player) {
        System.out.println();
        if(player.getMoney() > 0){
            System.out.println(String.format(leftWithMoney, player.getMoney()));
        }else{
            System.out.println(leftWithNoMoney);
        }
    }

    public void badInput() {
        System.out.println(badInputString);
    }

    public String showPlayerSecondPassOptions() {
        System.out.println(playerSecondPassOptions);
        return scanner.next();
    }

    public int askForNudge() {
        System.out.println(askForNudge);
        return scanner.nextInt();
    }

    public void showWin(int cash) {
        System.out.println(String.format(youWon, cash));
    }

    public int[] askWhichToHold() {
        int[] toHold = new int[0];

        System.out.println(askWhichToHold);

        // we need to throw in an extra scanner.nextLine() here so that java ignores the new line :(
        scanner.nextLine();
        String toHoldString = scanner.nextLine();

        if(toHoldString.length() > 0){
            toHold = TextUtils.parseStringToIntArray(toHoldString);
        }

        return toHold;
    }
}
