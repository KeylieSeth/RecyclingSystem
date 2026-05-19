package presentation;

import java.util.List;
import java.util.Scanner;

import application.ProductService;
import application.RecyclingGuidanceService;
import domain.Product;

public class RecyclingMenu {
    private ProductService productService;
    private RecyclingGuidanceService recyclingGuidanceService;
    private Scanner scanner;

    public RecyclingMenu(ProductService productService, RecyclingGuidanceService recyclingGuidanceService, Scanner scanner){
        this.productService = productService;
        this.recyclingGuidanceService = recyclingGuidanceService;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            printMenu();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n===== Recycling Guidance =====");
                    //changeRecyclingGuidanceForProduct();
                    break;
                case "2":
                    System.out.println("\n====== Recycle Product ======");
                    //Recycle a product.
                    //recycleProduct();
                    break;
                case "3":
                    System.out.println("\n= Change Recycling Guidance =");
                    //Change recycling guidance for product.
                    break;
                case "0":
                    return;
                default:
                    System.out.println(choice + " is not a valid input.");
                    break;
            }
        }
    }

    public void printMenu() {
        String menuText = """

                ======= Recycling Menu =======
                ------------------------------
                1) Recycling guidance       
                2) Recycle a product    
                3) Change recycling guidance 
                   for product                         
                0) Back to main menu 
                ------------------------------""";

        System.out.println(menuText);
    }

//     private void showRecyclingGuidance() {
//         List<Product> products = productService.getAllProducts();

//         //if (products.isEmpty()) {
//             System.out.println("No products available.");
//             return;
//         }

//         //printProducts(products);

//         System.out.print("Enter product number: ");
//         int index = readInt();

//         if (index < 1 || index > products.size()) {
//             System.out.println("Invalid product number.");
//             return;
//         }

//         Product product = products.get(index - 1);
//         //String guidance = recyclingGuideService.getGuidance(product);

//         //System.out.println("\nRecycling guidance for " + product.getName() + ":");
//         //System.out.println(guidance);
//     }

//     private void changeRecyclingGuidanceForProduct() {
//         //List<Product> products = productService.getAllProducts();

//         //if (products.isEmpty()) {
//             System.out.println("No products available.");
//             return;
//         }

//         ////if (index < 1 || index > products.size()) {
//             //System.out.println("Invalid product number.");
//        //     return;
//         //}

//         //Product product = products.get(index - 1);

//         //System.out.print("Enter new recycling guidance: ");
//         String newGuidance = scanner.nextLine();

//         //recyclingGuidanceService.updateGuidance(product, newGuidance);

//         //System.out.println("Recycling guidance updated for " + product.getName() + ".");
//     }

//     private void recycleProduct() {
//         //List<Product> products = productService.getAllProducts();

//         if (products.isEmpty()) {
//             System.out.println("No products available.");
//             return;
//         }

//         printProducts(products);

//         System.out.print("Enter product number to recycle: ");
//         int index = readInt();

//         if (index < 1 || index > products.size()) {
//             System.out.println("Invalid product number.");
//             return;
//         }

//         Product product = products.get(index - 1);

//         //boolean recycled = recyclingGuidanceService.recycleProduct(product);

//         if (recycled) {
//             //System.out.println(product.getName() + " was recycled successfully.");
//         } else {
//             System.out.println("Could not recycle " + product.getName() + ".");
//         }
//     }

//     private void printProducts(List<Product> products) {
//         System.out.println("\nProducts:");
//         for (int i = 0; i < products.size(); i++) {
//             //System.out.println((i + 1) + ". " + products.get(i).getName());
//         }
//     }

//     private int readInt() {
//         try {
//             int value = Integer.parseInt(scanner.nextLine());
//             return value;
//         } catch (NumberFormatException e) {
//             return -1;
//         }
//     }
// }
}
