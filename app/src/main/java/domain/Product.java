package domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    
    //Mock code for testing.
    private String name;

    public Product(String name) {
    this.name = name;
    }

    public String getName() {
    return name;
    }

    public List<Material> getMaterials() {
    List<Material> materials = new ArrayList<>();
    materials.add(new Material("Wood"));
    materials.add(new Material("Metal"));
    return materials;
    }
}
