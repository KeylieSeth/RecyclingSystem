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

    private int currentProductindex = 0;

    public ProductService(ProductRepository productRepo, MaterialService materialService) {
        this.productRepo = productRepo;
        this.materialService = materialService;
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
    public void addMaterialToProduct(Product product, String materialName){
    
        Material material = materialService.findByName(materialName);
        product.addMaterial(material);
    }

    public void giveIndex(Product product) {
        product.setId(currentProductindex);
        currentProductindex++;
    }
}