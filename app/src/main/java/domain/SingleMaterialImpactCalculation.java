package domain;

public class SingleMaterialImpactCalculation {

    public static double calculateMaterialImpact(double mass, Material material){
        return mass * material.getEmmissionFactor();
    }
}
