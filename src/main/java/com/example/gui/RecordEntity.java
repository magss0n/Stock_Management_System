package com.example.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RecordEntity {

    static Supplier sup;
    static Customer cust;
    static Product prod;
    static private Integer prodId = 0;

    public static Supplier supplier(String title){
        
        Stage window = new Stage();
        window.setOnCloseRequest(windowEvent -> sup = null);


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Text t = new Text();
        t.setText("Record " + title);

        Label l1 = new Label("Name:");
        TextField name = new TextField("Enter name");

        Label l2 = new Label("Contact:");
        TextField contact = new TextField("Enter contact");

        Label l3 = new Label("Location:");
        TextField location = new TextField("Enter location");

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            sup = null;
            window.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(l1,0,0);
        gridPane.add(name,1,0);

        gridPane.add(l2, 0,1);
        gridPane.add(contact, 1,1);

        gridPane.add(l3, 0,2);
        gridPane.add(location, 1,2);

        gridPane.add(save, 5,5);
        gridPane.add(cancel, 6, 5);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        save.setOnAction(event -> {
            if(location.getText().isEmpty() || name.getText().isEmpty() || contact.getText().isEmpty()){
                AlertBox.display("Error!!", "One the required fields is empty...");
            }
            else {
                sup = new Supplier(name.getText(), contact.getText(), location.getText());
                AlertBox.display("Creation", "Supplier created successfully");
                window.close();
            }
        });

        VBox vbox = new VBox(20);
        vbox.setMinSize(600, 600);
        vbox.getChildren().addAll(t,gridPane);
        vbox.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

        return sup;
    }

    public static Customer customer(String title){

        Stage window = new Stage();
        window.setOnCloseRequest(windowEvent -> cust = null);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Text t = new Text();
        t.setText("Record " + title);

        Label l1 = new Label("Name:");
        TextField name = new TextField("Enter name");

        Label l2 = new Label("Contact:");
        TextField contact = new TextField("Enter contact");

        Label l3 = new Label("Location:");
        TextField location = new TextField("Enter location");

        Button closeButton = new Button("Save");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            cust = null;
            window.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(l1,0,0);
        gridPane.add(name,1,0);

        gridPane.add(l2, 0,1);
        gridPane.add(contact, 1,1);

        gridPane.add(l3, 0,2);
        gridPane.add(location, 1,2);

        gridPane.add(closeButton, 5,5);
        gridPane.add(cancel, 6, 5);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        closeButton.setOnAction(event -> {
            if(location.getText().isEmpty() || name.getText().isEmpty() || contact.getText().isEmpty()){
                AlertBox.display("Error!!", "One the required fields is empty...");
            }
            else {
                cust = new Customer(name.getText(), contact.getText(), location.getText());
                AlertBox.display("Creation", "Customer created successfully");
                window.close();
            }
        });

        VBox vbox = new VBox(20);
        vbox.setMinSize(600, 600);
        vbox.getChildren().addAll(t,gridPane);
        vbox.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

        return cust;
    }

    public static Product product(String title){
        Stage window = new Stage();
        window.setOnCloseRequest(windowEvent -> prod = null);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Text t = new Text();
        t.setText("Record " + title);

        Label l1 = new Label("Name:");
        TextField name = new TextField("Enter name");

        Label l4 = new Label("Category:");
        TextField category = new TextField("Enter category");

        Label l2 = new Label("Cost Price");
        TextField cost = new TextField();

        Label l3 = new Label("Sell Price");
        TextField sell = new TextField();

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> {
            prod = null;
            window.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(l1,0,0);
        gridPane.add(name,1,0);

        gridPane.add(l4,0,1);
        gridPane.add(category,1,1);

        gridPane.add(l2, 0,2);
        gridPane.add(cost, 1,2);

        gridPane.add(l3, 0,3);
        gridPane.add(sell, 1,3);

        gridPane.add(save, 5,6);
        gridPane.add(cancel, 6, 6);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        save.setOnAction(event -> {
            try{
                if(name.getText().isEmpty() || cost.getText().isEmpty() || sell.getText().isEmpty() || category.getText().isEmpty()){
                    AlertBox.display("Error!!", "One the required fields is empty...");
                }
                else if(Double.parseDouble(cost.getText()) >= Double.parseDouble(sell.getText())) AlertBox.display("Error", "Sell price should be greater than cost price");
                else {
                    prod = new Product(name.getText(), category.getText(), Double.parseDouble(cost.getText()), Double.parseDouble(sell.getText()), prodId);
                    prodId++;
                    AlertBox.display("Creation", "Product created successfully");

                    window.close();
                }
            } catch (Exception e) {
                AlertBox.display("Error","Cost and Sell price should be numbers");
            }
        });

        VBox vbox = new VBox(20);
        vbox.setMinSize(600, 600);
        vbox.getChildren().addAll(t,gridPane);
        vbox.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();

        return prod;
    }

}
