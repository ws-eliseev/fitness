package ws.eliseev.fitness.model.calculators.calculatorfactory;

import org.springframework.beans.factory.annotation.Qualifier;
import ws.eliseev.fitness.model.calculators.HarrisCalculator;
import ws.eliseev.fitness.model.calculators.ICalculator;
import ws.eliseev.fitness.model.calculators.MifflinCalc;
import ws.eliseev.fitness.model.calculators.UserParametersDto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class CalculatorFactory {
    @Qualifier("harrisCalculator")
    HarrisCalculator harrisCalculator;
    @Qualifier("mifflinCalc")
    MifflinCalc mifflinCalc;


    public int getCalc(UserParametersDto userParametersDto) {
        AtomicReference<ICalculator> result = null;
        Map<String, Consumer<String>> calculatorMap = Map.of(
                "key", x -> result.set(harrisCalculator),
                "key2", x -> result.set(mifflinCalc));
        // прописать Optional of nullable userparamdto.getKey
        return calculatorMap.get(userParametersDto.getKey()).accept(userParametersDto.getKey());
    }
}
