package ws.eliseev.fitness.model.calculators.calculatorfactory;

import ws.eliseev.fitness.model.calculators.HarrisCalculator;
import ws.eliseev.fitness.model.calculators.ICalculator;
import ws.eliseev.fitness.model.calculators.MifflinCalc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CalculatorFactory {


    static final Map<CalculatorType, Supplier<ICalculator>> mapCalculator = new HashMap<>();

    static {
        mapCalculator.put(CalculatorType.HARRISON, HarrisCalculator::new);
        mapCalculator.put(CalculatorType.MIFFLIN, MifflinCalc::new);
    }

    /**
     *
     * @param userParametersDto - DTO параметров пользователя для вычислений
     * @return - возращает числовой результат вычислений
     */
    public Number getCalculatorResult(UserParametersDto userParametersDto) {
        Supplier<ICalculator> iCalculator = mapCalculator.get(userParametersDto.getKey());
        if (iCalculator != null) {
            return iCalculator.get().calculate(userParametersDto);
        }
        throw new IllegalArgumentException("No such calculator " + userParametersDto.getKey().name());
    }
}

