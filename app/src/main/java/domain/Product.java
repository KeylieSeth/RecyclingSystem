package domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private int estimatedLifespan;
    private boolean recycled;

    public Product(String name, String category, int estimatedLifespan) {
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.recycled = false;
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

    public boolean isRecycled() {
        return recycled;
    }

    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }
}