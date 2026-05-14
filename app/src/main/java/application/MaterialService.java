package application;

import domain.Material;

import java.util.ArrayList;
import java.util.List;

public class MaterialService {
    private final List<Material> materials;

    public MaterialService() {
        this.materials = new ArrayList<>();
    }

<<<<<<< Updated upstream
    public void defineMaterial(Material material) {
        materials.add(material);
=======

    public void defineMaterial(String name, double impact, RecyclingCategory category){
        if (impact >= 0) {
            Material material = new Material(name, impact, category);
            materials.add(material);
            return;
        }
        throw new IllegalArgumentException("Incorrect impact value " + impact);
>>>>>>> Stashed changes
    }

    public List<Material> listMaterials() {
        return materials;
    }

    public Material findByName(String name) {
        for (Material material : materials) {
            if (material.getName().equalsIgnoreCase(name)) {
                return material;
            }
        }
        return null;
    }

    public boolean deleteMaterial(String name) {
        Material material = findByName(name);
        if (material == null) {
            return false;
        }
        return materials.remove(material);
    }
}