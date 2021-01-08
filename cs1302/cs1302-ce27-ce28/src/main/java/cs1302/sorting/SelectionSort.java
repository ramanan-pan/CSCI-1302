package cs1302.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Represents and implementation of the selection sort algorithm.
 */
public class SelectionSort {

    public static void main(String[] args) {

        System.out.println("Array 1 (Integer):");
        Integer[] array1 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(array1));
        selectionSort(array1, 0, 4, Integer::compareTo);
        System.out.println("hi: 4, lo: 0");
        System.out.println(Arrays.toString(array1));
        System.out.println();

        System.out.println("Array 2 (Double):");
        Double[] array2 = {309.23, 21.827, 100.0, 51.1, 4.5};
        System.out.println(Arrays.toString(array2));
        selectionSort(array2, 0, 2, Double::compareTo);
        System.out.println("hi: 2, lo: 0");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        System.out.println("Array 3 (String):");
        String[] array3 = {"hi", "my", "name", "is", "albert"};
        System.out.println(Arrays.toString(array3));
        selectionSort(array3, 0, 4, String::compareTo);
        System.out.println("hi: 4, lo: 0");
        System.out.println(Arrays.toString(array3));

    } // main

    /**
     * Calls the selectMin method to sort the array in ascending order.
     *
     * @param array array to be sorted
     * @param lo starting index position
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     */
    public static <T> void selectionSort(T[] array, int lo, int hi, Comparator<T> c) {
        for (int i = lo; i < hi; i ++) {
            selectMin(array, i, hi, c);
        } // for
    } // selectionSort

    /**
     * Selects the minimum in an array and swaps it with the lowest index.
     *
     * @param array array to be sorted
     * @param lo starting index position
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     */
    public static <T> void selectMin(T[] array, int lo, int hi, Comparator<T> c) {
        int min = lo;
        for (int i = lo; i <= hi; i ++) {
            if (c.compare(array[min], array[i]) > 0) {
                min = i;
            } // if
        } // for
        swap(array, min, lo);
    } // selectMin

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
} // SelectionSort
