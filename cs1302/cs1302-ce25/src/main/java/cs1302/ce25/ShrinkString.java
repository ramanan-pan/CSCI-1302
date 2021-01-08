package cs1302.ce25;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Class that represents the functionality to shrink a string.
 */
public class ShrinkString {

    public static void main(String[] args) {
        String[] strings = {"yyzzza", "abbbcdd", "Hello", "abcd", "  ", ""};
        String[] s1 = {};
        printShrunkStrings(strings, 0);
        printShrunkStrings(s1, 0);
        printShrunkStrings(new String[2], 1);
    } // main

    /**
     * Shrinks a string by reducing duplicate characters in a given string.
     *
     * @param str {@String} object
     * @return shrunken {@code String}
     */
    public static String shrinkString(String str) {
        if (str.length() <= 1) {
            return str;
        } // if

        String shrunkStr = "";
        String pass = "";
        if (str.charAt(0) != str.charAt(1)) {
            shrunkStr += str.substring(0,1);
            pass = str.substring(1);
        } else {
            pass = str.substring(1);
        } // if

        return shrunkStr + shrinkString(pass);

    } // shrinkString

    /**
     * Successively prints shrunken strings from an array starting from a given index.
     *
     * @param array {@code String[]} reference
     * @param i starting index
     */
    public static void printShrunkStrings(String[] array, int i) {
        if (i == array.length) {
            return;
        } // if
        if (array != null) {
            if (array.length != 0) {
                if (array[i] != null) {
                    System.out.print('"');
                    System.out.print(shrinkString(array[i]));
                    System.out.println('"');
                    printShrunkStrings(array, i + 1);
                } // if
            } // if
        } // if
    } // printShrunkStrings

} // ShrinkString
