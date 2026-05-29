package domain;

import java.io.Serializable;

public class ProductMaterialRelation implements Serializable {

    private Material material;
    private double mass;

    public ProductMaterialRelation(Material material, double mass){
        this.material = material;
        if(mass > 0) {
            this.mass = mass;
        }
    }
    public Material getMaterial(){
        return material;
    }

    public double getMass(){
        return mass;
    }

}
