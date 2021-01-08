package cs1302.gallery;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the main content of the GalleryApp.
 * This class extends {@code TilePane}.
 */
public class GalleryPane extends TilePane {

    /** Reference to {@code GalleryApp} object. */
    GalleryApp app;

    /** The array that holds the 20 {@code ImageView} objects. */
    ImageView[] iv;

    /**
     * Constructs a {@code GalleryPane} object.
     *
     * @param app reference to the {@code GalleryApp} object
     */
    public GalleryPane(GalleryApp app) {
        super();
        this.app = app;
        this.setPrefColumns(5);

        iv = new ImageView[20];

        for (int i = 0; i < 20; i ++) {
            ImageView imgView = new ImageView();
            imgView.setFitHeight(100);
            imgView.setFitWidth(100);
            iv[i] = imgView;
            this.getChildren().add(iv[i]);
        } // for

    } // GalleryPane

    /**
     * Sets the image for a specific image view.
     *
     * @param i the index to determine for which {@code ImageView} object to set the image
     * @param img the {@code Image} object that will be used
     */
    public void setImg(int i, Image img) {
        iv[i].setImage(img);
    } // setImg

} // GalleryPane
