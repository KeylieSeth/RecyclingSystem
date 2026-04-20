package presentation;

import application.*;
import domain.ProductRepository;
import infrastructure.*;

public class Main {
    public static void main(String[] args) {
        //infratructure
        ProductRepository productRepo = new InMemoryProductRepository();
        FileHandler fileHandler = new FileHandler();

        //application
        MaterialService materialService = new MaterialService();
        ProductService productService = new ProductService(productRepo, materialService);

        //presentation
        Menu menu = new Menu(productService, materialService, fileHandler);
        menu.runMenu();
    }
}
