package cs1302.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Represents an implementation of the bubble sort algorithm.
 */
public class BubbleSort {

    public static void main(String[] args) {

        System.out.println("Array 1 (Integer):");
        Integer[] array1 = {2, 3, 1, 4, 5};
        System.out.println(Arrays.toString(array1));
        bubbleSort(array1, 0, 4, Integer::compareTo);
        System.out.println("hi: 4, lo: 0");
        System.out.println(Arrays.toString(array1));
        System.out.println();
        System.out.println("Array 2 (Double):");
        Double[] array2 = {309.23, 21.827, 100.0, 51.1, 4.5};
        System.out.println(Arrays.toString(array2));
        bubbleSort(array2, 0, 2, Double::compareTo);
        System.out.println("hi: 2, lo: 0");
        System.out.println(Arrays.toString(array2));
        System.out.println();
        System.out.println("Array 3 (String):");
        String[] array3 = {"hi", "my", "name", "is", "albert"};
        System.out.println(Arrays.toString(array3));
        bubbleSort(array3, 0, 4, String::compareTo);
        System.out.println("hi: 4, lo: 0");
        System.out.println(Arrays.toString(array3));

    } // main

    /**
     * Calls the bubble method to sort the array in ascending order.
     *
     * @param array array to be sorted
     * @param lo starting index position
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     */

    public static <T> void bubbleSort(T[] array, int lo, int hi, Comparator<T> c) {
        for (int i = hi; i > lo; i --) {
            bubble(array, lo, i, c);
        } // for
    } // bubbleSort

    /**
     * Takes an array and index positions
     * to swap adjacent positions not in order.
     *
     * @param array array to be sorted
     * @param lo starting index position
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     */
    public static <T> void bubble(T[] array, int lo, int hi, Comparator<T> c) {
        for (int i = lo; i < hi; i++) {
            if (c.compare(array[i], array[i + 1]) > 0) {
                swap(array, i, i + 1);
            } // if
        } // for
    } // bubble

    /**
     * Swaps the values of two index positions in an array.
     *
     * @param array array in which objects need to be swapped
     * @param i1 first object
     * @param i2 second object
     * @param <T> type of array
     */
    public static <T> void swap(T[] array, int i1, int i2) {
        T hold = array[i2];
        array[i2] = array[i1];
        array[i1] = hold;
    } // swap
} // BubbleSort
