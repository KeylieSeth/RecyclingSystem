package presentation;

import java.util.Scanner;
import application.ProductService;

public class ProductMenu {
    private Scanner scanner;
    private ProductService productService;

    public ProductMenu(ProductService productService, Scanner scanner) {
        this.scanner = scanner;
        this.productService = productService;       
    }
    public void run() {
        while (true) {
            System.out.println("Product Menu");
            System.out.println("1) Add product");
            System.out.println("2) Delete product");
            System.out.println("3) List products");
            System.out.println("4) Environmental impact");
            System.out.println("0) Back to main menu");

            String choice = readChoice();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    deleteProduct();
                    break;
                case "3":
                    listProducts();
                    break;
                case "4":
                    showImpact();
                    break;
                case "0":
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
    public String readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }
    private void addProduct() {
        System.out.println("Add product");
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter category: ");
        String category = scanner.nextLine();

        System.out.println("Enter estimated lifespan: ");
        int lifespan = scanner.nextInt();
        scanner.nextLine();

        // productService.addProduct(name, category, lifespan);
        System.out.println("Product has been added.");
    }
    private void deleteProduct() {
        System.out.println("Delete product");
        System.out.println("Enter product name to delete: ");
        String name = scanner.nextLine();

        // productService.deleteProduct(name);
        System.out.println("Product deleted.");
    }
    private void listProducts() {
        System.out.println("List of all products:");
        // productService.getAllProducts().forEach(System.out::println);
    }
    private void showImpact() {
        System.out.println("Environmental impact");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        // double impact = productService.calculateImpact(name);

       // System.out.println("Environmental impact: " + impact);
    }
}
