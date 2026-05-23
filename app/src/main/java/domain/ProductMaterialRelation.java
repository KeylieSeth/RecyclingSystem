package domain;
public class ProductMaterialRelation {

    private Material material;
    private double mass;

    public ProductMaterialRelation(Material material, double mass){
        this.material = material;
        if(mass > 0) {
            this.mass = mass;
        }
    }
}
