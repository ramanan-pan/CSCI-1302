package cs1302.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Priority;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Quiz19 extends Application {

    @Override
    public void start(Stage stage) {

        HBox hbox = new HBox(8);
        TextField field = new TextField();
        Label search = new Label("Search:");
        Button goButton = new Button("Go");

        Image img = new Image("http://csweb.cs.uga.edu/~mec/cs1302/flower.png");
        ImageView v1 = new ImageView();
        v1.setImage(img);

        v1.resize(100, 50);

        v1.getId();

        v1.toString();
        v1.setRotate(90.0);

        v1.setPreserveRatio(true);



        hbox.setPadding(new Insets(10));
        HBox.setHgrow(field, Priority.ALWAYS);
        hbox.getChildren().addAll(search, field, goButton);
        hbox.setAlignment(Pos.CENTER_LEFT);

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle("Quiz App");
        stage.sizeToScene();
        stage.show();




    } // start

} // Quiz 19
