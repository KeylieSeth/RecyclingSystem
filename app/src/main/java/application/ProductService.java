package application;

import java.util.List;
import java.util.Optional;

import domain.ImpactCalculationStrategy;
import domain.Material;
import domain.Product;
import domain.ProductMaterialRelation;
import domain.Repository;

public class ProductService {
    private Repository productRepo;
    
    private int currentProductindex = 0;
    private ImpactCalculationStrategy simpleStrategy;
    private ImpactCalculationStrategy lifespanStrategy;
    private ImpactCalculationStrategy recyclabilityStrategy;

    public ProductService(Repository productRepo, ImpactCalculationStrategy simpleStrategy, 
        ImpactCalculationStrategy lifespanStrategy, ImpactCalculationStrategy recyclabilityStrategy ) {
        this.productRepo = productRepo;
        this.simpleStrategy = simpleStrategy;
        this.lifespanStrategy = lifespanStrategy;
        this.recyclabilityStrategy = recyclabilityStrategy;
    }

    public Product addProduct(String name, double estimatedLifespan) {
        Product product = new Product(name, estimatedLifespan);
        productRepo.getAllProducts().add(product);
        giveIndex(product);
        return product;
    }

    public boolean deleteProduct(Product product){
        return productRepo.getAllProducts().remove(product);
    }

    public List<Product> listProducts() {
        return productRepo.getAllProducts();
    }

    public Product findByName(String name) {
        for (Product p : productRepo.getAllProducts()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public Optional<Product> findProductByName(String name){
        for (Product p : productRepo.getAllProducts()) {
            if (p.getName().equalsIgnoreCase(name)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void setProducts(List<Product> products) {
        productRepo.setAllProducts(products);
    }

    public void addMaterialToProduct(Product product, Material material, double mass) {
        ProductMaterialRelation relation = new ProductMaterialRelation(material, mass);
        product.addMaterial(relation);
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

    public double calculateRecyclability(Product product){
        return recyclabilityStrategy.calculate(product);
    }

    public double getTotalMass(Product product) {
        return product.calculateTotalMass();
    }
    
}