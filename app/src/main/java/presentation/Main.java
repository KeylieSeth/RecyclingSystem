package presentation;

import java.util.Scanner;

import application.*;
import domain.Repository;
import infrastructure.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //infratructure
        Repository productRepo = new InMemoryRepository();
        FileHandler fileHandler = new FileHandler();

        //application
        MaterialService materialService = new MaterialService();
        ProductService productService = new ProductService(productRepo, materialService);
        RecyclingGuidanceService recyclingGuidanceService = new RecyclingGuidanceService(productService, materialService);

        //presentation
        ProductMenu productMenu = new ProductMenu(productService, materialService, scanner);
        MaterialMenu materialMenu = new MaterialMenu(materialService, scanner);
        RecyclingMenu recyclingMenu = new RecyclingMenu(productService, recyclingGuidanceService, scanner);
        
        Menu menu = new Menu(productService, materialService, productMenu, materialMenu, recyclingMenu, fileHandler, scanner);
        menu.runMenu();
        scanner.close();
    }
}
