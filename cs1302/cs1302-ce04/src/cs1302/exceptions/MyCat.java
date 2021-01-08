package cs1302.exceptions;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * A simpler version of the Unix <code>cat</code> command.
 */
public class MyCat {

    /**
     * Entry point for the application. Takes in zero, one, or more command-line arguments.
     * If a filename is given as an argument, then the program should print the contents of that
     * file to standard output. If a single dash (i.e., "-") is given as an argument, then
     * the program should print the contents of standard input. If the file given as an argument
     * cannot be found, the exception is caught and an error message is returned.
     *
     * @param args  the command-line arguments
     */
    public static void main(String[] args) {
	for(int i = 0; i < args.length; i++){	    
	    try {
		String filename = args[i];
		Scanner input = null;
    
		if (filename.equals("-")) {
		    Printer.printStdInLines();
		} else {
		    File file = new File(filename);
		    Printer.printFileLines(file);
		} // if
	    } catch(ArrayIndexOutOfBoundsException aioobe){
		System.out.println("MyCat: " + aioobe.toString());
	    } catch(FileNotFoundException fnfe){
		System.out.println("File was not found.");
	    } // catch
	} // for
    } // main

} // MyCat

