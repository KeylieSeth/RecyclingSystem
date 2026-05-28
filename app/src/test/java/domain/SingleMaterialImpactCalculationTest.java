package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleMaterialImpactCalculationTest {

    @Test
    void calculateMaterialImpactShouldReturnMassTimesEmissionFactor() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        double result = SingleMaterialImpactCalculation.calculateMaterialImpact(4.0, material);

        // assert
        assertEquals(10.0, result);
    }

    @Test
    void calculateMaterialImpactShouldReturnZeroWhenMassIsZero() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);

        // act
        double result = SingleMaterialImpactCalculation.calculateMaterialImpact(0.0, material);

        // assert
        assertEquals(0.0, result);
    }

    @Test
    void calculateMaterialImpactShouldReturnZeroWhenEmissionFactorIsZero() {
        // arrange
        Material material = new Material("plastic", 0.0, RecyclingCategory.PLASTIC);

        // act
        double result = SingleMaterialImpactCalculation.calculateMaterialImpact(4.0, material);

        // assert
        assertEquals(0.0, result);
    }
}