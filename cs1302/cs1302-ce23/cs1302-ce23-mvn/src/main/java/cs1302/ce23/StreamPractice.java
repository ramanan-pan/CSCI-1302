package cs1302.ce23;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Some starter code for practicing with streams. This class
 * creates a random {@code List} of {@code Employee} objects.
 * Streams can be used to process the elements of the list
 * efficiently with less code than loops.
 */
public class StreamPractice {

    private static final int NUM_EMPLOYEES = 10;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();

        // Generate employees
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            employees.add(Employee.genEmployee());
        } // for

        System.out.println("ALL EMPLOYEES\n");
        // Print information about the employees
        for (Employee e: employees) {
            System.out.println(e);
        } // for

        // 2.1
        System.out.println("\nCHECKPOINT 2.1: LEVEL 3 EMPLOYEES\n");
        employees
            .stream()
            .filter(e -> e.getLevel() == 3)
            .forEach(System.out::println);
        // 2.2
        System.out.println("\nCHECKPOINT 2.2: INCOME > 200K\n");
        employees
            .stream()
            .filter(e -> e.getGross() > 200000)
            .forEach(e -> System.out.println(String.format("$" + "%.2f", e.getGross())));
        // 2.3
        System.out.println("\nCHECKPOINT 2.3: NET INCOME\n");
        employees
            .stream()
            .forEach(e -> System.out.println(String.format("$" + "%.2f", getNetIncome(e))));
        // 3.1
        System.out.println("\nCHECKPOINT 3.1: SUM OF HIGH LEVEL 2 NET INCOMES\n");
        double sum = employees
            .stream()
            .filter(e -> (e.getLevel() == 2))
            .map(e -> getNetIncome(e))
            .filter(i -> i > 100000)
            .reduce(0.0, (s, e) -> s + e);
        System.out.println(String.format("$" + "%.2f", sum));

        // LOOP-BASED SOLUTION
        System.out.println("\nCHECKPOINT 3.2: SUM OF HIGH LEVEL 2 NET INCOMES USING LOOPS\n");
        double loopSum = 0;
        for (Employee e : employees) {
            if (e.getLevel() == 2) {
                double netIncome = e.getGross();
                for (int i = 0; i < e.getDeductions().length; i++) {
                    netIncome -= e.getDeductions()[i];
                } // for
                if (netIncome > 100000) {
                    loopSum += netIncome;
                } // if
            } // if
        } // for
        System.out.println(String.format("$" + "%.2f" + "\n", loopSum));

    } // main

    /**
     * Calculates net income of an employee (gross income - sum of deductions).
     *
     * @param e {@code Employee} object
     * @return {@code double} representation of net income
     */
    private static double getNetIncome(Employee e) {
        return Arrays
            .stream(e.getDeductions())
            .reduce(e.getGross(), (g, d) -> g - d);
    } // getNetIncome
} // StreamPractice
