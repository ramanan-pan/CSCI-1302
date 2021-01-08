package cs1302.ce22;

import javafx.application.Application;

/**
 * Driver for image application.
 */
public class ImageDriver {

    public static void main(String[] args) {
        try {
            Application.launch(ImageApp.class, args);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
            System.err.println("Likely due to X11 timeout. Logout and log back in...");
            System.exit(1);
        } // try
    } // main

} // ImageDriver
