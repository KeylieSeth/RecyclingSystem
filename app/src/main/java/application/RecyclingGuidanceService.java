package application;

import domain.Material;
import domain.Product;
<<<<<<< Updated upstream
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
=======
import domain.RecyclingCategory;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class RecyclingGuidanceService {
    private final ProductService productService;
    private final MaterialService materialService;
    private final Map<String, String> customGuidanceByProductName;

    public RecyclingGuidanceService(ProductService productService, MaterialService materialService) {
        this.productService = productService;
        this.materialService = materialService;
        this.customGuidanceByProductName = new HashMap<>();
    }

    public String getGuidance(Product product) {
        if (product == null) {
            return "Product not found.";
        }

        if (customGuidanceByProductName.containsKey(product.getName())) { // NEW
            return customGuidanceByProductName.get(product.getName());
        }

        List<Material> materials = product.getMaterials();

        if (materials == null || materials.isEmpty()) {
            return "No materials registered for this product.";
        }

        if (materials.size() > 1) {
            return "Mixed-material product. Separate materials before recycling if possible.";
        }

        return getGuidanceForMaterial(materials.get(0));
    }

    public String getGuidanceByProductName(String productName) {
        Product product = productService.findByName(productName);
>>>>>>> Stashed changes

        if (product == null) {
            return "Product not found.";
        }

        return getGuidance(product);
    }

<<<<<<< Updated upstream
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
=======
    public String getGuidanceByMaterialName(String materialName) {
        Material material = materialService.findByName(materialName);
        return getGuidanceForMaterial(material);
    }

    private String getGuidanceForMaterial(Material material) {
        if (material == null) {
            return "Material not found.";
        }

        RecyclingCategory category = material.getRecyclingCategory();

        if (category == RecyclingCategory.PLASTIC) {
            return "Recycle as plastic.";
        } else if (category == RecyclingCategory.METAL) {
            return "Recycle as metal.";
        } else if (category == RecyclingCategory.CERAMIC) {
            return "Handle as ceramic or general waste depending on local rules.";
        } else if (category == RecyclingCategory.NATURAL) {
            return "Recycle as natural material or compost if applicable.";
        } else if (category == RecyclingCategory.MIXED) {
            return "Mixed material: separate the parts before recycling if possible.";
        }

        return "No recycling guidance available.";
    }

    public void updateGuidance(Product product, String newGuidance) {
        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }

        customGuidanceByProductName.put(product.getName(), newGuidance.trim());
>>>>>>> Stashed changes
    }

    public boolean recycleProduct(Product product) {
        if (product == null) {
            return false;
        }

<<<<<<< Updated upstream
=======
        if (product.isRecycled()) {
            return false;
        }

>>>>>>> Stashed changes
        product.setRecycled(true);
        return true;
    }

<<<<<<< Updated upstream
    private Product findByName(String productName) {
        for (Product product : productRepository.findAll()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
=======
    public boolean recycleProductByName(String productName) {
        Product product = productService.findByName(productName);

        if (product == null) {
            return false;
        }

        return recycleProduct(product);
>>>>>>> Stashed changes
    }
}