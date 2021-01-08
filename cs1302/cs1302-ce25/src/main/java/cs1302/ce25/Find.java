package cs1302.ce25;

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class represents the functionality of the find unix command.
 */
public class Find {

    /**
     * Prints the files and directories given by the command args.
     *
     * @param file {@code File} object
     */
    public static void printFile(File file) {
        if (file.exists()) {
            System.out.println(file.getPath());
            if (file.isDirectory()) {
                Arrays.stream(file.listFiles())
                    .forEach(Find::printFile);
            } // if
        } else {
            System.err.printf("find: `%s': No such file or directory\n", file.getPath());
        } // if
    } // printFile

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] { "." }; // default to "."
        } // if

        Arrays.stream(args)
            .map(File::new)
            .forEach(Find::printFile);

    } // main

} // Find
