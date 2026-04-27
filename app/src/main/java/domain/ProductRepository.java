package domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void save(Product product);
    boolean deleteById(UUID productId);
    Optional<Product> findById(UUID productId);
    Optional<Product> findByName(String name);
    List<Product> findAll();
}