package application;

import domain.Material;
import domain.Product;
import domain.ProductRepository;
import domain.RecyclingCategory;
import java.util.List;
import java.util.Optional;

public class RecyclingGuidanceService {
    private final ProductRepository productRepository;

    public RecyclingGuidanceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String recyclingGuidance(String productName) {
        Product product = findByName(productName);

        if (product == null) {
            return "Product not found.";
        }

        return getGuidance(product);
    }

    public String getGuidance(Product product) {
        if (product == null) {
            return "Produt not found.";
        }

        List<Material> materials = product.getMaterials();

        if (materials.isEmpty()) {
            return "No materials registered for this product.";
        }

        if (materials.size() > 1) {
            return "Mixed-material product. Separate materials before recycling if possible.";
        }

        Material material = materials.get(0);
        RecyclingCategory category = material.getRecyclingCategory();

        return "Recycle as: " + category;
    }

    public void updateGuidance(Product product, String newGuidance) {
        // Implement custom guidance update later
    }

    public boolean recycleProduct(Product product) {
        if (product == null) {
            return false;
        }

        product.setRecycled(true);
        return true;
    }

    private Product findByName(String productName) {
        for (Product product : productRepository.findAll()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}