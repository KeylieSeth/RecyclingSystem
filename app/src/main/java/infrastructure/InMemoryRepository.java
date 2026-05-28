package infrastructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import domain.Material;
import domain.Product;
import domain.Repository;


public class InMemoryRepository implements Repository {
    private List<Product> products;
    private List<Material> materials;
    private FileHandler fileHandler;

    public InMemoryRepository() {
        this.products = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.fileHandler = new FileHandler();
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

    @Override
    public void saveToFile(String fileName) throws IOException {
        fileHandler.save(products, materials, fileName);
    }
    @Override
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        this.products = fileHandler.loadProducts(fileName);
        this.materials = fileHandler.loadMaterials(fileName);
    }
}