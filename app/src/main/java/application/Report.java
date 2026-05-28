package application;

import java.util.ArrayList;
import java.util.List;

import domain.Product;
import domain.ProductMaterialRelation;
import domain.Material;

public class Report {
    private List<Product> products;
    private List<String> rows;
    private double totalImpact;
    

    public Report(ProductService productService){
        this.products = List.copyOf(productService.listProducts());
        this.rows = new ArrayList<>();
        this.totalImpact = 0;

        for (Product p : products) {
            // total impact for product
            double impact = productService.calculateSimpleSum(p);
            totalImpact += impact;

            String materials = "";
            for (ProductMaterialRelation productMaterial : p.getMaterials()) {
                if (!materials.isEmpty()) {
                    materials += ", ";
                }
                materials += productMaterial.getMaterial().getName();
            }

            int quantity = 1;

            String row = p.getName() + "\t" + quantity + "\t" + impact + "\t" + materials;

            rows.add(row);
        }
    }

    public List<String> getRows() {
        return rows;
    }

    public double getTotalImpact() {
        return totalImpact;
    }
}

