package ws.eliseev.fitness.model.calculators;

import org.springframework.stereotype.Service;

@Service
public class MifflinCalc implements ICalculator {
    @Override
    public int calculate(UserParametersDto calorieDto) {
        return (int) (((10 * calorieDto.getWeight()) + (6.25 * calorieDto.getHeight()) - (5 * calorieDto.getAge())
                + calorieDto.getSex().getValue()) * calorieDto.getActivity().getValue());
    }
}
