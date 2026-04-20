package presentation;

import java.util.Scanner;

import application.MaterialService;
import application.ProductService;
import application.RecyclingGuidanceService;

public class RecyclingMenu {
    private ProductService productService;
    private Scanner scanner;

    public RecyclingMenu(ProductService ps, Scanner scanner){
        this.productService = ps;
        this.scanner = scanner;
    }
}
