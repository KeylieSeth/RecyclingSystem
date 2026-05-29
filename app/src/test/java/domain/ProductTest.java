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
    void setIdShouldSetId() {
        // arrange
        Product product = new Product("doll", 2.0);

        // act
        product.setId(5);

        // assert
        assertEquals(5, product.getId());
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
    void addMaterialShouldAddMaterialToList() {
        Product product = new Product("Laptop", 2.0);

        Material material = new Material("Plastic", 10, 1.0, RecyclingCategory.MIXED);
        ProductMaterialRelation relation =
                new ProductMaterialRelation(material, 2.5);

        product.addMaterial(relation);

        assertEquals(1, product.getMaterials().size());
        assertTrue(product.getMaterials().contains(relation));
    }

    @Test
    void getMaterialsShouldReturnAddedMaterials() {
        Product product = new Product("Laptop", 1.0);

        ProductMaterialRelation relation1 =
                new ProductMaterialRelation(
                        new Material("Plastic", 10, 1.0, RecyclingCategory.MIXED),
                        2.5);

        ProductMaterialRelation relation2 =
                new ProductMaterialRelation(
                        new Material("Steel", 20, 1.0, RecyclingCategory.METAL),
                        5.0);

        product.addMaterial(relation1);
        product.addMaterial(relation2);

        assertEquals(2, product.getMaterials().size());
        assertEquals(relation1, product.getMaterials().get(0));
        assertEquals(relation2, product.getMaterials().get(1));
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

    @Test
    void calculateTotalMassShouldReturnSumOfAllMasses() {
        Product product = new Product("Laptop", 1.0);

        product.addMaterial(
                new ProductMaterialRelation(
                        new Material("Plastic", 10, 1.0, RecyclingCategory.MIXED),
                        2.5));

        product.addMaterial(
                new ProductMaterialRelation(
                        new Material("Steel", 20, 1.0, RecyclingCategory.METAL),
                        5.0));

        assertEquals(7.5, product.calculateTotalMass());
    }

    @Test
    void calculateTotalMassShouldReturnZeroForEmptyProduct() {
        Product product = new Product("Laptop", 1.0);

        assertEquals(0.0, product.calculateTotalMass());
    }
}