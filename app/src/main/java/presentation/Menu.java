package presentation;

import java.util.Scanner;
import application.*;
import infrastructure.FileHandler;

public class Menu {
    private ProductService productService;
    private MaterialService materialService;
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
                    System.out.print(result);

                    System.out.print("Save report to file? (y/n): ");
                    String answer = scanner.nextLine();
                    if (answer.trim().equalsIgnoreCase("y")) {
                        try {
                            System.out.print("Enter filename: ");
                            String fileName = scanner.nextLine();

                            fileHandler.saveReport(result, fileName);
                            System.out.print("Report has been saved.");  
                        } catch (Exception e) {
                        System.out.print("Error saving report.");
                        e.printStackTrace();
                        }
                    }
                    break;

                case "5":
                    try {
                        System.out.print("Enter filename: ");
                        String fileName = scanner.nextLine();

                        productService.setProducts(
                            fileHandler.loadProducts(fileName)
                        );

                        materialService.setMaterials(
                            fileHandler.loadMaterials(fileName)
                        );

                        System.out.println("Loaded from file.");

                    } catch (Exception e) {
                        System.out.println("Error loading file.");
                        e.printStackTrace();
                    }
                    break;

                case "6":
                    try {
                        System.out.print("Enter filename: ");
                        String fileName = scanner.nextLine();

                        fileHandler.save(
                            productService.listProducts(),
                            materialService.getAllMaterials(),
                            fileName
                        );

                        System.out.println("Saved to file.");

                    } catch (Exception e) {
                        System.out.println("Error saving file.");
                        e.printStackTrace();
                    }
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
                   Handle recycling processes. View recycling guidelines and update product recycling info.

                4) Generate Report
                   Create a report summarizing products with their materials, and their environmental impact.""";

        System.out.println(infoText);

        System.out.print("\nPress Enter to go back to menu. ");

        if (scanner.nextLine() == ""){
            return;
        }
    }
}
