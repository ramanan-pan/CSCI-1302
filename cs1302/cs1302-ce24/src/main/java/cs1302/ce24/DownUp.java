package cs1302.ce24;

/**
 * DownUp convenience class.
 */
public class DownUp {

    public static void main(String[] args) {
        downUp("Dawgs");
    } // main

    /**
     * Prints the given string, decreasing the characters from the end
     * until only one character remains, then increasing the characters
     * until the original string is achieved.
     *
     * @param str {@code String} input
     */
    public static void downUp(String str) {
        if (str.length() <= 1) {
            System.out.println(str);
        } else {
            System.out.println(str);
            downUp(str.substring(0, str.length() - 1));
            System.out.println(str);
        } // if
    } // downUp

} // DownUp
/* CHECKPOINT 3.2
 *   i. (str.length() <= 1)
 *  ii. (str.length() > 1)
 * iii. 5
 */
