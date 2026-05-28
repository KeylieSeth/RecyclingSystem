package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Product addProduct(String name) {
        Product product = new Product(name);
        repo.getAllProducts().add(product);
        return product;
    }

    public boolean deleteProduct(Product product){
        return repo.getAllProducts().remove(product);
    }

    public List<Product> listProducts() {
        return repo.getAllProducts();
    }

    public Product findByName(String name) {
        for (Product p : repo.getAllProducts()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public Optional<Product> findProductByName(String name){
        for (Product p : repo.getAllProducts()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void setProducts(List<Product> products) {
        repo.setAllProducts(products);
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