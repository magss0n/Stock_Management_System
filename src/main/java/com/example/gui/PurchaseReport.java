package com.example.gui;

import eu.hansolo.tilesfx.tools.FlowGridPane;
import org.w3c.dom.Text;

import java.awt.*;

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

        GridPane header = mew GridPane();
        header.add(new label("Supplier"),0,0);
        header.add(new label("Product"),1,0);
        header.add(new label("Quantity"),2,0);
        header.add(new label("Amount"),3,0);
        header.setHgap(40);
        header.setAlignment(pos,CENTER);

        VBox transactionList = new VBox(10);
        transactionList = setAligment(pos.CENTER);


        for(StockEntry entry : stockMovement.stockPurchases){
            FlowGridPane now = new GridPane();
            row.add(new Label(entry.supplier.name),0,0);
            row.add(new Label(entry.product.name),1,0);
            row.add(new Label(entry.qtyBought.toString()),2,0);
            row.add(new Label("$"+entry.purchaseAmt.toString()),3,0);
            row.setHgap(40);
            row.setAlignmentList.getChildren().add(now);

        }

        ScrollPane scrollPane = new scrollPane();
        scrollPane = setContent(transactionList);
        scrollPane = setFitToWidth(true);
        scrollPane = setMaxHeight(400);

        Button close = new Button("Close");
        close.setOnAction(e -> window.close());

        vBox layout = mew VBox(20);
        layout.getChildren().addAll(title, header,scrollPane,close);
        layout.setAlignment(pos.CENTER);
        layout.setMinSize(600,600);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
