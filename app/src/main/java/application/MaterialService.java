package application;
import domain.*;
import java.util.List;
import java.util.ArrayList;

public class MaterialService {
    private List<Material> materials;

    public MaterialService(){
        this.materials = new ArrayList<>();
    }


    public void defineMaterial(String name, double eF, RecyclingCategory category){
        if (eF >= 0) {
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
            if (material.getName().toLowerCase().equals(name)) {
                return material;
            }
        } 
        throw new IllegalArgumentException("Material not found: " + name);
     }
}

