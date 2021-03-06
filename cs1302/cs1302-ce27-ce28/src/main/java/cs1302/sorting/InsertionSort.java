package cs1302.sorting;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {

        System.out.println("Array 1 (Integer):");
        Integer[] array1 = {2, 3, 1, 5, 4};
        System.out.println(Arrays.toString(array1));
//        insert(array1, 0, 1, Integer::compareTo);
        System.out.println("hi: 1, lo: 0");
        System.out.println(Arrays.toString(array1));
        System.out.println();

        System.out.println("Array 2 (Integer):");
        System.out.println(Arrays.toString(array1));
        insertionSort(array1, 1, 4, Integer::compareTo);
        System.out.println("hi: 2, lo: 0");
        System.out.println(Arrays.toString(array1));
        System.out.println();

    } // main

    public static <T> void insert(T[] array, int lo, int hi, Comparator<T> c) {
        T hold = array[hi];
        int i = 0;

        for (i = hi; i > lo && (c.compare(hold, array[i - 1]) < 0); i --) {
            array[i] = array[i - 1];
        } // for



        array[i] = hold;
    } // insert

    public static <T> void insertionSort(T[] array, int lo, int hi, Comparator<T> c) {
        for (int i = lo + 1; i <= hi; i ++) {
            insert(array, lo, i, c);
        } // for
    } // insertionSort

    public static void addToEnd(List<String> l) {
        int x = 0;
    } // addToEnd
} // InsertionSort
