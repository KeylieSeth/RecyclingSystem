package application;

import java.util.List;

import domain.ImpactCalculationStrategy;
import domain.Product;

public class Report {
    private List<Product> products;
    private double totalImpact;

    public Report(ProductService productService, ImpactCalculationStrategy strategy){
        //this.products = List.copyOf(productService.listProducts());
    
        double totalImpact = 0;

        for (Product p : products) {
            //totalImpact += productService.calculateImpact(p.getName(), strategy);
        }
    
        this.totalImpact = totalImpact;

    }

    public List<Product> getProducts() {
    return products;
    }

    public double getTotalImpact() {
    return totalImpact;
    }
}

