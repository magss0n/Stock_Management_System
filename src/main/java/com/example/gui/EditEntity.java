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

public class EditEntity {

    static Supplier sup;
    static Customer cust;
    static Product prod;
    static private Integer prodId = 0;

    public static void supplier(Supplier s){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit Supplier");

        Text t = new Text();
        t.setText("Record New Supplier details");

        Label l1 = new Label("Name:");
        TextField name = new TextField(s.name);

        Label l2 = new Label("Contact:");
        TextField contact = new TextField(s.contact);

        Label l3 = new Label("Location:");
        TextField location = new TextField(s.location);

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> window.close());

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
                s.name = name.getText();
                s.contact = contact.getText();
                s.location = location.getText();
                AlertBox.display("Edit", "Supplier created successfully");
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

    }

    public static void customer(Customer c){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit Customer");

        Text t = new Text();
        t.setText("Record New Customer Details");

        Label l1 = new Label("Name:");
        TextField name = new TextField(c.name);

        Label l2 = new Label("Contact:");
        TextField contact = new TextField(c.contact);

        Label l3 = new Label("Location:");
        TextField location = new TextField(c.location);

        Button closeButton = new Button("Save");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event -> window.close());

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
                c.contact = contact.getText();
                c.name = name.getText();
                c.location = location.getText();
                AlertBox.display("Edit", "Customer edited successfully");
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

    }

    public static void product(Product p, Stock st){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Edit Product");

        Text t = new Text();
        t.setText("Record New Product details");

        Label l1 = new Label("Name:");
        TextField name = new TextField(p.name);

        Label l2 = new Label("Cost Price:");
        TextField cost = new TextField("" + p.getCostPrice());

        Label l3 = new Label("Sell Price:");
        TextField sell = new TextField("" + p.sellPrice);

        Label l4 = new Label("Qty:");
        TextField qty = new TextField("" + p.getQty());

        Button save = new Button("Save");
        Button cancel = new Button("Cancel");
        Button delete = new Button("Delete Product");
        cancel.setOnAction(event -> window.close());

        GridPane gridPane = new GridPane();
        gridPane.add(l1,0,0);
        gridPane.add(name,1,0);

        gridPane.add(l2, 0,1);
        gridPane.add(cost, 1,1);

        gridPane.add(l3, 0,2);
        gridPane.add(sell, 1,2);

        gridPane.add(l4, 0,3);
        gridPane.add(qty, 1,3);

        gridPane.add(save, 5,5);
        gridPane.add(cancel, 6, 5);
        gridPane.add(delete, 7, 5);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        save.setOnAction(event -> {
            try{
                if(name.getText().isEmpty() || cost.getText().isEmpty() || sell.getText().isEmpty() || qty.getText().isEmpty()){
                    AlertBox.display("Error!!", "One the required fields is empty...");
                }
                else if(Double.parseDouble(cost.getText()) >= Double.parseDouble(sell.getText())) AlertBox.display("Error", "Sell price should be greater than cost price");
                else {
                    p.setCostPrice(Double.parseDouble(cost.getText()));
                    p.sellPrice = Double.parseDouble(sell.getText());
                    p.name = name.getText();
                    p.setQty(Integer.parseInt(qty.getText()));

                    AlertBox.display("Edit", "Product Edited successfully");
                    window.close();
                }
            } catch (Exception e) {
                AlertBox.display("Error","Cost, Sell price and Quantity should be numbers");
            }
        });

        delete.setOnAction(event -> {
            if(AlertBox.confirm("Deletion")){
                st.deleteProduct(p);
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

    }

}
