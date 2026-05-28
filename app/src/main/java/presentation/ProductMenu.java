package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

import application.MaterialService;
import application.ProductService;
import domain.Material;
import domain.Product;
import domain.ProductMaterialRelation;

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
            System.out.println();
            System.out.println("Product Menu");
            System.out.println("1) Add product");
            System.out.println("2) Delete product");
            System.out.println("3) List products");
            System.out.println("4) Add material to product");
            System.out.println("5) Total Material Impacact for specific product");
            System.out.println("6) Lifespan Adjusted annual impact");
            System.out.println("0) Back to main menu" + "\n");

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
                    Optional<Product> product = getSelectedProduct("Select the number of the product to add material to: ");
                    if (product.isPresent()) {
                        Product p = product.get();
                    
                        Material material = getSelectedMaterial();
                        
                        if (material != null){
                            double mass = getMass();
                            ProductMaterialRelation productMaterial = new ProductMaterialRelation(material, mass);
                            productService.addMaterialToProduct(p, productMaterial);
                        }
                    }
                    break;
                case "5":
                    SimpleSumImpactCalc();
                    break;
                case "6":
                    LifespanAdjustedCalc();
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
                4) Show enviromental impact            
                0) Back to main menu 
                ----------------------------""";

        System.out.println(menuText);
    }

    public String readChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    private void addProduct() {
        System.out.println("Add product");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter estimated lifespan (years): ");
        int lifespan = scanner.nextInt();
        scanner.nextLine();

        productService.addProduct(name, category, lifespan);
        System.out.println("Product has been added.");
    }


    private void deleteProduct() {
        System.out.println("Delete product");
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();

        productService.deleteProduct(name);
        System.out.println("Product deleted.");
    }


    private void listProducts() {
        System.out.println("List of all products:");

        //Print all products (one per row), in numbered order for user selection.
        for (int i = 0; i < productService.getAllProducts().size(); i++) {
            System.out.println((i+1) + ". " + productService.getAllProducts().get(i).getName());
        }

        System.out.println("\n======= Add Product =======");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        if (name.isBlank()){
            System.out.println("Product name not valid.");
            return;
        }
            
        Product product = productService.addProduct(name);

            while (true) {
                String materialName = getSelectedMaterial();

                if (productMaterials.contains(materialName)){
                    System.out.println(name + " already has " + materialName + ".");
                    System.out.println("Please choose another material.");
                }

                else if (materialName != null) {
                    productMaterials.add(materialName);
                    productService.addMaterialToProduct(product, materialName);
                    System.out.println(materialName + " added to product.");
                }

                System.out.print("Add another material to product? (y/n): ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("n") && productMaterials.isEmpty()){
                    System.out.println("A product must have atleast one material.");
                    continue;
                }

                if (answer.equalsIgnoreCase("n")) {
                    break;
                }
        }
        System.out.println(name + " added.");
    }


    private void listMaterials(){
        System.out.println("\n==== Material List: ====");

        //Print all products (one per row), in numbered order for user selection.
        for (int i = 0; i < materialService.getAllMaterials().size(); i++) {
            System.out.println((i+1) + ". " + materialService.getAllMaterials().get(i).getName());
        }
    }


    private void SimpleSumImpactCalc() {
        System.out.println("Total material impact for product");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        Product product = productService.findByName(name);

        if (product == null){
            System.out.println("Product not found");
            return;
        }

        double result = productService.calculateSimpleSum(product);
        System.out.println("Environmental impact for product " + result);
    }

    private void LifespanAdjustedCalc(){
        System.out.println("Lifespan Adjusted calculation");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        Product product = productService.findByName(name);

        if (product == null){
            System.out.println("Product not found");
            return;
        }

        double result = productService.calculateLifespanAdjusted(product);
        System.out.println("Lifespan Adjusted annual impact " + result);
    }


    //Choose product from list to add material to.
    private Optional<Product> getSelectedProduct(String prompt){
        //temporary list when method is called to hold all registered products.
        List<Product> products = productService.listProducts();

        if (!products.isEmpty()){
            listProducts();
            System.out.print(prompt);

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
    private Material getSelectedMaterial(){
        //temporary list when method is called to hold all registered materials.
        List<Material> materials = materialService.getAllMaterials();

        if(!materials.isEmpty()){
            listMaterials();
            System.out.print("Select the number of the material to add: ");

            try {
                int materialChoice = Integer.parseInt(scanner.nextLine());

                if (materialChoice < 1 || materialChoice > materials.size()){
                    System.out.println("Invalid material number.");
                    return null;
                }

                Material selectedMaterial = materials.get(materialChoice-1);
                return selectedMaterial;


            } catch(NumberFormatException e) {
                System.out.println("please enter a valid number.");
                return null;
            } 
        } else {
            System.out.println("There are no registered materials.");
            return null;
        }
    }

    private double getMass() {
        System.out.println("Enter the mass of the selected material in that product");
        double mass = scanner.nextDouble();
        scanner.nextLine();
        return mass;
    }
}
