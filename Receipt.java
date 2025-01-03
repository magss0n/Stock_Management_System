package package1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Receipt {
    private String receiptNo;
    private String customerName;
    private String date;
    private List<String> items;
    private double subtotal;
    private double tax;
    private double total;

    // Constructor with automatic date
    public Receipt(String receiptNo, String customerName) {
        this.receiptNo = receiptNo;
        this.customerName = customerName;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
        this.tax = 0.0;
        this.total = 0.0;
    }

    // Constructor with custom date
    public Receipt(String receiptNo, String customerName, String date) {
        this.receiptNo = receiptNo;
        this.customerName = customerName;
        this.date = date;
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
        this.tax = 0.0;
        this.total = 0.0;
    }

    // Add item to the receipt
    public void addItem(String itemName, int quantity, double price) {
        double totalPrice = quantity * price;
        items.add(String.format("%-12s %-8d %-8.2f %-8.2f", itemName, quantity, price, totalPrice));
        subtotal += totalPrice;
        calculateTotal();//Update totals after adding each item
    }

    private void calculateTotal() {
        tax = subtotal * 0.05; // 5% tax
        total = subtotal + tax;
    }

    // Generate receipt
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("----------------------------------------\n");
        receipt.append("       STOCK MANAGEMENT SYSTEM\n");
        receipt.append("       Payment Receipt Invoice\n");
        receipt.append("----------------------------------------\n");
        receipt.append("Receipt No: ").append(receiptNo).append("\n");
        receipt.append("Date: ").append(date).append("\n");
        receipt.append("\nCustomer: ").append(customerName).append("\n");
        receipt.append("----------------------------------------\n");
        receipt.append("Item Name      Qty      Price     Total\n");
        receipt.append("----------------------------------------\n");

        for (String item : items) {
            receipt.append(item).append("\n");
        }

        receipt.append("----------------------------------------\n");
        receipt.append(String.format("                       Subtotal: %.2f\n", subtotal));
        receipt.append(String.format("                       Tax (5%%): %.2f\n", tax));
        receipt.append(String.format("                       Total:    %.2f\n", total));
        receipt.append("----------------------------------------\n");
        receipt.append("\nThank you for trusting us!\n");
        receipt.append("----------------------------------------\n");

        return receipt.toString();
    }
}
