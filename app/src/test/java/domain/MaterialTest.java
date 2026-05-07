package domain;

import org.junit.jupiter.api.Test;
import domain.Material;
import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
    @Test
    void getNameShouldReturnName() {
        //arrange
        Material material = new Material("plastic", 2.5);

        //Act
        String result = material.getName();

        //assert
        assertEquals("plastic", result);
    }

    @Test
    void getImpactShouldReturnImpactValue() {
        //arrange
        Material material = new Material("plastic", 2.5);

        //Act
        double result = material.getImpact();

        //assert
        assertEquals(2.5, result);
    }
}
