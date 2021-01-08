package cs1302.ce25;

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class represents the functionality of the tree unix command.
 */
public class Tree {

    /**
     * Prints the files and directories given by the command args as a tree.
     *
     * @param file {@code File} object
     * @param count {@code int} object that keeps track of formatting
     */
    public static void printFile(File file, int count) {
        if (file.exists()) {

            if (file.isFile()) {
                System.out.print("|");
                for (int i = 0; i < count; i++) {
                    System.out.print("   |");
                } // for
                System.out.println("---" + file.getName());
            } // if

            if (file.isDirectory()) {
                if (count == 0) {
                    System.out.print("|");
                    System.out.println("---" + file.getName());
                } else {
                    System.out.print("|");
                    for (int i = 0; i < count; i++) {
                        System.out.print("   |");
                    } // for
                    System.out.println("---" + file.getName());
                } // if

                Arrays.stream(file.listFiles())
                    .forEach(f -> printFile(f, count + 1));
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
            .forEach(f -> printFile(f, 0));

    } // main

} // Tree
