package cs1302.gallery;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * Represents an About stage. Extends the {@code Stage} class.
 */
public class AboutStage extends Stage {

    /** The {@code} Button object used to close the stage.*/
    Button close;

    /** The {@code HBox} object that holds the stage components. */
    HBox hbox;

    /** The {@code VBox} object that holds text. */
    VBox info;

    /** The {@code ImageView} object that displays the about image. */
    ImageView iv;

    /**
     * Constructs an {@code AboutStage} object.
     */
    public AboutStage() {
        super();

        this.initModality(Modality.APPLICATION_MODAL);

        Image img = new Image("file:resources/about.jpg");
        iv = new ImageView(img);

        close = new Button("Close");
        close.setOnAction(e -> this.close());

        // Information
        info = new VBox(10);
        Text name = new Text("Hi! My name is Ramanan Pannirselvam.");
        Text email = new Text("Email: rp60721@uga.edu ");
        Text version = new Text("Version: 1.0");

        info.getChildren().addAll(name, email, version, close);
        info.setPadding(new Insets(10.0));
        info.setAlignment(Pos.CENTER);

        hbox = new HBox(10);
        hbox.setPadding(new Insets(10.0));
        hbox.getChildren().addAll(iv, info);

        Scene scene = new Scene(hbox);
        this.setMaxWidth(320);
        this.setMaxHeight(240);
        this.setTitle("About Ramanan Pannirselvam");
        this.setScene(scene);
        this.sizeToScene();
        this.setResizable(false);

    } // AboutStage

} // About Stage
