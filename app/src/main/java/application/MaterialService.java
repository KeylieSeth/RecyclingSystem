package application;
import domain.*;
import java.util.List;

public class MaterialService {
    private Repository repo;


    public MaterialService(Repository repo){
        this.repo = repo;

        defineMaterial("Virgin Aluminium", 12.0, 0.9, RecyclingCategory.METAL);
        defineMaterial("Recycled Aluminium", 1.5, 0.9, RecyclingCategory.METAL);
        defineMaterial("Virgin Steel", 2.2, 0.9, RecyclingCategory.METAL);
        defineMaterial("Recycled Steel", 0.4, 0.9, RecyclingCategory.METAL);
        defineMaterial("PET Plastic", 3.5, 0.5,  RecyclingCategory.PLASTIC);
        defineMaterial("HDPE Plastic", 2.0, 0.5, RecyclingCategory.PLASTIC);
        defineMaterial("PVC Plastic", 2.1, 0.2, RecyclingCategory.PLASTIC);
        defineMaterial("Virgin Glass", 1.1, 0.9, RecyclingCategory.GLASS);
        defineMaterial("Recycled Glass", 0.64, 0.9, RecyclingCategory.GLASS);
        defineMaterial("Wood (class 2)", 0.31, 0.2, RecyclingCategory.ORGANIC);
        defineMaterial("Paper (recycled/board)", 0.50, 0.5, RecyclingCategory.PAPER);
        defineMaterial("Cotton (fabric)", 5.5, 0.2, RecyclingCategory.TEXTILE);
        defineMaterial("Natural Rubber", 1.3, 0.2, RecyclingCategory.MIXED);
    }


    public void defineMaterial(String name, double eF, double recyclabilityFactor, RecyclingCategory category){
        if (eF > 0) {
            Material material = new Material(name,  eF, recyclabilityFactor, category);
            repo.getAllMaterials().add(material);
            return;
        }
        throw new IllegalArgumentException("Incorrect impact value " + eF);
    }

    public void deleteMaterial(String name) {
        repo.getAllMaterials().removeIf(
            material -> material.getName().equals(name)
        );
    }

    public String listMaterials(){
        if (repo.getAllMaterials().isEmpty()) {
            return "No materials found";
        } 
        
        StringBuilder result = new StringBuilder();

        for (Material m : repo.getAllMaterials()) {

            result.append(
                String.format("%-24s %10s%n",
                    m.getName(),
                    "Impact: " + m.getImpact())
            );
        }

        return result.toString();
    }

    //Needed for adding materials to a product in productMenu.
    public List<Material> getAllMaterials() {
        return repo.getAllMaterials();
    }

    public Material findByName(String name) {
        for (Material material : repo.getAllMaterials()) {
            if (material.getName().toLowerCase().equals(name.toLowerCase())) {
                return material;
            }
        } 
        throw new IllegalArgumentException("Material not found: " + name);
     }
    
    public void setMaterials(List<Material> materials) {
        repo.setAllMaterials(materials);
    }
}