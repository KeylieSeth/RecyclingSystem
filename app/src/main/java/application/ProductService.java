package application;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class ProductService {
    public ProductService(ProductRepository productRepo, MaterialService materialService) {

    }

    //Mock code for testing.
    public List<Product> listProducts() {
    List<Product> products = new ArrayList<>();

    products.add(new Product("Hammer"));
    products.add(new Product("Doll"));

    return products;
    }

    public double calculateImpact(String productName) {
    return 1.0; // placeholder just nu
    }
    

}
