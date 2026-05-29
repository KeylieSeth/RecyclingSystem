package domain;

import java.util.List;

public interface Repository {
    List<Product> getAllProducts();
    List<Material> getAllMaterials();

    void setAllProducts(List<Product> products);
    void setAllMaterials(List<Material> materials);

}
