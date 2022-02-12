package ws.eliseev.fitness.model.calculators;

import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;

public interface ICalculator {
     int calculate(UserParametersDto userParametersDto);
}
