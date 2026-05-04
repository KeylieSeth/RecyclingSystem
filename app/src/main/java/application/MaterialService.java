package application;
import domain.*;
import java.util.List;
import java.util.ArrayList;

public class MaterialService {
    private List<Material> materials;

    public MaterialService(){
        this.materials = new ArrayList<>();
    }

    public void defineMaterial(String name, double impact){
        Material material = new Material(name, impact);
        materials.add(material);
    }

    public List<Material> listMaterials(){
        return materials;
    }

    public Material findByname(String name) {
        for (Material material: materials) {
            if (material.getName().equals(name)) {
                return material;
            }
        } 
        return null;
     }
}

