package cs1302.ce19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Represents a basic image viewer app.
 */
public class ImageApp extends Application {

    /** The HBox object. */
    HBox hbox;

    /** The ImageView object. */
    ImageView iv;

    /** The TextField object where urls are passed.*/
    TextField urlField;

    /** The Button object used to load the image.*/
    Button loadButton;


    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        hbox = new HBox();

        Image image = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        iv = new ImageView(image);

        urlField = new TextField("https://");

        loadButton = new Button("Load");

        vbox.getChildren().addAll(hbox, iv);
        hbox.setHgrow(urlField, Priority.ALWAYS);
        hbox.getChildren().addAll(urlField, loadButton);

        EventHandler<ActionEvent> loadHandler = ae -> {
            System.out.println(urlField.getText());
            try {
                Image urlImg = new Image(urlField.getText());
                iv.setImage(urlImg);
            } catch (IllegalArgumentException iae) {
                System.err.println("The supplied URL is invalid or unsupported.");
                System.err.println("Please enter a URL to an image file.");
            } // try-catch
        };

        loadButton.setOnAction(loadHandler);

        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.show();

    } // main

} // ImageApp
