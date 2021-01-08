package cs1302.rec;

public class Rec {
    public static void main(String[] args) {
        //printRow(10);
        System.out.println(fun(5, 1));
    } // main

    public static long fun (int n, int s) {
        if (n == 0) {
            return s;
        } else {
            return fun(n - 1, n * s);
        } // if
    } // fun

    public static void printRow(int num) {

        if (num == 0) {
            return;
        } // if
        printRow(num - 1);
        printCol(num - 1);
        System.out.println();



    } // printRow

    public static void printCol(int num) {

        if (num == 0) {
            return;
        } // if

        /*
        if (num != 0) {
            printCol(num - 1);
            System.out.print("*");
        } // if
        */

        System.out.print("*");
        printCol(num - 1);

    } // printCol
} // Rec
