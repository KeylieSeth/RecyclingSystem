package domain;

import java.util.List;

public class Product {

    private String name;
    private String category;
    private int estimatedLifespan;
    private List<Material> materials;

    public Product(String name, String category, int estimatedLifespan, List<Material> materials) {
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getEstimatedLifespan() {
        return estimatedLifespan;
    }

    public List<Material> getMaterials() {
        return materials;
    }
}