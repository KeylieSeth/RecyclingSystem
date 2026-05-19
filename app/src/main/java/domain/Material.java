package domain;
import java.io.Serializable;

public class Material implements Serializable {

    private String name;
    private double impactValue;
    private RecyclingCategory recyclingCategory;

    public Material(String name, double impactValue, RecyclingCategory recyclingCategory){
        this.name = name;
            if (impactValue > 0){
                this.impactValue = impactValue;
        }
        this.recyclingCategory = recyclingCategory;
    }
    public String getName() {
        return name;
    }
    public double getImpact(){
        return impactValue;
    }
    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}