package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String category;
    private int estimatedLifespan;
    private List<Material> materials;
    private boolean recycled;
    private List<Material> materials;

    public Product() {
        this.materials = new ArrayList<>();
        this.recycled = false;
    }

    public Product(UUID id, String name, String category, int estimatedLifespan) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = new ArrayList<>();
        this.recycled = false;
    }

    public Product(UUID id, String name, String category, int estimatedLifespan, List<Material> materials) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = materials != null ? materials : new ArrayList<>();
        this.recycled = false;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Material> getMaterials() {
        return materials;
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

    public boolean isRecycled() {
        return recycled;
    }

    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    public void addMaterial(Material material) {
        if (material != null) {
            materials.add(material);
        }
    }
}