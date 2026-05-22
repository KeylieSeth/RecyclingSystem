package domain;

public class PerMaterialContribution implements ImpactCalculationStrategy {

    @Override
    public double calculate(double eF, double mass){
        if (eF > 0 && mass > 0){
            return mass * eF;
        } else {
            return 0;
        }
        
    }
}
