package domain;
public class LifespanAdjustedStrategy implements ImpactCalculationStrategy {
    private ImpactCalculationStrategy simpleSumStrategy;

    public LifespanAdjustedStrategy(ImpactCalculationStrategy simpleSumStrategy){
        this.simpleSumStrategy = simpleSumStrategy;
    }

    @Override
    public double calculate(Product product) {
        double rawImpact = simpleSumStrategy.calculate(product); 

        int lifespan = product.getEstimatedLifespan();

        if (lifespan <= 0){
            return rawImpact;
        }
        return rawImpact / lifespan;
    }
}