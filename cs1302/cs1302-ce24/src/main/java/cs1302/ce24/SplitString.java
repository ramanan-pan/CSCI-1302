package cs1302.ce24;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Split string convenience class.
 */
public class SplitString {

    public static void main(String[] args) {
        printList(splitString("Recursion is fun!", "9"));
    } // main

    /**
     * Returns a list of tokens from {@code str} based on the delimiter
     * {@code delim}.
     * @param str   input string
     * @param delim delimiter / separator
     * @return list of tokens
     */
    public static List<String> splitString(String str, String delim) {
        // Base case
        if (str.isEmpty()) {
            return new LinkedList<String>();
        } // if

        String keep = "";
        String pass = "";
        if (str.contains(delim)) {
            keep = str.substring(0, str.indexOf(delim));
            pass = str.substring(str.indexOf(delim) + 1);
        } else {
            keep = str;
            pass = str.substring(str.length());
        } // if

        List<String> list = splitString(pass, delim);
        list.add(0, keep);

        return list;
    } // splitString

    /**
     * Prints a given {@code List<String>} in a formatted manner.
     *
     * @param list the list to be printed
     */
    public static void printList(List<String> list) {
        String output = list.stream().collect(Collectors.joining("\", \"", "[\"", "\"]"));
        System.out.println(output);
    } // printList

} // SplitString
