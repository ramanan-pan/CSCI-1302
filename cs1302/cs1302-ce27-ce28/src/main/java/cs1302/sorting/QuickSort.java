package cs1302.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Represents an implementation of the quick sort algorithm.
 */
public class QuickSort {

    public static void main(String[] args) {

        System.out.println("Array 1 (Integer):");
        Integer[] array1 = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(array1));
        quickSort(array1, 0, 4, Integer::compareTo);
        System.out.println("hi: 4, lo: 0");
        System.out.println(Arrays.toString(array1));
        System.out.println();

        System.out.println("Array 2 (Double):");
        Double[] array2 = {309.23, 21.827, 100.0, 51.1, 4.5};
        System.out.println(Arrays.toString(array2));
        quickSort(array2, 0, 3, Double::compareTo);
        System.out.println("hi: 3, lo: 0");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        System.out.println("Array 3 (String):");
        String[] array3 = {"hi", "my", "name", "is", "albert"};
        System.out.println(Arrays.toString(array3));
        quickSort(array3, 1, 4, String::compareTo);
        System.out.println("hi: 4, lo: 1");
        System.out.println(Arrays.toString(array3));

    } // main

    /**
     * Uses the partition method to oredr elements in an array.
     * @param array array to be sorted
     * @param lo starting index position
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     */
    public static <T> void quickSort(T[] array, int lo, int hi, Comparator<T> c) {
        if (lo >= hi) {
            return;
        } // if

        int pivot = (hi / 2) + (lo / 2);
        int part = partition(array, lo, pivot, hi, c);

        quickSort(array, lo, part - 1, c);
        quickSort(array, part + 1, hi, c);
    } // quickSort

    /**
     * Moves elements greater than pivot after the pivot, and
     * elements less than pivot before the pivot, and returns a new pivot.
     *
     * @param array array to be sorted
     * @param lo starting index position
     * @param pivot the pivot index
     * @param hi ending index position
     * @param c Comparator object used for comparisons
     * @param <T> type of array
     * @return new pivot index
     */
    public static <T> int partition(T[] array, int lo, int pivot, int hi, Comparator<T> c) {
        swap(array, pivot, hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (c.compare(array[j], array[hi]) < 0) {
                swap(array, i, j);
                i += 1;
            } // if
        } // for
        swap(array, i, hi);
        return i;
    } // partition

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

} // QuickSort
