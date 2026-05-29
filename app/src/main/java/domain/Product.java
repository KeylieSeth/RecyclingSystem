package domain;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int id;
    private double estimatedLifespan;
    
    //List that will hold all materials that product have.
    private List<ProductMaterialRelation> productMaterials;

    public Product(String name, double estimatedLifespan) {
        this.name = name;
        this.estimatedLifespan = estimatedLifespan;

        //When product is created it dont contain any materials.
        this.productMaterials = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
         this.id = id;
    }

    public double getEstimatedLifespan(){
        return estimatedLifespan;
    }
    
    //Called by product service to add a material to the list in product.
    public void addMaterial(ProductMaterialRelation material) {
        productMaterials.add(material);
    }

    //for other classes (like report) to get access to a product's material list.
    public List<ProductMaterialRelation> getMaterials() {
        return productMaterials;
    }

    public double calculateTotalMass(){
        double result = 0;
        for (ProductMaterialRelation productMaterial : productMaterials){
            result += productMaterial.getMass();
        }
        return result;
    }
}