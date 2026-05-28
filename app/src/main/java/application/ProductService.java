package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import domain.Material;
import domain.Product;
import domain.Repository;

public class ProductService {

    private Repository repo;
    private MaterialService materialService;

    //private List<Product> products = new ArrayList<>();

    public ProductService(Repository repo, MaterialService materialService) {
        this.repo = repo;
        this.materialService = materialService;
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

    public double calculateImpact(String name) {
        Product product = findByName(name);
        if (product == null) {
            return 0.0;
        }
        return 1.0; // MOCK THING (Whole method)
    }

    //Method to add a material to a product.
    public void addMaterialToProduct(Product product, String materialName){
    
        Material material = materialService.findByName(materialName);
        product.addMaterial(material);
    }
}