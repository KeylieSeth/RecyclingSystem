package domain;

public class SimpleSumStrategy implements ImpactCalculationStrategy {

    @Override
    public double calculate(Product product){
        double result = 0;

        for (ProductMaterialRelation productMaterial : product.getMaterials()){
            double impactContribution = productMaterial.getMass() * productMaterial.getMaterial().getEmmissionFactor();

            result += impactContribution;
        }
        
        return result;
    }
}
