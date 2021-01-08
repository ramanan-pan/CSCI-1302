package cs1302.ce20;

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

    /** The HBox object for zoom buttons. */
    HBox zoomBox;

    /** The ImageView object. */
    ImageView iv;

    /** The TextField object where urls are passed.*/
    TextField urlField;

    /** The Button object used to load the image.*/
    Button loadButton;

    /** The Button object used to zoom in.*/
    Button zoomIn;

    /** The Button object used to zoom out.*/
    Button zoomOut;

    /** The Button object used reset image to actual size.*/
    Button actSize;

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        hbox = new HBox(10);
        zoomBox = new HBox(10);

        Image image = new Image("http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png");
        iv = new ImageView(image);
        iv.setFitHeight(image.getHeight());
        iv.setPreserveRatio(true);
        urlField = new TextField("https://");
        loadButton = new Button("Load");
        vbox.getChildren().addAll(hbox, iv, zoomBox);

        HBox.setHgrow(urlField, Priority.ALWAYS);
        hbox.getChildren().addAll(urlField, loadButton);
        // Buttons
        zoomIn = new Button("", new ImageView(new Image("file:resources/zoom-in-50.png")));
        zoomOut = new Button("", new ImageView(new Image("file:resources/zoom-out-50.png")));
        actSize = new Button("", new ImageView(new Image("file:resources/actual-size-50.png")));
        // Aligning buttons and adding to appropriate HBox
        HBox.setHgrow(zoomIn, Priority.ALWAYS);
        HBox.setHgrow(zoomOut, Priority.ALWAYS);
        HBox.setHgrow(actSize, Priority.ALWAYS);
        zoomIn.setMaxWidth(Double.MAX_VALUE);
        zoomOut.setMaxWidth(Double.MAX_VALUE);
        actSize.setMaxWidth(Double.MAX_VALUE);
        zoomBox.getChildren().addAll(zoomIn, zoomOut, actSize);
        // Event handling
        loadButton.setOnAction(e -> {
            load();
            stage.sizeToScene();
        });
        zoomIn.setOnAction(e -> {
            zoom(25);
            stage.sizeToScene();
        });
        zoomOut.setOnAction(e -> {
            zoom(-25);
            stage.sizeToScene();
        });

        actSize.setOnAction(e -> {
            zoom(0);
            stage.sizeToScene();
        });

        stage.setScene(scene);
        stage.setTitle("1302 Image Viewer!");
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
    } // main

    /**
     * Loads the supplied image from the text field into the ImageView.
     * Called when loadButton is pressed.
     */
    private void load() {
        System.out.println(urlField.getText());
        try {
            Image urlImg = new Image(urlField.getText());
            iv.setImage(urlImg);
            iv.setFitHeight(urlImg.getHeight());
        } catch (IllegalArgumentException iae) {
            System.err.println("The supplied URL is invalid or unsupported.");
            System.err.println("Please enter a URL to an image file.");
        } // try-catch
    } // load

    /**
     * Resizes the ImageView object according to the amt.
     *
     * @param amt double value used to resize {@code ImageView} {@code fitHeight} property
     */
    private void zoom(double amt) {
        double current = iv.getFitHeight();
        if (amt > 0) {
            if (current + amt > 2 * iv.getImage().getHeight()) {
                zoomIn.setDisable(true);
                zoomOut.setDisable(false);
            } else {
                iv.setFitHeight(current + amt);
            } // if
        } // if
        if (amt < 0) {
            if (current + amt <= 0) {
                zoomOut.setDisable(true);
                zoomIn.setDisable(false);
            } else {
                iv.setFitHeight(current + amt);
            } // if
        } // if
        if (amt == 0) {
            zoomIn.setDisable(false);
            zoomOut.setDisable(false);
            iv.setFitHeight(iv.getImage().getHeight());
        } // if
    } // zoom

} // ImageApp
