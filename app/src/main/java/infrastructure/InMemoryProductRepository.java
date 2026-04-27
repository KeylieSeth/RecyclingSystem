package infrastructure;

import domain.Product;
import domain.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products;

    public InMemoryProductRepository() {
        this.products = new ArrayList<>();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public boolean deleteById(UUID productId) {
        Optional<Product> product = findById(productId);

        if (product.isPresent()) {
            products.remove(product.get());
            return true;
        }

        return false;
    }

    @Override
    public Optional<Product> findById(UUID productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}