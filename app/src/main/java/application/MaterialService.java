package application;
import domain.*;
import java.util.List;
import java.util.ArrayList;

public class MaterialService {
    private List<Material> materials;

    public MaterialService(){
        this.materials = new ArrayList<>();
        defineMaterial("Aluminium", 8.2, RecyclingCategory.METAL);

        defineMaterial("Steel", 6.7, RecyclingCategory.METAL);

        defineMaterial("Copper", 9.1, RecyclingCategory.METAL);

        defineMaterial("Glass", 3.4, RecyclingCategory.CERAMIC);

        defineMaterial("Cardboard", 1.8, RecyclingCategory.PAPER);

        defineMaterial("Paper", 1.2, RecyclingCategory.PAPER);

        defineMaterial("PET Plastic", 5.6, RecyclingCategory.PLASTIC);

        defineMaterial("HDPE Plastic", 4.9, RecyclingCategory.PLASTIC);

        defineMaterial("Wood", 2.3, RecyclingCategory.ORGANIC);

        defineMaterial("Textile", 4.1, RecyclingCategory.TEXTILE);
    }


    public void defineMaterial(String name, double eF, RecyclingCategory category){
        if (eF > 0) {
            Material material = new Material(name, eF, category);
            materials.add(material);
            return;
        }
        throw new IllegalArgumentException("Incorrect impact value " + eF);
    }


    public void deleteMaterial(String name) {
        for (Material material: materials){
            if (material.getName().equals(name)) {
                materials.remove(material);
                return;
            }
        }
        throw new IllegalArgumentException("Material not found: " + name);
    }


    public String listMaterials(){
        if (materials.isEmpty()) {
            return "No materials found";
        } 
        
        String result = "";
        
        for (Material m : materials) {
            result += m.getName() +" | Impact " + m.getImpact() + "\n";
        }

        return result;
    }

    //Needed for adding materials to a product in productMenu.
    public List<Material> getAllMaterials() {
        return materials;
    }

    public Material findByName(String name) {
        for (Material material: materials) {
            if (material.getName().toLowerCase().equals(name.toLowerCase())) {
                return material;
            }
        } 
        throw new IllegalArgumentException("Material not found: " + name);
     }
    
    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}