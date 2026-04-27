package domain;

public class Material {
    private String name;
    private double impactValue;
    private RecyclingCategory recyclingCategory;

    public Material() {
    }

    public Material(String name, double impactValue, RecyclingCategory recyclingCategory) {
        this.name = name;
        this.impactValue = impactValue;
        this.recyclingCategory = recyclingCategory;
    }

    public String getName() {
        return name;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}