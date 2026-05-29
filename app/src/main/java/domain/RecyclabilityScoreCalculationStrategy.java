package domain;

public class RecyclabilityScoreCalculationStrategy implements ImpactCalculationStrategy {
    private static final double CREDIT  =  0.1;
    private final ImpactCalculationStrategy rawImpactStrategy = new SimpleSumStrategy();
    
    @Override
    public double calculate(Product product) {
        double rawImpact = rawImpactStrategy.calculate(product);

        double recyclabilityContribution = 0;
        double totalMass = product.calculateTotalMass();
        if (totalMass <= 0){
            return rawImpact;
        }

        for(ProductMaterialRelation productMaterial : product.getMaterials()){
            recyclabilityContribution += (productMaterial.getMass() / totalMass) * 
            productMaterial.getMaterial().getRecyclabilityFactor() * CREDIT;
        }
        return rawImpact * (1 - recyclabilityContribution);
    }
}

 