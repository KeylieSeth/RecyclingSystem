package presentation;

import java.util.Scanner;
import application.MaterialService;
import application.ProductService;
import domain.RecyclingCategory;

public class MaterialMenu {
    private MaterialService materialService;
    private Scanner scanner;
    
    public MaterialMenu(MaterialService materialService, Scanner scanner){
        this.materialService = materialService;
        this.scanner = scanner;
    }
 
    // run menu
    public void run(){
        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                // Add material
                case "1":
                    System.out.println("\n======= Add Material =======");
                    try{
                        System.out.print("Enter material name: ");
                        String name = scanner.nextLine();
                    
                        System.out.print("Enter material impact: ");
                        double impact = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Enter recycling category (PLASTIC, METAL, CERAMIC, NATURAL, MIXED): ");
                        String categoryInput = scanner.nextLine().toUpperCase();
                        RecyclingCategory category = RecyclingCategory.valueOf(categoryInput);

                        materialService.defineMaterial(name, impact, category);

                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                        break;


                // Delete material
                case "2":
                    System.out.println("\n====== Delete Material ======");
                    try {
                    System.out.print("Enter material name to delete: ");
                    String name = scanner.nextLine();
                    materialService.deleteMaterial(name);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                    

                // List all materials
                case "3":
                    System.out.println("\n======= Material List =======");
                    System.out.println(materialService.listMaterials());
                    break;

                // Calculate 
                case "4":
                    System.out.println("\n=== Environmental Impact ===");
                   // System.out.println("Enter material name: ");
                   // name = scanner.nextLine();
                   // ProductService.calculateImpact(name);
                   break;

                // Back to menu
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

                ======= Material Menu =======
                -----------------------------
                1) Add material       
                2) Delete material    
                3) Material list                
                4) Show enviromental impact            
                0) Back to main menu 
                -----------------------------""";

        System.out.println(menuText);
    }
}