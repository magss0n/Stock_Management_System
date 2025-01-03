package package1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Ensure decimals are parsed with a period (.)

        // Collect basic details
        while (true) { // Outer loop for handling multiple receipts
        System.out.print("Enter receipt number: ");
        String receiptNo = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Use current date

        // Create a new receipt
        Receipt receipt = new Receipt(receiptNo, customerName, date);

        // Add items to the receipt
        System.out.println("Enter items for the receipt (type 'done' to finish):");
        while (true) {
            System.out.print("Item name (or 'done'): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Price: ");
            String priceInput = scanner.nextLine(); // Read price as a string
            priceInput = priceInput.replace(",", "."); // Replace commas with periods
            double price;

            try {
                price = Double.parseDouble(priceInput); // Convert to double
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
                continue;
            }
            receipt.addItem(itemName, quantity, price);
        }

        // Generate and print the receipt
        System.out.println("\nGenerated Receipt:\n");
        System.out.println(receipt.generateReceipt());

        System.out.print("Do you want to create another receipt? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("no")) {
            System.out.println("Thank you for using the receipt generator!");
            break;
        }
    }
        scanner.close();
    }
}