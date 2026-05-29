package infrastructure;

import java.util.ArrayList;
import java.util.List;
import domain.Material;
import domain.Product;
import domain.Repository;


public class InMemoryRepository implements Repository {
    private List<Product> products;
    private List<Material> materials;

    public InMemoryRepository() {
        this.products = new ArrayList<>();
        this.materials = new ArrayList<>();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Material> getAllMaterials() {
        return materials;
    }

    @Override
    public void setAllProducts(List<Product> products) {
        if (products == null) {
            this.products = new ArrayList<>();
        } else {
            this.products = products;
        }
    }

    @Override
    public void setAllMaterials(List<Material> materials) {
        if (materials == null) {
            this.materials = new ArrayList<>();
        } else {
            this.materials = materials;
        }
    }

}