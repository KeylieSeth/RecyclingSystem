package presentation;

import java.util.Scanner;

import application.ProductService;
import application.RecyclingGuidanceService;

public class RecyclingMenu {
    private ProductService productService;
    private RecyclingGuidanceService recyclingGuidanceService;
    private Scanner scanner;

    public RecyclingMenu(ProductService productService, RecyclingGuidanceService recyclingGuidanceService, Scanner scanner){
        this.productService = productService;
        this.recyclingGuidanceService = recyclingGuidanceService;
        this.scanner = scanner;
    }
}
