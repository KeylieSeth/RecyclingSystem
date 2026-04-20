package presentation;

import java.util.Scanner;
import application.MaterialService;

public class MaterialMenu {
    private MaterialService materialService;
    private Scanner scanner;
    
    public MaterialMenu(MaterialService materialService, Scanner scanner){
        this.materialService = materialService;
        this.scanner = scanner;
    }

    public void print(){
        System.out.println("1. Add material\n" + 
                        "2. Delete material\n" + 
                        "3. List all materials\n" + 
                        "4. Environment impact\n" + 
                        "0. Back to main menu");
    }

    public void run(){
        while (true) {
            print();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter material: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter material impact: ");
                    double impact = scanner.nextInt();
                    scanner.nextLine();
                    // materialService.defineMaterial(name, impact);
                    System.out.println("Material added");
                    break;

                case 2:
                    System.out.println("Enter material name to delete :");
                    name = scanner.nextLine();
                    // materialService.deleteMaterial(name);
                    break;

                case 3:
                    // materialService.listMatterials();

                case 4:
                    System.out.println("Enter material name: ");
                    name = scanner.nextLine();
                    // productService.calculateImpact(name, null);

                case 0:
                    return;
            
                default:
                    break;
                }
            }
        }
    }   