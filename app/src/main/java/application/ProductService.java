package application;

import java.util.ArrayList;
import java.util.List;

import domain.Material;
import domain.Product;
import domain.ProductRepository;

public class ProductService {

    private ProductRepository productRepo;
    private MaterialService materialService;

    private List<Product> products = new ArrayList<>();

    public ProductService(ProductRepository productRepo, MaterialService materialService) {
        this.productRepo = productRepo;
        this.materialService = materialService;
    }

    public void addProduct(String name, String category, int lifespan) {
        Product product = new Product(name, category, lifespan, new ArrayList<Material>());
        products.add(product);
    }

    public boolean deleteProduct(String name) {
        return products.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> listProducts() {
        return products;
    }

    public Product findByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public double calculateImpact(String name) {
        Product product = findByName(name);
        if (product == null) {
            return 0.0;
        }
        return 1.0; // MOCK THING
    }
}