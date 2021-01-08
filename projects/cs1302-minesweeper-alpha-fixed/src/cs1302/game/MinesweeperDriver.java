package cs1302.game;

import cs1302.game.MinesweeperGame;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;

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
            File path = new File(args[1]);
            PrintWriter gen;
            try {
                gen = new PrintWriter(path);
                Random rnd = new Random();
                int rows = Integer.valueOf(args[2]);
                int cols = Integer.valueOf(args[3]);
                int mines = Integer.valueOf(args[4]);
                gen.println(rows + " " + cols + " " + mines); // writes first line to seed file
                // array used to keep track of already generated mine locations
                boolean[][] gameGrid = new boolean[rows][cols];
                int count = 0;
                while (count != mines) {
                    // keeps generating new locations while there are duplicates
                    int r = rnd.nextInt(rows);
                    int c = rnd.nextInt(cols);
                    if (gameGrid[r][c] != true) {
                        gameGrid[r][c] = true;
                        count ++;
                    } // if
                } // while
                // writes mine locations to seed file
                for (int i = 0; i < gameGrid.length; i ++) {
                    for (int j = 0; j < gameGrid[i].length; j ++) {
                        if (gameGrid[i][j] == true) {
                            gen.println(i + " " + j);
                        } // if
                    } // for
                } // for
                gen.close();
            } catch (FileNotFoundException fnfe) {
                System.err.print("Seedfile Not Found Error: Cannot create game with " +
                                 path.getName() + ", " +
                                 "because it cannot be found\n\t\t\t  or cannot be read due to " +
                                 "permission.\n");
                System.exit(1);
            } // try-catch
        } // if
        if (args.length < 2) { // only one argument; no tokens following it
            System.err.println("Unable to interpret supplied command-line arguments.");
            System.exit(1);
        } // if
        MinesweeperGame game = new MinesweeperGame(args[1]);
        game.play();
    } // main

} // MinesweeperDriver
