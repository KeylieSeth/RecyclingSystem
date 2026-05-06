package domain;
import org.junit.jupiter.api.Test;

import domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void getNameShouldReturnName() {
        //arrange
        Product product = new Product("doll", "toys", 2);

        //Act
        String result = product.getName();

        //assert
        assertEquals("doll", result);
    }

    @Test
    void getCategoryShouldReturnCategory() {
        //arrange
        Product product = new Product("doll", "toys", 2);

        //Act
        String result = product.getCategory();

        //assert
        assertEquals("toys", result);  
    }

    @Test
    void getEstimatedLifespanShouldReturnLifespanAsInt() {
        //arrange
        Product product = new Product("doll", "toys", 2);

        //Act
        int result = product.getEstimatedLifespan();

        //assert
        assertEquals(2, result);  
    }

    @Test
    void isRecycledShouldReturnBooleanValue() {
        //arrange
        Product product = new Product("doll", "toys", 2);

        //Act
        Boolean result = product.isRecycled();

        //assert
        assertEquals(false, result);
    }
}
