package presentation;

import java.util.Scanner;
import application.ProductService;

public class ProductMenu {
    private ProductService productService;
    private Scanner scanner;
    
    public ProductMenu(ProductService ps, Scanner scanner){
        this.productService = ps;
        this.scanner = scanner;
    }
}
