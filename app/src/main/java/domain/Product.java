package domain;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private int estimatedLifespan;
    private boolean recycled;
    
    private int id;
    
    //List that will hold all materials that product have.
    private List<ProductMaterialRelation> productMaterials;

    public Product(String name, String category, int estimatedLifespan) {
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.recycled = false;

        //When product is created it dont contain any materials.
        this.productMaterials = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getEstimatedLifespan() {
        return estimatedLifespan;
    }
    public boolean isRecycled() {
        return recycled;
    }
    public void setRecycled(boolean recycled) {
        this.recycled = recycled;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    //Called by product service to add a material to the list in product.
    public void addMaterial(ProductMaterialRelation material) {
        productMaterials.add(material);
    }

    //for other classes (like report) to get access to a product's material list.
    public List<ProductMaterialRelation> getMaterials() {
        return productMaterials;
    }
}