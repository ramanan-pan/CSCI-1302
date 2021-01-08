package cs1302.ce26;

import java.util.Scanner;

/**
 * A Tic-Tac-Toe Solver class.
 */
public class TTTSolver {

    /**
     * The entry point for the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an initial board state " +
                           "using 9 consecutive characters. Valid "  +
                           "characters are X, O, and -.");
        String board = promptBoard(input);
        //printAllBoards(board);
        // System.out.println("Is the game board a tie? " + TTTUtility.isCat(board));
        System.out.print("Count winning boards for which player (X or O)? ");
        char player = input.next().charAt(0);
        System.out.println("Ways " + player + " can win: " + countAllWinningBoards(board, player));
        System.out.println("TESTS: ");
        TTTUtility.printSquare("XOXOXO---");
        System.out.println("Ways X can win: " + countAllWinningBoards("XOXOXO---", 'X'));
        System.out.println("Ways O can win: " + countAllWinningBoards("XOXOXO---", 'O'));
        TTTUtility.printSquare("XOXOXXOO-");
        System.out.println("Ways X can win: " + countAllWinningBoards("XOXOXXOO-", 'X'));
        System.out.println("Ways O can win: " + countAllWinningBoards("XOXOXXOO-", 'O'));
        TTTUtility.printSquare("OX-OX----");
        System.out.println("Ways X can win: " + countAllWinningBoards("OX-OX----", 'X'));
        System.out.println("Ways O can win: " + countAllWinningBoards("OX-OX----", 'O'));
    } // main

    /**
     * Prompt the user for a valid board configuration.
     * @param input an input scanner
     * @return the board configuration
     */
    public static String promptBoard(Scanner input) {
        String board = input.nextLine();
        while (!TTTUtility.validGame(board)) {
            System.out.println("Invalid board. Try again.");
            board = input.nextLine();
        } // while
        return board;
    } // promptBoard

    /**
     * Given an initial board state, this method prints
     * all board states that can be reached via valid
     * sequence of moves by each player. Therefore, the
     * printout includes both intermediate board states
     * as well as completed board states.
     *
     * @param board the game board
     */
    public static void printAllBoards(String board) {
        boolean XWin = TTTUtility.isWinner(board, 'X');
        boolean OWin = TTTUtility.isWinner(board, 'O');

        System.out.println(board);

        if (TTTUtility.isCat(board) || (XWin || OWin)) {
            return;
        } // if

        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '-') {
                String nextboard = board.substring(0, i);
                nextboard += Character.toString(TTTUtility.whoseTurn(board));
                nextboard += board.substring(i + 1);
                printAllBoards(nextboard);
            } // if
        } // for

    } // printAllBoards

    /**
     * Given an initial board state, this method returns
     * the number of winning boards acheivable by
     * the given player.
     *
     * @param board the game board
     * @param player the player to count wins for
     * @return count of all the possible winning boards for the {@code player}
     */
    public static int countAllWinningBoards(String board, char player) {
        boolean XWin = TTTUtility.isWinner(board, 'X');
        boolean OWin = TTTUtility.isWinner(board, 'O');

        if (TTTUtility.isCat(board) || (XWin || OWin)) {
            if (TTTUtility.isWinner(board, player)) {
                return 1;
            } // if
            return 0;
        } // if

        int count = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == '-') {
                String nextboard = board.substring(0, i);
                nextboard += Character.toString(TTTUtility.whoseTurn(board));
                nextboard += board.substring(i + 1);
                count += countAllWinningBoards(nextboard, player);
            } // if
        } // for
        return count;
    } // countAllWinningBoards

} // TTTSolver
