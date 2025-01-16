package com.example.gui;

import java.util.ArrayList;
import java.util.List;

public class StockMovement {
    public List<StockEntry> stockPurchases = new ArrayList<>();
    public List<StockExit> stockSales = new ArrayList<>();

public  void addSale(StockExit sale){
    stockSales.add(sale);
}

public void addPurchase(StockEntry purchase){
    stockPurchases.add(purchase);
}


    public void viewPurchaseReport(){
        PurchaseReport report = new PurchaseReport(this);
        report.display();

    }

    public void viewSalesReports(){


    }


}
