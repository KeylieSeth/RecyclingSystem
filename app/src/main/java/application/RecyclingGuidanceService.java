package application;

import domain.Material;
import domain.Product;
import domain.ProductMaterialRelation;
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

        List<ProductMaterialRelation> materials = product.getMaterials();

        if (materials == null || materials.isEmpty()) {
            return "No materials registered for this product.";
        }

        if (materials.size() > 1) {
            return "Mixed-material product. Separate materials before recycling if possible.";
        }

        return getGuidanceForMaterial(materials.get(0).getMaterial());
    }

    public String getGuidanceByProductName(String productName) {
        Product product = productService.findByName(productName);

        if (product == null) {
            return "Product not found.";
        }

        return getGuidance(product);
    }

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
        } else if (category == RecyclingCategory.ORGANIC) {
            return "Recycle as natural material or compost if applicable.";
        } else if (category == RecyclingCategory.MIXED) {
            return "Mixed material: separate the parts before recycling if possible.";
        } else if (category == RecyclingCategory.GLASS) {
            return "Recycle as glass.";
        } else if (category == RecyclingCategory.PAPER) {
            return "Recycle as paper.";
        } else if (category == RecyclingCategory.TEXTILE) {
            return "Recycle as textile.";
        }

        return "No recycling guidance available.";
    }

    public void updateGuidance(Product product, String newGuidance) {
        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }

        customGuidanceByProductName.put(product.getName(), newGuidance.trim());
    }
}