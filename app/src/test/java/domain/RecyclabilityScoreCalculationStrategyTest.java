package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecyclabilityScoreCalculationStrategyTest {

    @Test
    void calculateShouldReduceImpactBasedOnRecyclability() {

        Product product = new Product("Phone", 1.0);

        Material material =
                new Material("Plastic", 100, 1.0, RecyclingCategory.MIXED);

        product.addMaterial(
                new ProductMaterialRelation(material, 10));

        RecyclabilityScoreCalculationStrategy strategy = new RecyclabilityScoreCalculationStrategy();

        double result = strategy.calculate(product);

        // Raw impact = 100
        // Contribution = (10/10) * 1.0 * 0.1 = 0.1
        // Result = 100 * (1 - 0.1) = 90

        assertEquals(900.0, result, 0.001);
    }
}
