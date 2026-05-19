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

    // print menu
    public void print(){
        System.out.println();
        System.out.println("1. Add material\n" + 
                        "2. Delete material\n" + 
                        "3. List all materials\n" + 
                        "4. Environment impact\n" + 
                        "0. Back to main menu");
        System.out.println();
    }
  
    
    // run menu
    public void run(){
        while (true) {
            print();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();
            print();

            switch (choice) {
                // Add material
                case "1":
                    try{
                        System.out.print("Enter material: ");
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
                    try {
                    System.out.print("Enter material name to delete :");
                    String name = scanner.nextLine();
                    materialService.deleteMaterial(name);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                    

                // List all materials
                case "3":
                    System.out.println(materialService.listMaterials());
                    break;

                // Calculate 
                // case 4:
                   // System.out.println("Enter material name: ");
                   // name = scanner.nextLine();
                   // ProductService.calculateImpact(name);

                // Back to menu
                case "0":
                    return;
            
                default:
                    break;
            }
        }
    }
}