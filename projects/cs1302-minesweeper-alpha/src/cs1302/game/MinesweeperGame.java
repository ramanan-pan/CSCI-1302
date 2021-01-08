package cs1302.game;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

/**
 * This class represents a game of Minesweeper Alpha.
 */
public class MinesweeperGame {

    /** Number of rows of game grid determined by seed file.  */
    private int rows;

    /** Number of columns of game grid determined by seed file.  */
    private int cols;

    /** {@code String} array representing the game grid.  */
    private String[][] gameGrid;

    /** {@code boolean} array representing the mines in the mine field.  */
    private boolean[][] mineGrid;

    /** Number of mines in the mine field determined by seed file.  */
    private int mines;

    /** Holds the number of rounds played.  */
    private int rounds;

    /** Flag used in {@link #printMineField()} method to keep track of nofog command. */
    private boolean noFogOn;

    /** {@code File} object which represents the seed file.  */
    private File seedFile;

    /** (@code Scanner} object used to parse the contents of the seed file.  */
    private Scanner configScanner;

    /** {@code Scanner} object used to take in user input. */
    private Scanner commandScan = new Scanner(System.in);

    /** {@code Scanner} object used to parse user commands. */
    private Scanner commandParse;

    /** {@code String} var. that holds entire user command.  */
    private String command = " ";

    /** {@code String} array that holds the individual tokens of a user command. */
    private String[] token = new String[3];

    /** {@code int} array that hold the integer values of the tokens of a user command. */
    private int[] intToken = new int[2];

    /**
     * Constructs a {@code MinesweeperGame} object with configurations from a seed file.
     *
     * @param seed {@code String} representation of the path to the seed file
     */
    public MinesweeperGame(String seed) {
        try {
            seedFile = new File(seed);
            configScanner = new Scanner(seedFile);

            this.rows = configScanner.nextInt();
            this.cols = configScanner.nextInt();
            this.mines = configScanner.nextInt();

            if ((rows < 5) || (cols < 5)) { // rows and/or columns outside of accepted range
                System.out.println("\nSeedfile Value Error: Cannot create a mine field with" +
                                   " that many rows and/or columns!");
                System.exit(3);
            } // if
            if (mines > rows * cols) { // more mines than squares/tiles
                System.err.print("Seedfile Format Error: Cannot create game with " +
                             seedFile.getName() + ", because it is not formatted correctly.\n");
                System.exit(1);
            } // if

            gameGrid = new String[rows][cols];
            mineGrid = new boolean[rows][cols];

            // loop checks each mine location, then adds to mineGrid array
            for (int i = 0; i < this.mines; i++) {
                int row = configScanner.nextInt();
                int col = configScanner.nextInt();
                if (isInBounds(row,col)) {
                    this.mineGrid[row][col] = true;
                } else { // prints error and exits if mine is not in bounds
                    System.err.print("Seedfile Format Error: Cannot create game with " +
                             seedFile.getName() + ", because it is not formatted correctly.\n");
                    System.exit(1);
                } // if
            } // for
        } catch (FileNotFoundException fnfe) {
            System.err.print("Seedfile Not Found Error: Cannot create game with " +
                             seedFile.getName() + ", " +
                             "because it cannot be found\n\t\t\t  or cannot be read due to " +
                             "permission.\n");
            System.exit(1);
        } catch (InputMismatchException ime) {
            System.err.print("Seedfile Format Error: Cannot create game with " +
                             seedFile.getName() + ", because it is not formatted correctly.\n");
            System.exit(1);
        } catch (NoSuchElementException nsee) {
            System.err.print("Seedfile Format Error: Cannot create game with " +
                             seedFile.getName() + ", because it is not formatted correctly.\n");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.print("Seedfile Format Error: Cannot create game with " +
                             seedFile.getName() + ", because it is not formatted correctly.\n");
            System.exit(1);
        } // try-catch
    } // MinesweeperGame

