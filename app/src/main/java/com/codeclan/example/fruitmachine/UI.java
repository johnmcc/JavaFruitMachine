package com.codeclan.example.fruitmachine;

import java.util.Scanner;

/**
 * Created by user on 30/06/2017.
 */

public class UI {
    Scanner scanner;

    private final String welcomeString = "Welcome to Puggy!";
    private final String displayPlayerMoneyString = "You have £%d left.";
    private final String howMuchMoneyString = "How much money would you like to put in the puggy?";
    private final String displayCreditsString = "There are %d credits in the puggy.";
    private final String initialOptionsString = "press 's' to spin / 'a' to add money / 'w' to walk away";
    private final String resultString = "* %s / %s / %s *";
    private final String noCreditsString = "You have no credits left.";
    private final String leftWithMoneyString = "You left with some funds intact - £%d! Congratulations!";
    private final String leftWithNoMoneyString = "You leave with no money, hungry, cold, and alone.";
    private final String badInputString = "Please restrict your text to 's', 'a', or 'w'.";
    private final String playerSecondPassOptionsString = "Press 'h' to hold, 'n' to nudge, or 's' to re-spin all barrels.";
    private final String askForNudgeString = "Which barrel would you like to nudge? Type 1, 2, or 3.";
    private final String youWonString = "Congratulations! You won £%d!";
    private final String askWhichToHoldString = "Which barrels would you like to hold? Enter numbers 1, 2, or 3 separated by a space.";

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void setup() {
        System.out.println(welcomeString);
    }

    public void displayPlayerMoney(Player player) {
        System.out.println(String.format(displayPlayerMoneyString, player.getMoney()));
        System.out.println();
    }

    public int askForMoney() {
        System.out.println(howMuchMoneyString);
        int amount = 0;
        if(scanner.hasNextInt()) {
            amount = scanner.nextInt();
        }

        return amount;
    }

    public void showPlayerCash(Player player) {
        System.out.println();
        System.out.println(String.format(displayPlayerMoneyString, player.getMoney()));
    }

    public void showCredits(FruitMachine fruitMachine) {
        System.out.println(String.format(displayCreditsString, fruitMachine.getCredits()));
        System.out.println();
    }

    public String showInitialOptions() {
        System.out.println(initialOptionsString);
        return scanner.next();
    }

    public void showResult(Symbol[] result) {
        String formatted = String.format(resultString, result[0], result[1], result[2]);
        String stars = TextUtils.getStars(formatted.length());

        System.out.println(stars);
        System.out.println(formatted);
        System.out.println(stars);
    }

    public void handleException(String message) {
        System.out.println(message);
    }

    public void tellUserNoCredits() {
        System.out.println(noCreditsString);
    }

    public void walkAway(Player player) {
        System.out.println();
        if(player.getMoney() > 0){
            System.out.println(String.format(leftWithMoneyString, player.getMoney()));
        }else{
            System.out.println(leftWithNoMoneyString);
        }
    }

    public void badInput() {
        System.out.println(badInputString);
    }

    public String showPlayerSecondPassOptions() {
        System.out.println(playerSecondPassOptionsString);
        return scanner.next();
    }

    public int askForNudge() {
        System.out.println(askForNudgeString);
        return scanner.nextInt();
    }

    public void showWin(int cash) {
        System.out.println(String.format(youWonString, cash));
    }

    public int[] askWhichToHold() {
        int[] toHold = new int[0];

        System.out.println(askWhichToHoldString);

        // we need to throw in an extra scanner.nextLine() here so that java ignores the new line :(
        scanner.nextLine();
        String toHoldString = scanner.nextLine();

        if(toHoldString.length() > 0){
            toHold = TextUtils.parseStringToIntArray(toHoldString);
        }

        return toHold;
    }
}
