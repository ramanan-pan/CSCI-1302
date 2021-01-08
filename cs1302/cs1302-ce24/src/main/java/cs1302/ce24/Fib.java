package cs1302.ce24;

/**
 * Fibonacci convenience class.
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    } // main

    /**
     * Returns the Fibonacci number at index {@code n}.
     * @param n index
     * @return Fibonacci number at index {@code n}
     */
    public static int fibonacci(int n) {
        if ((n == 0) || (n == 1)) {
            return 1;
        } // if
        return fibonacci(n - 2) + fibonacci(n - 1);
    } // fibonacci

} // Fib
/* CHECKPOINT 2.1
 *   i. fibonacci(3)
 *  ii. 3
 * iii. fibonacci(1)
 *  iv. 8
 */
