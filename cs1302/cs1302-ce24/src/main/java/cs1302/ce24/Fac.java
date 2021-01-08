package cs1302.ce24;

/**
 * Factorial convenience class.
 */
public class Fac {

    public static void main(String[] args) {
        System.out.println(factorial(30000));
    } // main

    /**
     * Returns the Factorial of {@code n}.
     * @param n index
     * @return Factorial of {@code n}
     */
    public static int factorial(int n) {
        if (n == 0) {
            //   i. reverse order
            //  ii. 4
            // iii. main
            Thread.currentThread().dumpStack(); // print call stack
            return 1;
        } // if
        return n * factorial(n - 1);
    } // fibonacci

} // Fac
/* CHECKPOINT 1.3
 *   i. Yes
 *  ii. 10
 * iii. StackOverflowError
 */
