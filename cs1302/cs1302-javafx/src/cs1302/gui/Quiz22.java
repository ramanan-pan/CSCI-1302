package cs1302.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
cimport javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Quiz22 extends Application {

    public static final String SHERLOCK =
        "http://deelay.me/5000/http://cobweb.cs.uga.edu/~mec/cs1302/gui/doyle_bohemia.txt";

    protected VBox mainPane = new VBox();
    protected HBox urlPane = new HBox();
    protected ScrollPane textPane = new ScrollPane();

    protected TextField urlField = new TextField(SHERLOCK);
    protected Button urlButton = new Button("Load");
    protected TextFlow textFlow = new TextFlow();

    @Override
    public void start(Stage stage) {

        HBox.setHgrow(urlField, Priority.ALWAYS);
        urlButton.setOnAction(e -> {
            Thread task = new Thread (() -> loadPage(stage));
            task.setDaemon(true);
            task.start();
        });
        urlPane.getChildren().addAll(urlField, urlButton);

        textFlow.getChildren().add(new Text("Click \"Load\" to load the .txt file..."));
        textFlow.setMaxWidth(630);
        textPane.setPrefHeight(480);
        textPane.setContent(textFlow);

        mainPane.getChildren().addAll(urlPane, textPane);

        stage.setScene(new Scene(mainPane, 640, 480));
        stage.sizeToScene();
        stage.setTitle("ExampleApp!");
        stage.show();

    } // start

    private void loadPage(Stage stage) {
        urlButton.setDisable(true);

        Platform.runLater(() -> textFlow.getChildren().clear());
        try {
            URL url = new URL(urlField.getText());
            Scanner site = new Scanner(url.openStream());
            while (site.hasNextLine()) {
                String line = site.nextLine() + "\n";
                Platform.runLater(() -> textFlow.getChildren().add(new Text(line)));
            } // while
        } catch (IOException ex) {
            textFlow.getChildren().add(new Text(ex.getMessage()));
            // Platform.runLater(() -> textFlow.getChildren().add(new Text(ex.getMessage())));
        } // try
        urlButton.setDisable(false);
    } // loadPage

} // Quiz22
