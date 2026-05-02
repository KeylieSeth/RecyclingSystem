package domain;

public class Material {
    private String name;
    private Double impactValue;

    public Material(String name, double impactValue){
        this.name = name;
            if (impactValue < 0){
                this.impactValue = impactValue;
        }
    }
}
