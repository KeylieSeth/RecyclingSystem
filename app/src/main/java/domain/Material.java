package domain;
import java.io.Serializable;

public class Material implements Serializable {

    private String name;
    private double eF; // Emmission factor
    private RecyclingCategory recyclingCategory;

    public Material(String name, double eF, RecyclingCategory recyclingCategory){
        this.name = name;
            if (eF > 0){
                this.eF = eF;
        }
        this.recyclingCategory = recyclingCategory;
    }
    public String getName() {
        return name;
    }
    public double getImpact(){
        return eF;
    }
    public double getEmmissionFactor(){
        return eF;
    }
    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}