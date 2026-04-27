package application;

import domain.ImpactCalculationStrategy;
import domain.Material;
import domain.Product;
import domain.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService {
    private final ProductRepository productRepository;
    private final MaterialService materialService;

    public ProductService(ProductRepository productRepository, MaterialService materialService) {
        this.productRepository = productRepository;
        this.materialService = materialService;
    }

    public Product createProduct(String name, String category, int estimatedLifespan, List<String> materialNames) {
        List<Material> materials = new ArrayList<>();

        for (String materialName : materialNames) {
            Material material = materialService.findByName(materialName);
            if (material != null) {
                materials.add(material);
            }
        }

        Product product = new Product(UUID.randomUUID(), name, category, estimatedLifespan, materials);
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return product.orElse(null);
    }

    public boolean deleteProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);

        if (product.isEmpty()) {
            return false;
        }

        return productRepository.deleteById(product.get().getId());
    }

    public double calculateImpactByName(String name, ImpactCalculationStrategy strategy) {
        Optional<Product> product = productRepository.findByName(name);

        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found.");
        }

        return strategy.calculateImpact(product.get());
    }
}