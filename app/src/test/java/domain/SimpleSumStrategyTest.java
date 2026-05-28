package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSumStrategyTest {

    @Test
    void calculateShouldReturnZeroWhenProductHasNoMaterials() {
        // arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("doll", 2.0);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(0.0, result);
    }

    @Test
    void calculateShouldReturnImpactForOneMaterialRelation() {
        // arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("doll", 2.0);

        Material material = new Material("plastic", 10.0, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 2.0);
        product.addMaterial(relation);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(20.0, result);
    }

    @Test
    void calculateShouldSumImpactFromMultipleMaterialRelations() {
        // arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("chair", 5.0);

        Material plastic = new Material("plastic", 10.0, RecyclingCategory.PLASTIC);
        Material metal = new Material("metal", 4.0, RecyclingCategory.METAL);

        ProductMaterialRelation relation1 = new ProductMaterialRelation(plastic, 2.0); // 20
        ProductMaterialRelation relation2 = new ProductMaterialRelation(metal, 3.0);   // 12

        product.addMaterial(relation1);
        product.addMaterial(relation2);

        // act
        double result = strategy.calculate(product);

        // assert
        assertEquals(32.0, result);
    }
}