    /**
     * Prints a welcome message banner to standard output.
     */
    public void printWelcome() {
        System.out.print("        _\n" +
                         "  /\\/\\ (_)_ __   ___  _____      _____  ___ _ __   ___ _ __\n" +
                         " /    \\| | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|" +
                         "\n/ /\\/\\ \\ | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |\n" +
                         "\\/    \\/_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|\n" +
                         "                 A L P H A   E D I T I O N |_| v2020.sp\n");
    } // printWelcome

    /**
     * Prints the current contents of the mine field/grid to standard output.
     * Employs the private helper methods {@link #getPad(int)} and {@link #getSquare(int,int)}.
     * Includes implementation for the nofog command.
     */
    public void printMineField() {
        int i = 0; // row index
        int j = 0; // col index

        int rowPad = getPad(gameGrid.length); // gets necessary padding for largest index
        int colPad = getPad(gameGrid[i].length); // gets necessary padding for largest index

        System.out.print("\n Rounds Completed: " + rounds + "\n\n");

        for (i = 0; i < gameGrid.length; i++) { // prints board with delineated rows and columns
            System.out.print(" ");
            System.out.printf("%" + (rowPad)  + "d", i);
            System.out.print(" |");
            for (j = 0; j < gameGrid[i].length; j++) {
                if (noFogOn && mineGrid[i][j] == true) { // prints '<' & '>' for nofog command
                    System.out.print("<");
                    System.out.printf("%" + (colPad)  + "s", getSquare(i,j));
                    System.out.print(">");
                } else { // nofog command not applied
                    System.out.print(" ");
                    System.out.printf("%" + (colPad) + "s", getSquare(i,j));
                    System.out.print(" ");
                } // if
                System.out.print("|");
            } // for
            System.out.println();
        } // for

        // padding for last printed line for col numbers
        System.out.print(" ");
        System.out.printf("%" + (rowPad) + "s", " ");
        System.out.print("  ");

        for (int k = 0; k < gameGrid[0].length; k++) { // loop prints col numbers w/ proper padding
            System.out.print(" ");
            System.out.printf("%" + (colPad) + "d", k);
            System.out.print("  ");
        } // for
        System.out.print("\n\n");

        noFogOn = false;
    } // printMineField

    /**
     * Returns an int value that is employed in the {@link #printMineField()} method to format
     * the printing of rows and columns when displaying the game grid.
     *
     * @param length the length of a row or column
     * @return the int value that represents the required amount of padding
     */
    private int getPad(int length) {
        if (length == 0 || length == 1) {
            return 1;
        } // if
        double numDigits = Math.ceil(Math.log10(length));
        return (int) numDigits;
    } // getPad

    /**
     * Returns the {@code String} value that is in a given square on the game grid.
     * Accounts or checks for null values.
     *
     * @param row the row index
     * @param col the column index
     * @return {@code String} value representing the square of the game grid
     */
    private String getSquare(int row, int col) {
        String square = gameGrid[row][col];
        if (square == null) { // null check
            square = " ";
        } // if
        return square;
    } // getSquare

