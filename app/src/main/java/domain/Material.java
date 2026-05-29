package domain;
import java.io.Serializable;

public class Material implements Serializable {

    private String name;
    private double eF; // Emmission factor
    private double recyclabilityFactor; // value between 0 and 1
    private RecyclingCategory recyclingCategory;

    public Material(String name, double eF, double recyclabilityFactor, RecyclingCategory recyclingCategory){
        this.name = name;
        if (eF > 0){
            this.eF = eF;
        }
        if (recyclabilityFactor >= 0 && recyclabilityFactor <= 1) {
            this.recyclabilityFactor = recyclabilityFactor;
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
    public double getRecyclabilityFactor(){
        return recyclabilityFactor;
    }
    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }
}