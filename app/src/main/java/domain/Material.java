package domain;
import java.io.Serializable;

public class Material implements Serializable {

    private String name;
    private double impactValue;

    public Material(String name, double impactValue){
        this.name = name;
            if (impactValue > 0){
                this.impactValue = impactValue;
        }
    }
    public String getName() {
        return name;
    }
    public double getImpact(){
        return impactValue;
    }
}