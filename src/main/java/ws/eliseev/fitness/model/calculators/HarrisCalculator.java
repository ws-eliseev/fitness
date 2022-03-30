package ws.eliseev.fitness.model.calculators;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;

@Service
public class HarrisCalculator implements ICalculator {
    @Override
    public int calculate(UserParametersDto calorieDto) {
        if (calorieDto.getSex() == UserParametersDto.Sex.MALE) {
            return (int) ((66.47 + (13.75 * calorieDto.getWeight()) + (5 * calorieDto.getHeight())
                    - (6.74 * calorieDto.getAge())) * calorieDto.getActivity().getValue());
        }
        return (int) ((655.1 + (9.6 * calorieDto.getWeight()) + (1.85 * calorieDto.getHeight())
                - (4.68 * calorieDto.getAge())) * calorieDto.getActivity().getValue());
    }
}
