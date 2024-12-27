package com.example.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class AlertBox {
    static Boolean answer;

    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title + "!!");

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> window.close());

        VBox vbox = new VBox(20);
        vbox.setMinSize(400, 100);
        vbox.getChildren().addAll(label, closeButton);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
    }

    public static Boolean confirm(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Deletion !!");

        Label label = new Label();
        label.setText("Are you sure? ");
        Button yes = new Button("Yes");
        yes.setOnAction(event -> {
            answer = true;
            window.close();
        });

        Button no = new Button("No");
        no.setOnAction(event -> {
            answer = false;
            window.close();
        });

        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(yes, no);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(20);
        vbox.setMinSize(400, 100);
        vbox.getChildren().addAll(label, hbox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
