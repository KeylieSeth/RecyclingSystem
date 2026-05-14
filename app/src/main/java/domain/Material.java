package domain;

public class Material {
    private String name;
    private double impactValue;
    private RecyclingCategory recyclingCategory;

<<<<<<< Updated upstream
    public Material() {
=======
    public Material(String name, double impactValue, RecyclingCategory recyclingCategory){
        this.name = name;
            if (impactValue > 0){
                this.impactValue = impactValue;
        }
        this.recyclingCategory = recyclingCategory;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}