package cs1302.ce06;

import cs1302.ce06.contract.Drivable;
import cs1302.ce06.impl.Car;
import cs1302.ce06.impl.Boat;

/**
 * A driver program to test the functionality of
 * {@code cs1302.ce06.impl.Car} which implements
 * {@code cs1302.ce06.contract.Drivable}.
 */
public class Driver {

    /**
     * Attempts to speedup and slowdown the {@link cs1302.ce06.impl.Car} object
     * or the {@link cs1302.ce06.impl.Boat} object
     * by a specified amount. If the {@link cs1302.ce06.impl.Car} or {@link cs1302.ce06.impl.Boat}
     * object is unable to speedup or slowdown by the specified amount, an appropriate message is
     * printed.
     *
     * @param d the vehicle to test
     * @param speedupAmount the amount to speedup the vehicle
     * @param slowdownAmount the amount to slowdown the vehicle
     */
    public static void test(Drivable d, double speedupAmount,
                            double slowdownAmount) {
        System.out.println(d);
        if (d.speedUp(speedupAmount)) {
            System.out.println("The " + d + " sped up by " + speedupAmount + " mph");
        } else {
            System.out.println("The " +  d +  " go that fast");
        } // if

        if (d.slowDown(slowdownAmount)) {
            System.out.println("The " + d + " slowed down by " + slowdownAmount + " mph");
        } else {
            System.out.println("The " + d + " is cannot slow down by that amount");
        } // if

        System.out.println(d);
    } // test

    /**
     * The main method.
     * @param args the command-line arguments to the program
     */
    public static void main(String[] args) {
        Drivable fastCar = new Car(185.5);
        Drivable slowCar = new Car(75.0);

        Drivable fastBoat = new Boat(185.5);
        Drivable slowBoat = new Boat(75.0);

        System.out.println("--------------------");

        test(fastCar, 200.5, 20);
        System.out.println("--------------------");

        test(fastCar, 125, 20);
        System.out.println("--------------------");

        test(slowCar, 85, 20);
        System.out.println("--------------------");

        test(slowCar, 65, 65);
        System.out.println("--------------------");
    } // main
} // Driver
