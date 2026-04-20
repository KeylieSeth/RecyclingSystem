package presentation;

import java.util.Scanner;

import application.*;
import infrastructure.FileHandler;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    
    private ProductService productService;
    private MaterialService materialService;
    private FileHandler fileHandler;
    
    private ProductMenu productMenu;
    private MaterialMenu materialMenu;
    private RecyclingMenu recyclingMenu;

    public Menu(ProductService productService, MaterialService materialService, FileHandler fileHandler) {
        this.productService = productService;
        this.materialService = materialService;
        this.fileHandler = fileHandler;

        this.productMenu = new ProductMenu(productService, scanner);
        this.materialMenu = new MaterialMenu(materialService, scanner);
        this.recyclingMenu = new RecyclingMenu(productService, scanner);
    }

    public void runMenu() {
        printMenu();
        boolean keepRunning = true;

        do {
            String choice = readChoice();

            switch(choice.toLowerCase()) {
                case "1":
                    productMenu.run();
                    printMenu();
                    break;
                case "2":
                    materialMenu.run();
                    printMenu();
                    break;
                case "3":
                    // recyclingMenu.run();
                    System.out.println("Recycling menu will be here");
                    break;
                case "4":
                    // GenerateReport report = new GenerateReport(productService);
                    // String result = report.generate();
                    // System.out.println(result);

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
                case "m":
                    printMenu();
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
        } while (keepRunning);
    }

    public void printMenu() {
        String menuText = """
                 -----------------
                | 1) Product Menu
                | 2) Material Menu
                | 3) Recycling Menu
                | 4) Generate Report
                | 5) Load from file
                | 6) Save to file
                | m) Print Menu
                | i) Help
                | q) Exit
                -----------------""";
        System.out.println(menuText);
    }

    public String readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    public void displayInformation() {
        String infoText = """
                1) Product Menu
                   Manage products in the system. Add, remove, list products, and view their environmental impact.

                2) Material Menu
                   Manage materials used in products. Add, remove, list materials, and analyze their environmental impact.

                3) Recycling Menu
                   Handle recycling processes. View recycling guidelines, update product recycling info, and register recycled products.

                4) Generate Report
                   Create reports summarizing products, materials, and their environmental impact.""";
        System.out.println(infoText);
    }
}
