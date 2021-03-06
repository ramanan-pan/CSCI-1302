package cs1302.genlist;

import cs1302.genlistadt.GenList;
import java.util.function.IntFunction;
import java.util.Iterator;
import cs1302.genlist.GenIterator;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;

/**
 * The {@code LinkedGenListTest} class is employed to demo proper use
 * of the map, reduce, filter, min, and allMatch methods. This class
 * utilizes the {@code LinkedGenList<T>} implementation of the {@code GenList<T>} interface.
 */
public class LinkedGenListTest {

    public static void main(String[] args) {

        System.out.println("\n\tdemoMap:\n");
        demoMap();
        System.out.println("\n\tdemoReduce:\n");
        demoReduce();
        System.out.println("\n\tdemoFilter:\n");
        demoFilter();
        System.out.println("\n\tdemoMin:\n");
        demoMin();
        System.out.println("\n\tdemoAllMatch:\n");
        demoAllMatch();

    } // main

    /**
     * Tests the map method of {@code GenList<T>} objects.
     * Employs {@code Float} and {@code Integer} parameterizations.
     */
    public static void demoMap() {
        // Parameterization of Float
        GenList<Float> fList = new LinkedGenList<Float>();
        fList.add(6.0f);
        fList.add(4.5f);
        fList.add(12.0f);
        fList.add(100.0f);
        fList.add(150.0f);

        System.out.println(" (1) Float Parameterization\n");
        System.out.println("GenList<Float> fList: " + fList.makeString(", ") + "\n");

        System.out.println("apply implementation divides floating point numbers if they are even,");
        System.out.println("and uses the Math.round() method to convert them into integers");
        System.out.println("map method returns GenList<Integer>\n");

        Function<Float, Integer> f = e -> {
            Integer num = new Integer(0);
            if (e % 2 == 0) {
                num = Math.round(e / 2);
            } else {
                num = Math.round(e);
            } // if
            return num;
        };

        GenList<Integer> iList = fList.map(f);

        System.out.println("GenList<Integer> iList: " + iList.makeString(", ") + "\n");

        // Parameterization of Integer
        System.out.println(" (2) Integer Parameterization\n");
        System.out.println("GenList<Integer> iList: " + iList.makeString(", ") + "\n");

        System.out.println("apply implementation converts multiples integer by 10,");
        System.out.println("then makes String array of num * 1, num * 2, and num * 3");
        System.out.println("map method returns GenList<String[]>\n");

        Function<Integer, String[]> f2 = e -> {
            String[] stringArray = new String[3];

            for (int i = 0; i < 3; i++) {
                Integer num = e * (10 * (i + 1));
                stringArray[i] = num.toString();
            } // for
            return stringArray;
        };

        GenList<String[]> strArrayList = iList.map(f2);
        // prints out strArrayList
        System.out.println("GenList<String[]> strArrayList: ");
        for (String[] e : strArrayList) {
            for (String str : e) {
                System.out.print(str + " ");
            } // for
            System.out.println();
        } // for
    } // demoMaps

    /**
     * Tests the reduce method of {@code GenList<T>} objects.
     * Employs {@code String} and {@code Double} parameterizations.
     */
    public static void demoReduce() {
        // Parameterization of String
        GenList<String> words = new LinkedGenList<String>();
        words.add("hello");
        words.add("my");
        words.add("name");
        words.add("is");
        words.add("ramanan");

        System.out.println(" (1) String Parameterization\n");
        System.out.println("GenList<String> names: ");
        for (String e : words) {
            System.out.println(e);
        } // for

        System.out.println("\napply implementation concatenates Strings");
        System.out.println("reduce method returns String sentence\n");

        String sentence = words.reduce("", (e,w) -> e + w.toUpperCase() + " ");

        System.out.println(sentence + "\n");

        GenList<Double> expenses = new LinkedGenList<Double>();
        expenses.add(45.89);
        expenses.add(10.00);
        expenses.add(198.90);
        expenses.add(0.99);

        // Parameterization of Double
        System.out.println(" (2) Double Parameterization\n");
        System.out.println("GenList<Double> expenses: " + expenses.makeString(", ") + "\n");
        System.out.println("apply implementation is first used to sum expenses,");
        System.out.println("then it is used to subtract expenses from the balance");
        System.out.println("in both instances the reduce method returns a double\n");

        double balance = 100.00;
        System.out.println("Balance (before expenses): $" + balance);
        double sum = Math.round(expenses.reduce(0.0, (t, u) -> t + u) * 100.0) / 100.0;
        System.out.println("Sum of expenses: $" + sum);
        double debt = Math.round(expenses.reduce(balance, (b,e) -> b - e) * 100.0) / 100.0;
        System.out.println("Balance (after expenses): $" + debt);

    } // demoReduce

    /**
     * Tests the filter method of {@code GenList<T>} objects.
     * Employs {@code Integer} and {@code Boolean[]} parameterizations.
     */
    public static void demoFilter() {
        // Parameterization of Integer
        GenList<Integer> years = new LinkedGenList<Integer>();
        years.add(2020);
        years.add(1972);
        years.add(2016);
        years.add(1600);
        years.add(2001);

        System.out.println(" (1) Integer Parameterization\n");
        System.out.println("GenList<Integer> years: " + years.makeString(", ") + "\n");

        GenList<Integer> leapYears = years.filter(y -> ((y % 4 == 0) && (y >= 2000)));

        System.out.println("\ntest implementation checks if year is divisible by 4");
        System.out.println("and is greater than or equal to 2000 (in 21st century)\n");

        System.out.println("GenList<Integer> leapYears: " + leapYears.makeString(", ") + "\n");

        // Parameterization of Boolean array
        GenList<Boolean[]> bList = new LinkedGenList<Boolean[]>();
        Boolean[] b1 = {true, false, false, false};
        Boolean[] b2 = {true, true, true, true};
        Boolean[] b3 = {false, true, false, true, false};
        Boolean[] b4 = {true, true, false};

        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);

