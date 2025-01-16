package com.example.gui;

import javafx.application.Application;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main extends Application {
    static Stage window;
    static Scene scene1, scene2;
    static Admin admin = new Admin();
    static List<Supplier> suppliers = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static Supplier supSelected;
    static Customer custSelected;
    static Product prodSelected;
    static Stock stock = new Stock();
    static StockMovement stockMovement = new StockMovement();


    @Override
    public void start(Stage stage) {
        window = stage;

        //creating label email
        Text text1 = new Text("User ID:");

        //creating label password
        Text text2 = new Text("Password:");

        //creating label welcome
        Text text3 = new Text("Welcome to our System");

        //Creating Text Filed for email
        TextField idField = new TextField("Enter Id");

        //Creating Text Filed for password
        PasswordField passwordField = new PasswordField();

        //Creating Buttons
        Button button1 = new Button("Submit");
        button1.setOnAction(event -> {
            if (!admin.authenticate(idField.getText(),passwordField.getText())) {
                AlertBox.display("Error!", "Invalid user Id or Password");
            }
            else {
                mainMenu();
            }
        });
        Button button2 = new Button("Clear");
        button2.setOnAction(event -> {
            idField.setText("");
            passwordField.setText("");
        });

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        //Arranging all the nodes in the grid
        gridPane.add(text1, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(text2, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(button1, 0, 2);
        gridPane.add(button2, 1, 2);

        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: BEIGE;");
        vbox.getChildren().addAll(text3, gridPane);

        //Setting size for the pane
        vbox.setMinSize(800, 800);

        //Creating a scene object
        scene1 = new Scene(vbox);

        //Setting title to the Stage
        window.setTitle("Stock Management");

        //Adding scene to the stage
        window.setScene(scene1);

        //Displaying the contents of the stage
        window.show();
    }
    public static void main(String args[]){
        launch(args);
    }

    private static void mainMenu(){
        Text welcome = new Text("Welcome " + admin.getName());
        VBox layout = new VBox(40);
        layout.setMinSize(800,800);

        Button b1 = new Button("Stock Entry");
        b1.setOnAction(event -> saveStockEntry());

        Button b2 = new Button("Stock Exit");
        b2.setOnAction(event -> saveStockExit());

        Button b3 = new Button("View Stock");
        b3.setOnAction(event -> viewStock());

        Button b4 = new Button("View Customers/Suppliers");
        b4.setOnAction(event -> viewCustomersOrSuppliers());

        Button b5 = new Button("View Purchase Report");
        b5.setOnAction(event -> {
            PurchaseReport report = new PurchaseReport(stockMovement);
            report.display();
        });
        Button b6 = new Button("View Purchase Report");
        b6.setOnAction(event -> {
            SalesReport report = new SalesReport(stockMovement);
            report.display();
        });
        Button b7 = new Button("Exit");
        b7.setStyle("-fx-color: RED;");
        b7.setOnAction(event -> {
            if(AlertBox.confirm("Exit")) window.close();
        });

        layout.getChildren().addAll(welcome,b1,b2,b3,b4,b5,b6,b7); //added all buttons
        layout.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout);

        window.setScene(scene2);
        window.show();
    }

    private static void saveStockEntry(){
        Text t = new Text("Enter Transaction details");

        VBox vbox = new VBox(40);

        GridPane gridPane = new GridPane();
        Label l1 = new Label("Supplier: ");

        ChoiceBox<String> supplierlist = new ChoiceBox<>();
        supplierlist.getItems().addAll(suppliers.stream().map(supplier -> supplier.name).toList());
        supplierlist.setMaxSize(300,200);

        Label l2 = new Label("Product");
        ChoiceBox<String> productlist = new ChoiceBox<>();
        productlist.getItems().addAll(stock.getProducts().stream().map(product -> product.name).toList());
        productlist.setMaxSize(300,200);

        Label l3 = new Label("Purchase Amount: ");
        TextField amount = new TextField();

        Label l4 = new Label("Quantity");
        TextField qty = new TextField();

        Button newSupplier = new Button("New Supplier");
        Button newProduct = new Button("New Product");
        Button cancel = new Button("Cancel");
        Button save = new Button("Save");

        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(save, cancel);

        vbox.setPadding(new Insets(5,5,5,5));

        gridPane.add(l1, 0,0);
        gridPane.add(supplierlist, 1,0);
        gridPane.add(newSupplier, 2,0);

        gridPane.add(l2, 0,1);
        gridPane.add(productlist, 1,1);
        gridPane.add(newProduct, 2,1);

        gridPane.add(l3, 0,2);
        gridPane.add(amount, 1,2);

        gridPane.add(l4, 0,3);
        gridPane.add(qty, 1,3);

        cancel.setOnAction(event -> window.setScene(scene2));

        newSupplier.setOnAction(event -> {
            Supplier s = RecordEntity.supplier("New Supplier");
            System.out.println("Supplier: " + s);
            if (s != null) {
                suppliers.add(s);
                supplierlist.getItems().add(suppliers.stream().map(supplier -> supplier.name).toList().getLast());
            }
            System.out.println("Supplier: " + s);
        });

        newProduct.setOnAction(event -> {
            Product p = RecordEntity.product("New Product");
            if(p != null){
                stock.addProduct(p);
                productlist.getItems().addAll(stock.getProducts().stream().map(product -> product.name).toList().getLast());
            }
            System.out.println("Product: " + p);
        });

        save.setOnAction(event -> {
            System.out.println("SElect: " + supplierlist.getValue());
            try {
                supSelected = suppliers.stream().filter(supplier -> Objects.equals(supplier.name, supplierlist.getValue())).toList().getFirst();
                prodSelected = stock.getProducts().stream().filter(product -> Objects.equals(product.name, productlist.getValue())).toList().getFirst();
            } catch (Exception e) {
//               //Do nothing, let the next if-else block display the AlertBox
            }

            if (suppliers.contains(supSelected) && stock.getProducts().contains(prodSelected) && !qty.getText().isEmpty() && !amount.getText().isEmpty()){
                Integer quantity = Integer.parseInt(qty.getText());
                Double amt = Double.parseDouble(amount.getText());
                stock.setQty(prodSelected, quantity);
                stockMovement.stockPurchases.add(new StockEntry(supSelected,amt, prodSelected, quantity));
                System.out.println("Entries" + stockMovement.stockPurchases);
                AlertBox.display("Successful", "Stock Entry Successfully saved");
                window.setScene(scene2);
            }
            else AlertBox.display("Error", "One of the  required fields is empty");
        });

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(t,gridPane, hbox);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setMinSize(800, 800);
        scene1 = new Scene(vbox);
        window.setScene(scene1);
        window.show();
    }

    private static void saveStockExit(){
        Text t = new Text("Enter Transaction details");

        VBox vbox = new VBox(40);

        GridPane gridPane = new GridPane();
        Label l1 = new Label("Customer: ");

        ChoiceBox<String> customerlist = new ChoiceBox<>();
        customerlist.getItems().addAll(customers.stream().map(customer -> customer.name).toList());
        customerlist.setMaxSize(300,200);

        Label l2 = new Label("Product");
        ChoiceBox<String> productlist = new ChoiceBox<>();
        productlist.getItems().addAll(stock.getProducts().stream().map(product -> product.name).toList());
        productlist.setMaxSize(300,200);

        Label l3 = new Label("Sales Amount: ");
        TextField amount = new TextField();

        Label l4 = new Label("Quantity");
        TextField qty = new TextField();

        Button newCustomer = new Button("New Customer");
//        Button newProduct = new Button("New Product");
        Button cancel = new Button("Cancel");
        Button save = new Button("Save");

        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(save, cancel);

        vbox.setPadding(new Insets(5,5,5,5));

        gridPane.add(l1, 0,0);
        gridPane.add(customerlist, 1,0);
        gridPane.add(newCustomer, 2,0);

        gridPane.add(l2, 0,1);
        gridPane.add(productlist, 1,1);

        gridPane.add(l3, 0,2);
        gridPane.add(amount, 1,2);

        gridPane.add(l4, 0,3);
        gridPane.add(qty, 1,3);

        cancel.setOnAction(event -> window.setScene(scene2));

        newCustomer.setOnAction(event -> {
            Customer c = RecordEntity.customer("New Customer");
            System.out.println("Customer: " + c);
            if (c != null) {
                customers.add(c);
                customerlist.getItems().add(customers.stream().map(customer -> customer.name).toList().getLast());
            }
            System.out.println("Customer: " + c);
        });

        save.setOnAction(event -> {
            System.out.println("SElect: " + customerlist.getValue());
            try {
                custSelected = customers.stream().filter(customer -> Objects.equals(customer.name, customerlist.getValue())).toList().getFirst();
                prodSelected = stock.getProducts().stream().filter(product -> Objects.equals(product.name, productlist.getValue())).toList().getFirst();
            } catch (Exception e) {
//               //Do nothing, let the next if-else block display the AlertBox
            }

            if (customers.contains(custSelected) && stock.getProducts().contains(prodSelected) && !qty.getText().isEmpty() && !amount.getText().isEmpty()){
                Integer quantity = Integer.parseInt(qty.getText());
                Double amt = Double.parseDouble(amount.getText());

                if (stock.editProductQty(prodSelected, quantity)){
                    stockMovement.stockSales.add(new StockExit(custSelected, prodSelected,amt, quantity));
                    System.out.println("Sales: " + stockMovement.stockSales);
                    AlertBox.display("Successful", "Stock Exit Successfully saved");
                }

                window.setScene(scene2);
            }

            else AlertBox.display("Error", "One of the  required fields is empty");
        });

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(t,gridPane, hbox);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setMinSize(800, 800);
        scene1 = new Scene(vbox);
        window.setScene(scene1);
        window.show();
    }


    private static void viewStock(){
        ObservableList<Product> products = FXCollections.observableArrayList(stock.getProducts());
        ListView<Product> listView = new ListView<>(products);
        listView.setOnMouseClicked(mouseEvent -> {
            if(!listView.getItems().isEmpty()){
                prodSelected = listView.getSelectionModel().getSelectedItem();
                stock.editProduct(prodSelected);
                viewStock();
            }
        });
        listView.setMaxSize(600,600);

        Button back = new Button("Back");
        back.setOnAction(event -> window.setScene(scene2));

        Button newProduct = new Button("New Product");
        newProduct.setOnAction(event -> {
            Product p = RecordEntity.product("New Product");
            if(p != null){
                stock.addProduct(p);
                viewStock();
            }
            System.out.println("Product: " + p);
        });

        Label l = new Label("Products");

        HBox hbox = new HBox(60);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(back, newProduct);

        VBox vbox = new VBox(40);

        vbox.getChildren().addAll(l,listView, hbox);
        vbox.setAlignment(Pos.CENTER);

        scene1 = new Scene(vbox, 800, 800);

        window.setScene(scene1);
    }

    private static void viewCustomersOrSuppliers(){
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList(customers);
        ListView<Customer> customerListView = new ListView<>(customerObservableList);

        customerListView.setOnMouseClicked(mouseEvent -> {
            if(!customerListView.getItems().isEmpty()){
                custSelected = customerListView.getSelectionModel().getSelectedItem();
                if(custSelected != null){
                    Integer i = customers.indexOf(custSelected);
                    EditEntity.customer(customers.get(i));
                    viewCustomersOrSuppliers();
                }
            }
        });
        customerListView.setMaxSize(500,400);

        Button back = new Button("Back");
        back.setOnAction(event -> window.setScene(scene2));

        Button newCustomer = new Button("New Customer");
        newCustomer.setOnAction(event -> {
            Customer c = RecordEntity.customer("New Customer");
            if(c != null){
                customers.add(c);
                viewCustomersOrSuppliers();
            }
            System.out.println("Customer: " + c);
        });

        Label l = new Label("Customers");

        VBox vbox = new VBox(40);

        vbox.getChildren().addAll(l,customerListView);
        vbox.setAlignment(Pos.CENTER);

        ObservableList<Supplier> supplierObservableList = FXCollections.observableArrayList(suppliers);
        ListView<Supplier> supplierListView = new ListView<>(supplierObservableList);

        supplierListView.setOnMouseClicked(mouseEvent -> {
            if(!supplierListView.getItems().isEmpty()){
                supSelected = supplierListView.getSelectionModel().getSelectedItem();
                if(supSelected != null){
                    Integer i = suppliers.indexOf(supSelected);
                    EditEntity.supplier(suppliers.get(i));
                    viewCustomersOrSuppliers();
                }
            }
        });

        supplierListView.setMaxSize(500,400);

        Button newSupplier = new Button("New Supplier");
        newSupplier.setOnAction(event -> {
            Supplier s = RecordEntity.supplier("New Supplier");
            if(s != null){
                suppliers.add(s);
                viewCustomersOrSuppliers();
            }
            System.out.println("Supplier: " + s);
        });

        Label l1 = new Label("Suppliers");

        VBox vbox1 = new VBox(40);

        vbox1.getChildren().addAll(l1, supplierListView);
        vbox1.setAlignment(Pos.CENTER);


        HBox hbox1 = new HBox(100);
        hbox1.setAlignment(Pos.CENTER);

        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(back, newCustomer, newSupplier);

        HBox hbox = new HBox(100);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox,vbox1);

        VBox layout = new VBox(60);
        layout.getChildren().addAll(hbox, hbox1);
        layout.setAlignment(Pos.CENTER);

        scene1 = new Scene(layout, 800, 800);

        window.setScene(scene1);
    }


}