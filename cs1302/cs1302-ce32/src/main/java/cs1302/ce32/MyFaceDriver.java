package cs1302.ce32;

import cs1302.myface.*;
import cs1302.sorting.*;
import java.util.Comparator;
import java.util.Arrays;

/**
 * A program for testing various sorting algorithms on {@code MyFace} users.
 */
public class MyFaceDriver {

    /**
     * Returns the number of words that are 5 characters or more across all of
     * the specified user's messages.
     *
     * @param user  a reference to the specified {@code MyFaceUser}
     * @return the number of large words contained in the specified user's
     *        messages.
     */
    public static int countLargeWords(MyFaceUser user) {
        return user.getMessages()
            .stream()
            .map(Message::getContents)
            .reduce(0, s-> {
                int count = 0;
                if (s.size() >= 5) {
                    count++;
                } // if
                return count;
            });
    } // countLargeWords

    /**
     * Compares its two arguments for order. Returns a negative integer, zero,
     * or a positive integer if the first user's large word count is less than,
     * equal to, or greater than the second user's large word count.
     *
     * @param user1  the first user to compare
     * @param user2  the second user to compare
     * @return a negative integer, zero, or a positive integer if the first
     *         user's large word count is less than, equal to, or greater than
     *         the second user's large word count.
     */
    public static int compareByLargeWords(MyFaceUser user1, MyFaceUser user2) {
	return countLargeWords(user1) - countLargeWords(user2);
    } // compareByLargeWords

    /**
     * Calculates the total runtime in seconds for an algorithm. Total runtime is calculated by
     * adding the total amount of time spent on comparisons and swaps.
     *
     * @param sort a reference to the {@code Sort} object containing the statistics for each
     * operation.
     * @return the total runtime in seconds for the algorithm.
     */
    public static double getTotal(Sort<MyFaceUser> sort) {
        double result = sort.getCompStats().getSum() + sort.getSwapStats().getSum();
        return result / 1.0E9; // convert to seconds then return the result
    } // getTotal

    /**
     * The main entry point for the application.
     * @param args  the command line arguments
     */
    public static void main(String[] args) {

        // generate myface users
        MyFace socialNetwork = new MyFace(50);
        MyFaceUser[] users = socialNetwork.getUsers().stream().toArray(MyFaceUser[]::new);
        System.out.printf("MyFace user count: %d\n", users.length);

	// setup objects for the sorting algorithm
        Comparator<MyFaceUser> c = MyFaceDriver::compareByLargeWords;
        Swapper<MyFaceUser> s = Swapper.getStandardSwapper();
        Sort<MyFaceUser> sort;

	// sort the users
        sort = new QuickSort<>(users, 0, users.length - 1, c, s);
        sort.printStats();
        System.out.println("Total Time: " + getTotal(sort));

        // print user's messages along with the result of calling countLargeWords to verify
        // that your code is working.
        users.stream().forEach(MyFaceUser::printMessages);
        users.stream().map(MyFaceDriver::countLargeWords).forEach(System.out::println);

    } // main

} // MyFaceDriver