        System.out.println(" (2) Boolean[] Parameterization\n");
        System.out.println("GenList<Boolean[]> bList: ");
        for (Boolean[] b : bList) {
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            } // for
            System.out.println();
        } // for

        System.out.println("\ntest implementation checks if first index is true");
        System.out.println("and last index is false\n");

        GenList<Boolean[]> newB = bList.filter(b -> (b[0] == true) && (b[b.length - 1] == false));

        System.out.println("GenList<Boolean[]> newB: ");
        for (Boolean[] b : newB) {
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            } // for
            System.out.println();
        } // for

    } // demoFilter

    /**
     * Tests the min method of {@code GenList<T>} objects.
     * Employs {@code Double} and {@code String} parameterizations.
     */
    public static void demoMin() {
        // Parameterization for Double
        GenList<Double> nums = new LinkedGenList<Double>();
        nums.add(100.00);
        nums.add(607.28);
        nums.add(10892.209);
        nums.add(2820000.890);
        nums.add(1000500.12);
        System.out.println(" (1) Double Parameterization\n");
        System.out.println("GenList<Double> nums: " + nums.makeString(", ") + "\n");
        System.out.println("compare implementation determines min by");
        System.out.println("the least instances of 0 in the number\n");

        double min1 = nums.min((n1, n2) -> {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < String.valueOf(n1).length(); i++) {
                if (String.valueOf(n1).charAt(i) == '0') {
                    count1++;
                } // if
                if (String.valueOf(n2).charAt(i) == '0') {
                    count2++;
                } // if
            } // for
            return count1 - count2;
        });
        System.out.println("Min 1: " + min1 + "\n");

        // Parameterization for String
        GenList<String> bicaps = new LinkedGenList<String>();
        bicaps.add("SimCity");
        bicaps.add("YouTube");
        bicaps.add("CamelCase");
        bicaps.add("InsuranceA");
        bicaps.add("AltaVista");
        bicaps.add("ScienceDirect");
        System.out.println(" (2) String Parameterization\n");
        System.out.println("GenList<String> bicaps: " + bicaps.makeString(", ") + "\n");
        System.out.println("compare implementation determines min by the ordering that is");
        System.out.println("alphabetical based on the 2nd capital character in the string\n");

        String min2 = bicaps.min((o1, o2) -> {
            char c1 = ' ';
            char c2 = ' ';
            for (int i = 0, count = 0; i < o1.length() || count != 2; i++) {
                if (Character.isUpperCase(o1.charAt(i))) {
                    c1 = o1.charAt(i);
                    count++;
                } // if
            } // for
            for (int i = 0, count = 0; i < o2.length() || count != 2; i++) {
                if (Character.isUpperCase(o2.charAt(i))) {
                    c2 = o2.charAt(i);
                    count++;
                } // if
            } // for
            return c1 - c2;
        });
        System.out.println("Min 2: " + min2 + "\n");
    } // demoMin

    /**
     * Tests the allMatch method of {@code GenList<T>} objects.
     * Employs {@code String} and {@code Character} parameterizations.
     */
    public static void demoAllMatch() {
        // Parameterization of String
        GenList<String> n = new LinkedGenList<String>();
        n.add("dorothy");
        n.add("bob");
        n.add("pheobe");

        System.out.println(" (1) String Parameterization\n");
        System.out.println("GenList<String> n: " + n.makeString(", ") + "\n");
        System.out.println("test implementation checks if name contains an o");
        System.out.println("and if it is in the middle of the name\n");

        boolean r1 = n.allMatch(o -> o.contains("o")
                                     && (o.charAt(0) != 'o' && o.charAt(o.length() - 1) != 'o'));

        System.out.println("All names contain o, but only in the middle of the name: " + r1);
        // adding elements which will make method return false
        n.add("ozzy");
        n.add("gabo");
        r1 = n.allMatch(o -> o.contains("o")
                             && (o.charAt(0) != 'o' && o.charAt(o.length() - 1) != 'o'));

        System.out.println("\nGenList<String> n: " + n.makeString(", ") + "\n");
        System.out.println("All names contain o, but only in the middle of the name: " + r1 + "\n");

        // Parameterization of Character
        GenList<Character> cList = new LinkedGenList<Character>();
        cList.add('a');
        cList.add('1');
        cList.add('C');
        cList.add('_');

        System.out.println(" (2) Character Parameterization\n");
        System.out.println("GenList<Character> cList: " + cList.makeString(", ") + "\n");
        System.out.println("test implementation checks if char is a letter");
        System.out.println("and if it is lowercase\n");

        boolean r2 = cList.allMatch(c -> Character.isAlphabetic(c) && Character.isLowerCase(c));

        System.out.println("All characters are alphabetic letters and lowercase: " + r2);
        // removing and adding elements which will make method return true
        cList.remove(1);
        cList.remove(1);
        cList.remove(1);
        cList.add('b');
        cList.add('c');

        r2 = cList.allMatch(c -> Character.isAlphabetic(c) && Character.isLowerCase(c));

        System.out.println("\nGenList<Character> cList: " + cList.makeString(", ") + "\n");
        System.out.println("All characters are alphabetic letters and lowercase: " + r2 + "\n");

    } // demoAllMatch

} // LinkedGenListTest
