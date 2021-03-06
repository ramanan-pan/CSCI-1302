package cs1302.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.HBox;
import cs1302.gui.ImageLoader;

/**
 * A basic JavaFX 8 program which takes a user specified URL and loads it
 * into an {@code ImageView}.
 *
 */
public class ImageApp extends Application {

    Stage stage;
    Scene scene;

    /**
     * The entry point for our image viewer application.
     *
     * @param stage A reference to the stage object (window) created by the system.
     */
    public void start(Stage stage) {
        this.stage = stage;

        // Initializing the nodes for the scene graph
        ImageLoader il1 = new ImageLoader();
        ImageLoader il2 = new ImageLoader();

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(il1, il2);

        scene = new Scene(hbox);

        // Set up the stage and set it to be visible
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // start

} // ImageApp
