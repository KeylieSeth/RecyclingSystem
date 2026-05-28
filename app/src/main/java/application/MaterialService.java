package application;
import domain.*;
import java.util.List;

public class MaterialService {
    private Repository repo;

    public MaterialService(Repository repo){
        this.repo = repo;
    }


    public void defineMaterial(String name, double eF, RecyclingCategory category){
        if (eF > 0) {
            Material material = new Material(name, eF, category);
            repo.getAllMaterials().add(material);
            return;
        }
        throw new IllegalArgumentException("Incorrect impact value " + eF);
    }


    public void deleteMaterial(String name) {
        for (Material material: repo.getAllMaterials()){
            if (material.getName().equals(name)) {
                repo.getAllMaterials().remove(material);
                return;
            }
        }
        throw new IllegalArgumentException("Material not found: " + name);
    }


    public String listMaterials(){
        if (repo.getAllMaterials().isEmpty()) {
            return "No materials found";
        } 
        
        String result = "";
        
        for (Material m : repo.getAllMaterials()) {
            result += m.getName() +" | Impact " + m.getImpact() + "\n";
        }

        return result;
    }

    //Needed for adding materials to a product in productMenu.
    public List<Material> getAllMaterials() {
        return repo.getAllMaterials();
    }

    public Material findByName(String name) {
        for (Material material: materials) {
            if (material.getName().toLowerCase().equals(name.toLowerCase())) {
                return material;
            }
        } 
        throw new IllegalArgumentException("Material not found: " + name);
     }
}