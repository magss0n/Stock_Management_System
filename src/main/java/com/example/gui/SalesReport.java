package com.example.gui;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class SalesReport {
    private StockMovement stockMovement;
    private Stage window;

    public SalesReport(StockMovement stockMovement){
        this.stockMovement = stockMovement;
        this.window = new Stage();
    }

    public void  display(){
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Purchase report");

        Text title = new Text("Sales Transaction report");

        GridPane header = new GridPane();
        header.add(new Label("Customer"),0,0);
        header.add(new Label("Product"),1,0);
        header.add(new Label("Quantity"),2,0);
        header.add(new Label("Amount"),3,0);
        header.setHgap(40);
        header.setAlignment(Pos.CENTER);

        VBox transactionList = new VBox(10);
        transactionList.setAlignment(Pos.CENTER);


        if (stockMovement != null&& stockMovement.stockPurchases !=null){

            for (StockExit sale : stockMovement.stockSales){
                GridPane row = new GridPane();

                String customerName = sale.customer !=null ? sale.customer.name : "None";
                String productName =sale.product !=null ? sale.product.name : "None";
                String quantity = sale.qtySold !=null ? sale.qtySold.toString(): "0";
                String amount = sale.salesAmt !=null ? sale.salesAmt.toString(): "0";


                row.add(new Label(customerName),0,0);
                row.add(new Label(productName),1,0);
                row.add(new Label(quantity),2,0);
                row.add(new Label("$" + amount),3,0);
                row.setHgap(40);
                row.setAlignment(Pos.CENTER);

                transactionList.getChildren().add(row);
            }
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
