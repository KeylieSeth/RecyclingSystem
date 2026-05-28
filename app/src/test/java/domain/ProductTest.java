package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getNameShouldReturnName() {
        // arrange
        Product product = new Product("doll", 2.0);

        // act
        String result = product.getName();

        // assert
        assertEquals("doll", result);
    }

    @Test
    void getEstimatedLifespanShouldReturnLifespan() {
        // arrange
        Product product = new Product("doll", 2.0);

        // act
        double result = product.getEstimatedLifespan();

        // assert
        assertEquals(2.0, result);
    }

    @Test
    void setIdShouldSetId() {
        // arrange
        Product product = new Product("doll", 2.0);

        // act
        product.setId(5);

        // assert
        assertEquals(5, product.getId());
    }

    @Test
    void getMaterialsShouldReturnEmptyListWhenNoMaterialsAdded() {
        // arrange
        Product product = new Product("doll", 2.0);

        // act
        int result = product.getMaterials().size();

        // assert
        assertEquals(0, result);
    }
}