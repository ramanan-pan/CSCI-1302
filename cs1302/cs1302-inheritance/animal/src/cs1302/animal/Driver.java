package cs1302.animal;

/**
 * Test code for the animal-related inheritance examples.
 */
public class Driver {

    public static void main(String[] args) {
        Dog bulldog = new Dog("Bulldog");
        System.out.println(bulldog.getGenus());
        System.out.println(bulldog.getSpecies());
        System.out.println(bulldog.getBreed());
        System.out.println();
        Dog poodle  = new Dog("Poodle");
        System.out.println(poodle.getGenus());
        System.out.println(poodle.getSpecies());
        System.out.println(poodle.getBreed());
        System.out.println();
        Dog beagle = new Dog("Beagle");
        System.out.println(beagle.getGenus());
        System.out.println(beagle.getSpecies());
        System.out.println(beagle.getBreed());
        System.out.println();
        Dog pug = new Dog("Pug");
        System.out.println(pug.getGenus());
        System.out.println(pug.getSpecies());
        System.out.println(pug.getBreed());
        System.out.println();

    } // main

} // Driver
