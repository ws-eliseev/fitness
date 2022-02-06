package ws.eliseev.fitness.model.calculators.calculatorfactory;

import ws.eliseev.fitness.model.calculators.Calculator;
import ws.eliseev.fitness.model.calculators.HarrisCalculator;
import ws.eliseev.fitness.model.calculators.MifflinCalc;

public class CalculatorFactory implements ICalculatorFactory {

    @Override
    public Calculator getMifflinCalculator() {
        return new MifflinCalc();
    }

    @Override
    public Calculator getHarrisCalculator() {
        return new HarrisCalculator();
    }
}
