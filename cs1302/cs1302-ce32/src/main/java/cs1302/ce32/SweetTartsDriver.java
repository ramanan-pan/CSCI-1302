package cs1302.ce32;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.InputStream;

/**
 * A sweet program that calculates the maximum overall enjoyment
 * for eating rolls of Sweet Tarts given a preference for each color
 * and a roll of candies.
 *
 * <p>
 * Input data is read from an input file. There can be multiple test
 * cases per file. Each test begins with the number of candies in the
 * roll. The next line of the file contains a {@code String}
 * representing the preferences for each color. The first character in
 * the preferences {@code String} is the most preferred candy (character)
 * and the last character is the least preferred. The final line of the
 * test case is the candy roll itself which is represented as a {@code String}
 * where each character represents a candy.
 */
public class SweetTartsDriver {

    private static final String INPUT_FILE = "sample2.txt";

    /**
     * The entry point for the application.
     */
    public static void main(String[] args) {

        char[] pref = new char[4];
        int numCandies;
        Scanner input = null;
        int[] values;

        try {
            input = loadFileScanner(INPUT_FILE);
        } catch(FileNotFoundException e) {
            System.out.println("Input file not found");
        } // try

        numCandies = input.nextInt();

        while(numCandies != 0) {          // The terminal value
            values = new int[numCandies];
            input.nextLine();             // consume '\n' after number of candies
            readPref(pref, input);
            readValues(numCandies, values, pref, input);
            printState(numCandies, values);
            System.out.printf("Max Value: %s\n", score(values, 0, values.length - 1, 1));
            numCandies = input.nextInt();
        } // while

    } // main

    /**
     * Returns the maximum score of eating a roll of sweet tarts (values)
     * starting at position {@code lo} and ending at position {@code hi}.
     * The consumer is only allowed to eat from the ends of the roll. The value
     * for eating a particular candy is the value of that candy multiplied
     * the turn in which it is eaten.
     *
     * @param values the values (enjoyment) of eating a particular candy.
     * @param lo the starting index in the array.
     * @param hi the ending index in the array.
     * @param turn the current turn.
     */
    private static int score(int[] values, int lo, int hi, int turn) {
        // TODO: Implement me!
        return 0;
    } // score

    /**
     * Print the current state of the game. Output includes
     * the number of candies in the current iteration and the
     * numeric enjoyment value of each candy.
     *
     * @param numCandies the number of candies.
     * @param values the values of the candies.
     */
    private static void printState(int numCandies, int[] values) {
        System.out.printf("NumCandies: %s\n", numCandies);
        System.out.println();
        for(int i: values) {
            System.out.print(i);
        } // for
        System.out.println();
    } // printState

    /**
     * Reads the candy letters and turns them into their
     * corresponding values using the specified preferences for each.
     *
     * @param numCandies the number of candy values to read.
     * @param values the array in which to store the values.
     * @param input the {@code Scanner} object containing the data.
     */
    private static void readValues(int numCandies, int[] values, char[] pref, Scanner input) {
        String candies = input.nextLine();
        for (int i = 0; i < numCandies; i++) {
            char candy = candies.charAt(i);
            values[i] = candyToValue(candy, pref);
        } // for
    } // readValues

    /**
     * Converts a character (candy) to its value based on the preferences.
     * The most preferred candy will have a value of 4 and the least preferred
     * candy will have a value of 1.
     *
     * @param candy the character (candy) value to convert.
     * @param pref the array of candy preferences.
     */
    private static int candyToValue(char candy, char[] pref) {
        int value = 4; // First value is worth the most.
        for(int i = 0; i < pref.length; i++) {
            if(pref[i] == candy) {
                value -= i; // Subtract location from the max value
                break;
            } // if
        } // for
        return value;
    } // candyToValue

    /**
     * Read in the candy preferences.
     * @param pref the array to store the candy preferences.
     * @param input the {@code Scanner} object containing the data.
     */
    private static void readPref(char[] pref, Scanner input) {
        String s = input.nextLine();
        for(int i = 0; i < 4; i++) {
            pref[i] = s.charAt(i);
        } // for
    } // readPref

    /**
     * Returns a scanner for a file with the specified filename.
     * @param filename the file containing the names.
     * @return a scanner for the file.
     */
    public static Scanner loadFileScanner(String filename) throws FileNotFoundException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filename);
        Scanner sc = new Scanner(is);
        return sc;
    } // loadFileScanner

} // SweetTartsDriver