    /**
     * Prints the game prompt to standard output and interprets user input/commands,
     * such as reveal, mark, guess, nofog, guess, help, and quit.
     *
     * Employs the methods
     * {@link #commandCheck()}, {@link #getNumAdjMines(int,int)}, {@link #isWon()},
     * {@link #printWin()}, {@link #printWin()}, {@link #isLost()}, and {@link #printLoss()}.
     *
     * Increments the {@code rounds} instance variable with every valid command.
     */
    public void promptUser() {
        command = " ";
        System.out.print("minesweeper-alpha: ");
        command = commandScan.nextLine(); // user input
        commandParse = new Scanner(command); // parses String
        token[0] = commandParse.next().trim();
        boolean isValid = commandCheck(); // assigns boolean val. for validity of command
        String adjMines = " "; // used to circumvent characters per line style convention

        if (token[0].equals("r") || token[0].equals("reveal")) { // reveal
            if (isValid) {
                adjMines = Integer.toString(getNumAdjMines(intToken[0],intToken[1]));
                gameGrid[intToken[0]][intToken[1]] = adjMines;
                rounds ++;
                if (isWon()) { // checks if game is won
                    printWin();
                    System.exit(0);
                } // if
                if (isLost()) { // checks if mine is revealed
                    printLoss();
                    System.exit(0);
                } // if
            } else {
                System.out.print("\nInput Error: Command not recognized!\n");
            } // if
        } else if (token[0].equals("m") || token[0].equals("mark")) { // mark
            if (isValid) {
                gameGrid[intToken[0]][intToken[1]] = "F";
                rounds ++;
                if (isWon()) { // checks if game is won
                    printWin();
                    System.exit(0);
                } // if
            } else {
                System.out.print("\nInput Error: Command not recognized!\n");
            } // if
        } else if (token[0].equals("g") || token[0].equals("guess")) { // guess
            if (isValid) {
                gameGrid[intToken[0]][intToken[1]] = "?";
                rounds ++;
            } else {
                System.out.print("\nInput Error: Command not recognized!\n");
            } // if
        } else if (token[0].equals("nofog")) { // nofog
            noFogOn = true;
        } else if (token[0].equals("h") || token[0].equals("help")) {
            System.out.print("\nCommands Available...\n - Reveal: r/reveal row col" +
                             "\n -   Mark: m/mark   row col\n -  Guess: g/guess  row col" +
                             "\n -   Help: h/help\n -   Quit: q/quit\n");
            rounds ++;
        } else if (token[0].equals("q") || token[0].equals("quit")) { // quit
            System.out.print("\nQuitting the game...\nBye!\n");
            System.exit(0);
        } else {
            System.out.print("\nInput Error: Command not recognized!\n");
        } // if
    } // promptUser()

    /**
     * Parses through the tokens of a player command and validates them.
     * Employed by the {@link #promptUser()} method.
     *
     * @return true if the command is valid (correct type and number); false otherwise
     */
    private boolean commandCheck() {
        boolean isValid = true;

        // tokens after reveal, guess, and mark commands should all be integers
        if (commandParse.hasNextInt()) {
            intToken[0] = commandParse.nextInt();
            if (commandParse.hasNextInt()) {
                intToken[1] = commandParse.nextInt();
                if (commandParse.hasNext()) { // should only have 2 tokens after main command token
                    isValid = false;
                } // if
                // format may be correct, but command should do something in bounds of game grid
                if (isInBounds(intToken[0],intToken[1]) == false) {
                    isValid = false;
                } // if
            } else {
                isValid = false;
            } // if
        } else {
            isValid = false;
        } // if

        return isValid;
    } // commandCheck

    /**
     * Returns boolean value based on if the player has met the following conditions,
     * which represent whether the game is won or not:
     *
     * (1) All squares containing a mine are marked as definitely containing a mine; and
     * (2) All squares not containing a mine are revealed.
     *
     * Employed by the {@link #promptUser()} and {@link #play()} methods.
     *
     * @return true if all conditions are met; false otherwise
     */
    public boolean isWon() {
        // checks if any squares are still null, or untouched
        for (int i = 0; i < gameGrid.length; i ++) {
            for (int j = 0; j < gameGrid[i].length; j ++) {
                if (gameGrid[i][j] == null) {
                    return false;
                } // if
            } // for
        } // for
        // checks if any mines are not marked
        for (int i = 0; i < mineGrid.length; i ++) {
            for (int j = 0; j < mineGrid[i].length; j ++) {
                if ((mineGrid[i][j] == true) && !(gameGrid[i][j].equals("F"))) {
                    return false;
                } // if
            } // for
        } // for
        return true;
    } // isWon

    /**
     * Returns boolean value based on if the player has revealed a mine,
     * which decides if the game is lost or not. Employed by the {@link #promptUser()} method.
     *
     * @return true if a mine has been revealed; false otherwise
     */
    public boolean isLost() {
        boolean isLost = false;
        // checks if any mines are revealed
        for (int i = 0; i < mineGrid.length; i ++) {
            for (int j = 0; j < mineGrid[0].length; j ++) {
                if (mineGrid[i][j] == true) {
                    if (gameGrid[i][j] != null) {
                        if (Character.isDigit(gameGrid[i][j].charAt(0))) {
                            isLost = true;
                        } // if
                    } // if
                } // if
            } // for
        } // for

        return isLost;
    } // isLost

