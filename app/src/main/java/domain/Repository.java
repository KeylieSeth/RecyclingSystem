package domain;

import java.io.IOException;
import java.util.List;

public interface Repository {
    List<Product> getAllProducts();
    List<Material> getAllMaterial();

    void setAllProducts(List<Product> products);
    void setAllMaterial(List<Material> materials);

    void saveToFile(String fileName) throws IOException;
    void loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
