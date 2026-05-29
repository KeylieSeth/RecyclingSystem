package application;
import domain.*;
import java.util.List;
import java.util.ArrayList;

public class MaterialService {
    private List<Material> materials;

    public MaterialService(){
        this.materials = new ArrayList<>();
        defineMaterial("Virgin Aluminium", 12.0, 0.9, RecyclingCategory.METAL);
        defineMaterial("Recycled Aluminiym", 1.5, 0.9, RecyclingCategory.METAL);
        defineMaterial("Virgin Steel", 2.2, 0.9, RecyclingCategory.METAL);
        defineMaterial("Recycled Steel", 0.4, 0.9, RecyclingCategory.METAL);
        defineMaterial("PET Plastic", 3.5, 0.5,  RecyclingCategory.CERAMIC);
        defineMaterial("HDPE Plastic", 2.0, 0.5, RecyclingCategory.PAPER);
        defineMaterial("PVC Plastic", 2.1, 0.2, RecyclingCategory.PAPER);
        defineMaterial("Virgin Glass", 1.1, 0.9, RecyclingCategory.PLASTIC);
        defineMaterial("Recycled Glass", 0.64, 0.9, RecyclingCategory.PLASTIC);
        defineMaterial("Wood (class 2)", 0.31, 0.2, RecyclingCategory.ORGANIC);
        defineMaterial("Paper (recycled/board)", 0.50, 0.5, RecyclingCategory.TEXTILE);
        defineMaterial("Cotton (fabric)", 5.5, 0.2, RecyclingCategory.TEXTILE);
        defineMaterial("Natural Rubber", 1.3, 0.2, RecyclingCategory.TEXTILE);
    }


    public void defineMaterial(String name, double eF, double recyclabilityFactor, RecyclingCategory category){
        if (eF > 0) {
            Material material = new Material(name,  eF, recyclabilityFactor, category);
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
        
        StringBuilder result = new StringBuilder();

        for (Material m : materials) {

            result.append(
                String.format("%-14s %14s%n",
                    m.getName(),
                    "Impact: " + m.getImpact())
            );
        }

        return result.toString();
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