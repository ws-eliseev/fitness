package ws.eliseev.fitness.model.calculators;

public class MifflinCalc implements Calculator {
    @Override
    public int calculate(UserParametersDto calorieDto) {
        return (int) (((10 * calorieDto.getWeight()) + (6.25 * calorieDto.getHeight()) - (5 * calorieDto.getAge())
                + calorieDto.getSex().getValue()) * calorieDto.getActivity().getValue());
    }
}
