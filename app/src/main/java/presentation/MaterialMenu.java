package presentation;

import java.util.Scanner;
import application.MaterialService;
import application.ProductService;
import domain.ImpactCalculationStrategy;
import domain.Material;
import domain.SimpleSumStrategy;
import domain.SingleMaterialImpactCalculation;
import domain.RecyclingCategory;

public class MaterialMenu {
    private MaterialService materialService;
    private Scanner scanner;
    private ProductService productService;
    
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
                        System.out.print("Enter material: ");
                        String name = scanner.nextLine().toLowerCase();
                        
                        // eF - Emmission Factor
                        System.out.print("Enter material's emmision factor: ");
                        double eF = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Enter recycling category (PLASTIC, METAL, CERAMIC, ORGANIC, GLASS, PAPER, TEXTILE, MIXED): ");
                        String categoryInput = scanner.nextLine().toUpperCase();
                        RecyclingCategory category = RecyclingCategory.valueOf(categoryInput);

                        materialService.defineMaterial(name, eF, category);

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

                    
                // Carbon Contribution (per material)
                case "4":
                    try {
                    System.out.print("Enter material name: ");
                    String name = scanner.nextLine();
                    
                    Material material = materialService.findByName(name);

                    if (material != null){
                        System.out.print("Enter mass: ");
                        double mass = scanner.nextDouble(); 
                        scanner.nextLine();

                        double result = SingleMaterialImpactCalculation.calculateMaterialImpact(mass, material);

                        if (result != 0) {
                            System.out.println("carbon contribution of material: " + result);
                        }
                    }

                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
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
