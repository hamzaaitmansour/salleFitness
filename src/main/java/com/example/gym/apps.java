package com.example.gym;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class apps extends Application {
    static public void SwitchSene(String fxml ,int heihgt , int width) throws IOException {
        scene = new Scene(loadFXML(fxml),heihgt,width);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }
    private double x =0;
    private double y =0;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        root.setOnMousePressed((MouseEvent event )->{
            x= event.getSceneX();
            y=event.getSceneY();

        });
        root.setOnMouseDragged((MouseEvent event )->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            stage.setOpacity(.8);
        });
        root.setOnMouseReleased((MouseEvent event )->{
            stage.setOpacity(1);
        });
        stage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(root);
        stage.setTitle("Gym management Login");

        scene.getStylesheets().add("Design.css");
        // scene.getStylesheets().add("DashboardStyle.css");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {


        scene.setRoot(loadFXML(fxml));

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(apps.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}