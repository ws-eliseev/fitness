package ws.eliseev.fitness.model.calculators.calculatorfactory;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.calculators.HarrisCalculator;
import ws.eliseev.fitness.model.calculators.ICalculator;
import ws.eliseev.fitness.model.calculators.MifflinCalc;
import ws.eliseev.fitness.model.calculators.WeightCalculator;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.function.Supplier;

@Service
public class CalculatorFactory {

    private final EnumMap<CalculatorType, Supplier<ICalculator>> mapCalculator = new EnumMap<>(CalculatorType.class);

    @PostConstruct
    public void createCalculator() {
        mapCalculator.put(CalculatorType.HARRISON, HarrisCalculator::new);
        mapCalculator.put(CalculatorType.MIFFLIN, MifflinCalc::new);
        mapCalculator.put(CalculatorType.WEIGHT_LOSS, WeightCalculator::new);
    }

    /**
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

