package presentation;

import java.util.Scanner;

import application.*;
import domain.Repository;
import infrastructure.*;
import domain.ImpactCalculationStrategy;
import domain.LifespanAdjustedStrategy;
import domain.RecyclabilityScoreCalculationStrategy;
import domain.SimpleSumStrategy;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //infratructure
        Repository repo = new InMemoryRepository();
        FileHandler fileHandler = new FileHandler();

        //application
        ImpactCalculationStrategy simpleStrategy = new SimpleSumStrategy();
        ImpactCalculationStrategy lifespanStrategy = new LifespanAdjustedStrategy(simpleStrategy);
        ImpactCalculationStrategy recyclabilityStrategy = new RecyclabilityScoreCalculationStrategy();
        MaterialService materialService = new MaterialService(repo);
        ProductService productService = new ProductService(repo, simpleStrategy, lifespanStrategy, recyclabilityStrategy);
        RecyclingGuidanceService recyclingGuidanceService = new RecyclingGuidanceService(productService, materialService);

        //presentation
        ProductMenu productMenu = new ProductMenu(productService, materialService, scanner);
        MaterialMenu materialMenu = new MaterialMenu(materialService, scanner);
        RecyclingMenu recyclingMenu = new RecyclingMenu(productService, recyclingGuidanceService, scanner);

        Menu menu = new Menu(repo, productService, productMenu, materialMenu, recyclingMenu, fileHandler, scanner);
        menu.runMenu();
        scanner.close();
    }
}
