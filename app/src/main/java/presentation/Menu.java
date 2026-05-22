package presentation;

import java.util.Scanner;

import application.*;
import infrastructure.FileHandler;

public class Menu {
    private ProductService productService;
    private ProductMenu productMenu;
    private MaterialMenu materialMenu;
    private RecyclingMenu recyclingMenu;
    private FileHandler fileHandler;
    private Scanner scanner;

    public Menu(ProductService productService, ProductMenu productMenu, MaterialMenu materialMenu, RecyclingMenu recyclingMenu, FileHandler fileHandler, Scanner scanner){
        this.productService = productService;
        this.productMenu = productMenu;
        this.materialMenu = materialMenu;
        this.recyclingMenu = recyclingMenu;
        this.fileHandler = fileHandler;
        this.scanner = scanner;
    }

    public void runMenu() {
        boolean keepRunning = true;
        while(keepRunning) {
            printMenu();

            String choice = readChoice();

            switch(choice.toLowerCase()) {
                case "1":
                    materialMenu.run();
                    break;

                case "2":
                    productMenu.run();
                    break;

                case "3":
                    recyclingMenu.run();
                    break;

                case "4":
                    Report report = new Report(productService);
                    ReportFormatter reportFormatter = new ReportFormatter();
                    
                    String result = reportFormatter.format(report);
                    System.out.println(result);

                    System.out.println("Save report to file? (y/n)");
                    String answer = readChoice();
                    if (answer.trim().equalsIgnoreCase("y")) {
                        // fileHandler.saveReport(result);
                        System.out.println("Report has been saved.");
                    }
                    break;

                case "5":
                    //fileHandler.load(productService, materialService);
                    System.out.println("Loaded from file..");
                    break;

                case "6":
                    //fileHandler.save(productService, materialService);
                    System.out.println("Saved to file..");
                    break;

                case "i":
                    displayInformation();
                    break;

                case "q":
                    keepRunning = false;
                    break;

                default:
                    System.out.println(choice + " is not a valid input.");
                    break;
            }
        }
    }

    public void printMenu() {
        String menuText = """

                ======= Main Menu =======
                -------------------------
                1) Material Menu
                2) Product Menu
                3) Recycling Menu
                4) Generate Report
                5) Load from file
                6) Save to file
                i) Help
                q) Exit
                -------------------------""";

        System.out.println(menuText);
    }

    public String readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    
    public void displayInformation() {
        String infoText = """

                1) Material Menu
                   Manage materials used in products. Add, remove, list materials, and analyze their environmental impact.

                2) Product Menu
                   Manage products in the system. Add, remove, list products and view their environmental impact.

                3) Recycling Menu
                   Handle recycling processes. View recycling guidelines, update product recycling info, and register recycled products.

                4) Generate Report
                   Create reports summarizing products, materials, and their environmental impact.""";

        System.out.println(infoText);

        System.out.print("\nPress Enter to go back to menu. ");

        if (scanner.nextLine() == ""){
            return;
        }
    }
}
