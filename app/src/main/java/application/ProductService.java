package application;

import java.util.ArrayList;
import java.util.List;

import domain.ImpactCalculationStrategy;
import domain.Material;
import domain.Product;
import domain.ProductMaterialRelation;
import domain.Repository;
import domain.Repository;

public class ProductService {
    private Repository productRepo;
    private MaterialService materialService;
    private List<Product> products = new ArrayList<>();
    private int currentProductindex = 0;
    private ImpactCalculationStrategy simpleStrategy;
    private ImpactCalculationStrategy lifespanStrategy;

    public ProductService(Repository productRepo, MaterialService materialService, ImpactCalculationStrategy simpleStrategy, ImpactCalculationStrategy lifespanStrategy ) {
        this.productRepo = productRepo;
        this.materialService = materialService;
        this.simpleStrategy = simpleStrategy;
        this.lifespanStrategy = lifespanStrategy;
    }

    public void addProduct(String name, String category, int lifespan) {
        Product product = new Product(name, category, lifespan);
        giveIndex(product);
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

    public List<Product> findAllMatchingNames(String name){
        List<Product> matchingProducts = new ArrayList<>();
        for (Product p: products) {
            if(p.getName().equalsIgnoreCase(name)){
                matchingProducts.add(p);
            }
        }
        return matchingProducts;
    }

    //Method to add a material to a product.
    public void addMaterialToProduct(Product product, ProductMaterialRelation material){
        product.addMaterial(material);
    }

    public void giveIndex(Product product) {
        product.setId(currentProductindex);
        currentProductindex++;
    }

    public double calculateSimpleSum (Product product) {
        return simpleStrategy.calculate(product);
    }

    public double calculateLifespanAdjusted (Product product){
        return lifespanStrategy.calculate(product);
    }
    
}