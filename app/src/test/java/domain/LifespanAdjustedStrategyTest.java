package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LifespanAdjustedStrategyTest {

    @Test
    void calculateShouldDivideRawImpactByLifespan() {
        // arrange
        ImpactCalculationStrategy simpleStrategy = new SimpleSumStrategy();
        LifespanAdjustedStrategy strategy = new LifespanAdjustedStrategy(simpleStrategy);

        Product product = new Product("doll", 2.0);
        Material material = new Material("plastic", 10.0, 1.0, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 1.0);
        product.addMaterial(relation);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(5.0, result);
    }

    @Test
    void calculateShouldReturnRawImpactWhenLifespanIsZero() {
        // arrange
        ImpactCalculationStrategy simpleStrategy = new SimpleSumStrategy();
        LifespanAdjustedStrategy strategy = new LifespanAdjustedStrategy(simpleStrategy);

        Product product = new Product("doll", 0.0);
        Material material = new Material("plastic", 10.0, 1.0, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 1.0);
        product.addMaterial(relation);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(10.0, result);
    }

    @Test
    void calculateShouldReturnRawImpactWhenLifespanIsNegative() {
        // arrange
        ImpactCalculationStrategy simpleStrategy = new SimpleSumStrategy();
        LifespanAdjustedStrategy strategy = new LifespanAdjustedStrategy(simpleStrategy);

        Product product = new Product("doll", -2.0);
        Material material = new Material("plastic", 10.0, 1.0, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 1.0);
        product.addMaterial(relation);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(10.0, result);
    }
}