package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMaterialRelationTest {

    @Test
    void getMaterialShouldReturnMaterial() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 3.0);

        // act
        Material result = relation.getMaterial();

        // assert
        assertEquals(material, result);
    }

    @Test
    void getMassShouldReturnMass() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 3.0);

        // act
        double result = relation.getMass();

        // assert
        assertEquals(3.0, result);
    }

    @Test
    void getMassShouldBeZeroWhenMassIsNotPositive() {
        // arrange
        Material material = new Material("plastic", 2.5, RecyclingCategory.PLASTIC);
        ProductMaterialRelation relation = new ProductMaterialRelation(material, 0.0);

        // act
        double result = relation.getMass();

        // assert
        assertEquals(0.0, result);
    }
}