    /**
     * Prints the win message to standard output, which includes the player's final score.
     * Called by the {@link #promptUser()} method when the conditions for winning are met.
     */
    public void printWin() {
        System.out.print("\n ░░░░░░░░░▄░░░░░░░░░░░░░░▄░░░░ \"So Doge\"\n" +
                         " ░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌░░░\n" +
                         " ░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐░░░ \"Such Score\"\n" +
                         " ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐░░░\n" +
                         " ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐░░░ \"Much Minesweeping\"\n" +
                         " ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌░░░\n" +
                         " ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌░░ \"Wow\"\n" +
                         " ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐░░\n" +
                         " ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌░\n" +
                         " ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌░\n" +
                         " ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐░\n" +
                         " ▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌\n" +
                         " ▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐░\n" +
                         " ░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌░\n" +
                         " ░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐░░\n" +
                         " ░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌░░\n" +
                         " ░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀░░░ CONGRATULATIONS!\n" +
                         " ░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀░░░░░ YOU HAVE WON!\n" +
                         " ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀░░░░░░░░ SCORE: ");
        System.out.printf("%.2f", 100.0 * rows * cols / rounds);
        System.out.println();
    } // printWin

    /**
     * Prints the loss message to standard output. Called by the {@link #promptUser()} method
     * when the player uncovers a mine.
     */
    public void printLoss() {
        System.out.print("\n Oh no... You revealed a mine!\n" +
                         "  __ _  __ _ _ __ ___   ___    _____   _____ _ __\n" +
                         " / _` |/ _` | '_ ` _ \\ / _ \\  / _ \\ \\ / / _ \\ '__|\n" +
                         "| (_| | (_| | | | | | |  __/ | (_) \\ V /  __/ |\n" +
                         " \\__, |\\__,_|_| |_| |_|\\___|  \\___/ \\_/ \\___|_|\n" +
                         " |___/\n");
    } // printLoss

    /**
     * Provides and runs the main game loop by invoking the {@link #printWelcome()},
     * {@link #printMineField()}, {@link #isWon()}, and {@link #promptUser()} methods.
     */
    public void play() {
        printWelcome();
        printMineField();
        while (!(isWon())) {
            promptUser();
            printMineField();
        } // while
    } // play

    /**
     * Returns the number of mines adjacent to the specified
     * square in the grid.
     *
     * @param row the row index of the square
     * @param col the column index of the square
     * @return the number of adjacent mines
     */
    private int getNumAdjMines(int row, int col) {
        int numOfMines = 0;

        int rowBound1 = row;
        int rowBound2 = row;

        int colBound1 = col;
        int colBound2 = col;

        if (row - 1 >= 0) { // checks if there is row above square
            rowBound1 = row - 1;
        }
        if (row + 1 < mineGrid.length) { // checks if there is row below square
            rowBound2 = row + 1;
        }
        if (col - 1 >= 0) { // checks if there is col left of square
            colBound1 = col - 1;
        }
        if (col + 1 < mineGrid[0].length) { // checks if there is col right of square
            colBound2 = col + 1;
        }

        for (int i = rowBound1; i <= rowBound2; i++) { // counts mines in bounded region
            for (int j = colBound1; j <= colBound2; j++) {
                if (mineGrid[i][j] == true) {
                    numOfMines ++;
                } // if
            } // for
        } // for

        return numOfMines;
    } // getNumAdjMines

    /**
     * Indicates whether or not the square is in the game grid.
     *
     * @param row the row index of the square
     * @param col the column index of the square
     * @return true if the square is in the game grid; false otherwise
     */
    private boolean isInBounds(int row, int col) {
        if ((row < 0) || (col < 0)) { // negative index
            return false;
        } // if
        if (row > gameGrid.length - 1) { // row index too large
            return false;
        } // if
        if (col > gameGrid[row].length - 1) { // col index too large
            return false;
        } // if
        return true;
    } // isInBounds

} // MinesweeperGame
