package ws.eliseev.fitness.model.calculators;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;

@Service
public class MifflinCalc implements ICalculator {
    @Override
    public int calculate(UserParametersDto userParametersDto) {
        return (int) (((10 * userParametersDto.getWeight()) + (6.25 * userParametersDto.getHeight())
                - (5 * userParametersDto.getAge())
                + userParametersDto.getSex().getValue()) * userParametersDto.getActivity().getValue());
    }
}
