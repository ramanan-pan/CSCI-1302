package cs1302.gallery;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.time.LocalTime;
import javafx.util.Duration;
import javafx.geometry.Pos;

/**
 * Represents an iTunes {@code GalleryApp}.
 */
public class GalleryApp extends Application {

    /** The {@code VBox} object that holds the app components. */
    VBox pane;

    /** The custom {@code ToolBar} object. */
    ToolBar toolBar;

    /** The {@code MenuBar} object. */
    MenuBar menuBar;

    /** The custom {@code GalleryPane} object. */
    GalleryPane galleryPane;

    /** The {@code ProgressBar} object for tracking the downloading of images. */
    ProgressBar imgProg;

    /** The {@code Timeline} object used to shuffle images. */
    Timeline shuffle;

    /** The {@code AboutStage} object that displays about info. */
    AboutStage aboutPage;

    /**
     * Start method for the {@code GalleryApp} application.
     */
    @Override
    public void start(Stage stage) {
        pane = new VBox();

        // Menu
        MenuItem exitOption = new MenuItem("Exit");
        exitOption.setOnAction(ae -> System.exit(0));
        aboutPage = new AboutStage();
        MenuItem aboutOption = new MenuItem("About");
        aboutOption.setOnAction(ae -> aboutPage.show());
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(exitOption);
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(aboutOption);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Progress bar
        HBox barAndText = new HBox(10);
        barAndText.setAlignment(Pos.CENTER_LEFT);
        imgProg = new ProgressBar();
        imgProg.setProgress(0.0);
        Text credit = new Text("Images provided courtesy of iTunes");
        barAndText.getChildren().addAll(imgProg, credit);

        // Tool bar and Gallery pane
        toolBar = new ToolBar(this);
        galleryPane = new GalleryPane(this);

        pane.getChildren().addAll(menuBar, toolBar, galleryPane, barAndText);

        // Random Replacement
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), e -> {
            Thread task = new Thread(() -> toolBar.randomReplace(e));
            task.setDaemon(true);
            task.start();
        });
        shuffle = new Timeline();
        shuffle.setCycleCount(Timeline.INDEFINITE);
        shuffle.getKeyFrames().add(keyFrame);
        shuffle.play();

        Scene scene = new Scene(pane);
        stage.setMaxWidth(640);
        stage.setMaxHeight(480);
        stage.setTitle("Gallery!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();

        toolBar.loadImages();
    } // start

    /**
     * Gets reference to the {@code GalleryPane} component.
     *
     * @return reference to app's {@code GalleryPane} object, galleryPane
     */
    public GalleryPane getGP() {
        return this.galleryPane;
    } // getGP

    /**
     * Gets reference to the {@code ToolBar} component.
     *
     * @return reference to app's {@code ToolBar} object, toolBar
     */
    public ToolBar getTB() {
        return this.toolBar;
    } // getTB

    /**
     * Gets reference to the {@code Timeline} component.
     *
     * @return reference to app's {@code Timeline} object, shuffle
     */
    public Timeline getTL() {
        return this.shuffle;
    } // getTL

    /**
     * Gets reference to the {@code ProgressBar} component.
     *
     * @return reference to app's {@code ProgressBar} object, imgProg
     */
    public ProgressBar getPG() {
        return this.imgProg;
    } // getPG

} // GalleryApp
