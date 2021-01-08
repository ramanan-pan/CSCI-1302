package cs1302.game;

import cs1302.game.MinesweeperGame;

/**
 * The MinesweeperDriver class creates an instance of the {@code MinesweeperGame} class,
 * and plays the Minesweeper Alpha game.
 */
public class MinesweeperDriver {

    public static void main(String[] args) {
        if (args.length < 1) { // empty argument
            System.err.println("Unable to interpret supplied command-line arguments.");
            System.exit(1);
        } // if
        if (!(args[0].equals("--seed"))) { // any argument other than --seed
            if (!(args[0].equals("--gen"))) { // indeterminable argument
                System.err.println("Unable to interpret supplied command-line arguments.");
                System.exit(1);
            } // if
            System.err.println("Seedfile generation not supported.");
            System.exit(2);
        } // if
        if (args.length < 2) { // only one argument; no tokens following it
            System.err.println("Unable to interpret supplied command-line arguments.");
            System.exit(1);
        } // if

        MinesweeperGame game = new MinesweeperGame(args[1]);
        game.play();

    } // main

} // MinesweeperDriver
