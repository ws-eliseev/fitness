package ws.eliseev.fitness.model.calculators.calculatorfactory;

import ws.eliseev.fitness.model.calculators.Calculator;

public interface ICalculatorFactory{
    Calculator getMifflinCalculator();
    Calculator getHarrisCalculator();
}
