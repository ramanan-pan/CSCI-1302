package cs1302.ce21;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import cs1302.ce21.ImageLoader;

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

        TabPane imgPane = new TabPane();

        Tab[] tabs = {new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"), new Tab("Tab 4")};

        for (Tab t : tabs) {
            t.setContent(new ImageLoader());
            imgPane.getTabs().add(t);
        } // for

        scene = new Scene(imgPane);

        // Set up the stage and set it to be visible
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // start

} // ImageApp
