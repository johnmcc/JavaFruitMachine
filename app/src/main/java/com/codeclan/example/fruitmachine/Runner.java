package com.codeclan.example.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class Runner {
    public static void main(String[] args) {
        Player player = new Player(10);
        FruitMachine fruitMachine = new FruitMachine(50);
        UI ui = new UI();

        Game game = new Game(player, fruitMachine, ui);
        game.start();
    }
}
