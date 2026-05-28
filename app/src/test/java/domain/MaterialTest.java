package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    @Test
    void getNameShouldReturnName() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        String result = material.getName();

        // assert
        assertEquals("plastic", result);
    }

    @Test
    void getImpactShouldReturnImpactValue() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        double result = material.getImpact();

        // assert
        assertEquals(2.5, result);
    }

    @Test
    void getEmmissionFactorShouldReturnEF() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        double result = material.getEmmissionFactor();

        // assert
        assertEquals(2.5, result);
    }

    @Test
    void getRecyclingCategoryShouldReturnCategory() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        RecyclingCategory result = material.getRecyclingCategory();

        // assert
        assertEquals(RecyclingCategory.PLASTIC, result);
    }
}