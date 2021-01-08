package cs1302.ce12;

/**
 * Driver program for cs1302 class exercise 12 using various types of
 * container objects.
 *
 * @author Brad Barnes and Supa' Mike
 * @version 1.0
 */

public class Driver {

    /**
     * Creates objects for each type of container to check basic functionality.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // Declare objects of all of our container types
        ObjectContainer sc = new ObjectContainer(new Integer(9));
        ObjectContainer dc = new ObjectContainer(4.5);
        ObjectContainer ic = new ObjectContainer(7);
        ObjectContainer bc = new ObjectContainer(true);

        // Print the contents of each container
        Integer xc = (Integer)sc.get();
        System.out.println(sc.get());
        System.out.println(dc.get());
        System.out.println(ic.get());
        System.out.println(bc.get());

    } // main

} // Driver
