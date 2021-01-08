package cs1302.ce21;

import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

/**
 * The {@code ImageLoader} class extends {@code VBox} and represents a
 * component that takes in urls to load and view images.
 */
public class ImageLoader extends VBox {

    /** The root container for the application scene graph.*/
    VBox vbox;

    /** The container for the url textfield and the load image button.*/
    HBox urlLayer;
    TextField urlField;
    Button loadImage;

    /** The container for the loaded image.*/
    ImageView imgView;

    /** A default image which loads when the application starts.*/
    protected static final String DEFAULT_IMG =
        "http://cobweb.cs.uga.edu/~mec/cs1302/gui/default.png";

    /** Default height for Images.*/
    protected static final int DEF_HEIGHT = 500;

    /** Default width for Images.*/
    protected static final int DEF_WIDTH = 500;

    /**
     * Constructs an {@code ImageLoader} object and adds components to it.
     */
    public ImageLoader() {
        super();
        urlLayer = new HBox(10);
        urlField = new TextField("https://");
        loadImage = new Button("Load");

        // Adding the textfield and load image button the the containing hbox
        urlLayer.getChildren().addAll(urlField, loadImage);

        // Sets the textfield to grow, as necessary, to fill the hbox
        HBox.setHgrow(urlField, Priority.ALWAYS);

        // Load the default image with the default dimensions
        Image img = new Image(DEFAULT_IMG, DEF_HEIGHT, DEF_WIDTH, false, false);

        // Add the image to its container and preserve the aspect ratio if resized
        imgView = new ImageView(img);
        imgView.setPreserveRatio(true);

        // EventHandler for our button using a fancy method reference.
        // EventHandler<ActionEvent> loadImgHandler = this::loadImage;
        loadImage.setOnAction(this::loadImage);

        // Add the hbox and imageview to the containing vbox and set the vbox
        // to be the root of the scene
        this.getChildren().addAll(urlLayer, imgView);

    } // ImageLoader


    /**
     * Loads image to ImageView using supplied url in textfield.
     *
     * @param e source event
     */
    private void loadImage(ActionEvent e) {
        try {
            Image newImg = new Image(urlField.getText(), DEF_HEIGHT, DEF_WIDTH, false, false);
            imgView.setImage(newImg);
        } catch (IllegalArgumentException iae) {
            System.out.println("The supplied URL is invalid");
        } // try

    } // loadImage

} // ImageLoader
