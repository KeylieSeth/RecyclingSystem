package presentation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

import application.MaterialService;
import application.ProductService;
import domain.Material;
import domain.Product;

public class ProductMenu {
    private Scanner scanner;
    private ProductService productService;
    private MaterialService materialService;

    public ProductMenu(ProductService productService, MaterialService materialService, Scanner scanner) {
        this.scanner = scanner;
        this.productService = productService;   
        this.materialService = materialService;    
    }


    public void run() {
        while (true) {
            printMenu();

            String choice = readChoice();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    System.out.println("\n====== Delete Product ======");
                    Optional<Product> product = getSelectedProduct();

                    if (product.isPresent()) {
                        Product p = product.get();

                        boolean removed = productService.deleteProduct(p);

                        if (removed) {
                            System.out.println("Product has been deleted.");
                        } else {
                            System.out.println("Could not delete product.");
                        }
                    }
                    break;
                    
                case "3":
                    System.out.println("\n======= Product List =======");
                    listProducts();
                    break;
                case "4":
                    SimpleSumImpactCalc();
                    break;
                case "5":
                    LifespanAdjustedCalc();
                    break;
                case "0":
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println(choice + " is not a valid input.");
                    break;
            }
        }
    }

    public void printMenu() {
        String menuText = """

                ======= Product Menu =======
                ----------------------------
                1) Add product       
                2) Delete product    
                3) Product list            
                4) Total Material Impact 
                   for specific product
                5) Lifespan Adjusted 
                   annual impact          
                0) Back to main menu 
                ----------------------------""";

        System.out.println(menuText);
    }

    public String readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    private void addProduct() {
        List<Material> productMaterials = new ArrayList<>();
        double estimatedLifespan;

        if (materialService.getAllMaterials().isEmpty()){
            System.out.println("No registered materials found.");
            System.out.println("Please add materials before creating a product.");
            return;
        }

        System.out.println("\n======= Add Product =======");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        if (name.isBlank()){
            System.out.println("Product name not valid.");
            return;
        }

        System.out.print("Enter expected lifespan of the product: ");

        String lifespanInput = scanner.nextLine();

        if (lifespanInput.isBlank()) {
            System.out.println("No input, returning to menu.");
            return;
        }

        try {

            estimatedLifespan = Double.parseDouble(lifespanInput);

            if (estimatedLifespan <= 0) {
                System.out.println("Lifespan must be greater than 0.");
                return;
            }

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");
            return;
        }
            
        Product product = productService.addProduct(name, estimatedLifespan);

            while (true) {
                Optional<Material> materialOptional = getSelectedMaterial();

                if (materialOptional.isPresent()) {
                    Material material = materialOptional.get();

                    if (productMaterials.contains(material)) {
                        System.out.println(name + " already has " + material.getName() + ".");
                        System.out.println("Please choose another material.");
                    } else {
                        productMaterials.add(material);

                        System.out.print("Enter mass of material in kg: ");

                        String massInput = scanner.nextLine();

                        if (massInput.isBlank()) {
                            System.out.println("Returning to menu.");
                            break;
                        }

                        try {

                            double mass = Double.parseDouble(massInput);

                            if (mass <= 0) {
                                System.out.println("Mass must be greater than 0.");
                                continue;
                            }

                            productService.addMaterialToProduct(product, material, mass);

                            System.out.println(material.getName() + " added to product.");

                        } catch (NumberFormatException e) {

                            System.out.println("Please enter a valid number.");
                        }
                    }
                }

                System.out.print("Add another material to product? (y/n): ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("n") && productMaterials.isEmpty()){
                    System.out.println("A product must have at least one material.");
                    continue;
                }

                if (answer.equalsIgnoreCase("n")) {
                    break;
                }

                System.out.println(name + " added.");
        }
        
    }

    private void listProducts() {
        //Print all products (one per row), in numbered order for user selection.
        for (int i = 0; i < productService.listProducts().size(); i++) {
            System.out.println((i+1) + ". " + productService.listProducts().get(i).getName());
        }
    }

    private void listMaterials(){
        System.out.println("\n==== Material List: ====");

        //Print all products (one per row), in numbered order for user selection.
        for (int i = 0; i < materialService.getAllMaterials().size(); i++) {
            System.out.printf("%-3s %s%n", (i + 1) + ".", materialService.getAllMaterials().get(i).getName());
        }
    }


    private void SimpleSumImpactCalc() {
        System.out.println("\n=== Environmental Impact ===");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        Product product = productService.findByName(name);

        if (product == null){
            System.out.println("Product not found");
            return;
        }

        double result = productService.calculateSimpleSum(product);
        System.out.println("Environmental impact: " + result);
    }

    private void LifespanAdjustedCalc(){
        System.out.println("==== Adjusted lifeSpan ====");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        Product product = productService.findByName(name);

        if (product == null){
            System.out.println("Product not found");
            return;
        }

        double result = productService.calculateLifespanAdjusted(product);
        System.out.printf("Lifespan Adjusted annual impact %.2f%n", result);
    }


    //Choose product from list to add material to.
    private Optional<Product> getSelectedProduct(){
        //temporary list when method is called to hold all registered products.
        List<Product> products = productService.listProducts();

        if (!products.isEmpty()){
            listProducts();
            System.out.print("Select the number of the product: ");

            try {    
                int productChoice = Integer.parseInt(scanner.nextLine());

                if (productChoice < 1 || productChoice > products.size()){
                    System.out.println("Invalid product number.");
                    return Optional.empty();
                }
                String selectedProductName = products.get(productChoice-1).getName();
                System.out.println("Selected product is: " + selectedProductName);

                Product selectedProduct = products.get(productChoice-1);
                return Optional.of(selectedProduct);

            } catch(NumberFormatException e){
                System.out.println("please enter a valid number.");
                return Optional.empty();
            }
        } else {
            System.out.println("No products in list.");
            return Optional.empty();
        }
    }

     //Choose material from list to add to a product.
    private Optional<Material> getSelectedMaterial(){
        //temporary list when method is called to hold all registered materials.
        List<Material> materials = materialService.getAllMaterials();

        listMaterials();
        System.out.print("Select the number of the material to add: ");

        try {
            int materialChoice = Integer.parseInt(scanner.nextLine());

            if (materialChoice < 1 || materialChoice > materials.size()){
                System.out.println("Invalid material number.");
                return Optional.empty();
            }

            Material selectedMaterial = materials.get(materialChoice-1);
            return Optional.of(selectedMaterial);

        } catch(NumberFormatException e) {
            System.out.println("please enter a valid number.");
            return Optional.empty();
        } 
    }
}
