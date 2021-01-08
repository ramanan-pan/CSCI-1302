package cs1302.ce17;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * This class contains methods related to {@code cs1302-ce17}.
 */
public class LambdaFun {

    /** Standard Input scanner. */
    private static Scanner input = new Scanner(System.in);

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        String[] myStrings = new String[] {
            "CSCI",        "1302",    "is", "an", "awesome", "course!",
            "Lambda", "expressions", "scare", "me",     "but",       "I",
            "will",   "persevere"
        };

        Email[] inbox = new Email[] {
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 4), "Go GA Tech!"),
            new Email("bjb211@uga.edu", "mom@aol.com",
                      LocalDate.of(2019, 2, 5), "Have a good day!"),
            new Email("bjb211@uga.edu", "steve@anyotherschool.edu",
                      LocalDate.of(2019, 2, 6), "I wish I would've chosen UGA"),
            new Email("bjb211@uga.edu", "student1@uga.edu",
                      LocalDate.of(2019, 2, 7), "Thanks for teaching us!"),
            new Email("bjb211@uga.edu", "yellowjacket@gatech.edu",
                      LocalDate.of(2019, 2, 8), "Go GA Tech!")
        };

        Predicate<String> stringTest1 = (s1) -> s1.contains("a");
        Predicate<String> stringTest2 = (s1) -> s1.length() == 2;
        Predicate<String> stringTest3 = (s1) -> s1.contains("S");
        Predicate<String> stringTest4 = (s1) -> s1.equals("CSCI");

        LambdaFun.<String>printlnMatches(myStrings, stringTest1);
        LambdaFun.<String>printlnMatches(myStrings, stringTest2);
        LambdaFun.<String>printlnMatches(myStrings, stringTest3);
        LambdaFun.<String>printlnMatches(myStrings, stringTest4);

        Predicate<Email> email1 = (e) -> !e.getSender().contains("gatech.edu");
        Function<Email, String> emailF1 = (e) -> "~~~\n\t" + e.getContents() + "\n~~\n";
        LambdaFun.<Email>printlnMappedMatches(inbox, email1, emailF1);


        Function<Email, String> emailF2 = (e) -> "~~~\n" + e.getDateSent() + ", " + e.getSender() +
            "\n\n\t" + e.getContents() + "\n~~\n";

        Function<Email, String> emailF3 = (e) -> Integer.toString(e.getDateSent().getYear());

        LambdaFun.<Email>printlnMappedMatches(inbox, email1, emailF2);
        LambdaFun.<Email>printlnMappedMatches(inbox, email1, (e) -> e.getSender());
        foo();
    } // main

    /**
     * Prints the elements of the array that pass the test specified by the given predicate.
     * More formally, this method prints all elements {@code e} in the array referred to by
     * {@code t} such that {@code p.test(e)}. Each element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @throws NullPointerException if the specified predicate is {@code null}
     */
    private static <T> void printlnMatches(T[] t, Predicate<T> p) {

        for (int i = foo()-2 ; i < t.length; i++) {
            if (p.test(t[i])) {
                System.out.println(t[i]);
            } // if
        } // for
    } // printlnMatches

    /**
     * Prints the elements of the array that pass the test specified by the given predicate
     * using a string mapper. More formally, this method prints the string mapped elements
     * {@code f.apply(e)} in the array referred to by {@code t} for each {@code e} such that
     * {@code p.test(e)}. Each string mapped element will be printed on its own line.
     *
     * @param <T> the type of the array elements
     * @param t the specified array
     * @param p the specified predicate
     * @param f the specified string mapper
     * @throws NullPointerException if the specified predicate or string mapper is {@code null}
     */
    private static <T> void printlnMappedMatches(T[] t, Predicate<T> p, Function<T, String> f) {
        for (int i = 0; i < t.length; i++) {
            if (p.test(t[i])) {
                System.out.println(f.apply(t[i]));
            } // if
        } // for
    } // printlnMappedMatches

    private static double foo() {
        return 2.0;
    } // foo
} // LambdaFun
