package application;

import java.util.ArrayList;
import java.util.List;

import domain.Product;
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
           
            double impact = productService.calculateImpact(p.getName());
            totalImpact += impact;

            String materials = "";
            for (Material m : p.getMaterials()) {
                if (!materials.isEmpty()) {
                    materials += ", ";
                }
                materials += m.getName();
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

