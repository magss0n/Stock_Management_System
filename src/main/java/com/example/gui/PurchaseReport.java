package com.example.gui;

import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;


public class PurchaseReport {
    private StockMovement stockMovement;
    private Stage window;

    public PurchaseReport(StockMovement stockMovement){
        this.stockMovement = stockMovement;
        this.window = new Stage();
    }

    public void  display(){
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Purchase report");

        Text title = new Text("Purchase Transaction report");

        GridPane header = new GridPane();
        header.add(new Label("Supplier"),0,0);
        header.add(new Label("Product"),1,0);
        header.add(new Label("Quantity"),2,0);
        header.add(new Label("Amount"),3,0);
        header.setHgap(40);
        header.setAlignment(Pos.CENTER);

        VBox transactionList = new VBox(10);
        transactionList.setAlignment(Pos.CENTER);


        for(StockEntry entry : stockMovement.stockPurchases){
            FlowGridPane row = new FlowGridPane(4,4);
            row.add(new Label(entry.supplier.name),0,0);
            row.add(new Label(entry.product.name),1,0);
            row.add(new Label(entry.qtyBought.toString()),2,0);
            row.add(new Label("$"+entry.purchaseAmt.toString()),3,0);
            row.setHgap(40);
//            row.getChildren().add(row);
            row.setAlignment(Pos.CENTER);

        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(transactionList);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxHeight(400);

        Button close = new Button("Close");
        close.setOnAction(e -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(title, header,scrollPane,close);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(600,600);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
