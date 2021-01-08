package cs1302.generics;

import java.util.Arrays;

/**
 * Driver class for {@code cs1302-ce14}.
 */
public class Driver {
    /**
     * Given a reference to an array specified by {@code array} and a reference
     * specified by {@code val}, finds the first object {@code o} in {@code array}
     * such that {@code Math.abs(val.getArea() - o.getArea()) < delta}, then returns its
     * reference; returns {@code null} if no match is found.
     *
     * @param <T>    element type
     * @param array  array to search
     * @param val    reference to the object to match
     * @param delta  difference that is considered unequal
     * @return a reference to the object from {@code array} with an area matching
     * that of the object referenced by {@code val} or {@code null} if no match
     * is found.
     */
    public static <T extends Shape> T findMatchingArea(T[] array, T val, double delta) {
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(val.getArea() - array[i].getArea()) < delta) {
                return array[i];
            } // if
        } // for

        return null;
    } // findMatchingArea

    public static void main(String[] args) {

        // SOME ARRAYS FOR TESTING

        Shape[] shapes = new Shape[] {
            new Circle(2.0),
            new Ellipse(3.2, 2.8),
            new Rectangle(Math.PI, 4.0)
        };

        Circle[] circles = new Circle[] {
            new Circle(4.5),
            new Circle(1.0),
            new Circle(2.3)
        };

        Rectangle[] rectangles = new Rectangle[] {
            new Square(2.0),
            new Rectangle(1.0, 4.0),
            new Square(1.41421356237),
            new Rectangle(2.0, 1.0)
        };

        // YOUR CODE DOWN HERE

        Rectangle a = findMatchingArea(rectangles, new Square(2.0), 0.001);
        // Square b = findMatchingArea(rectangles, new Square(2.0), 0.001);
        Shape c = findMatchingArea(rectangles, new Square(2.0), 0.001);
    } // main
} // Driver
