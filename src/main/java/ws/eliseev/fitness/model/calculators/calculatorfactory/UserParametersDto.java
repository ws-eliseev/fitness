package ws.eliseev.fitness.model.calculators.calculatorfactory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserParametersDto {
    private int age;
    private Sex sex;
    private int weight;
    private int height;
    private Activity activity;
    private CalculatorType key;
    private WeightLossOrGain weightLossOrGainPercent;

    public enum WeightLossOrGain {
        SMALL_LOSS(0.85),
        MEDIUM_LOSS(0.80),
        LARGE_LOSS(0.75),
        SMALL_GAIN(1.10),
        MEDIUM_GAIN(1.15),
        LARGE_GAIN(1.20);

        private final Double value;

        WeightLossOrGain(Double value) {
            this.value = value;
        }

        public Double getValue() {
            return value;
        }

    }

    public enum Activity {
        SEDENTARY(1.2),
        LIGHTLY(1.375),
        MODERATELY_ACTIVE(1.55),
        VERY_ACTIVE(1.725),
        EXTRA_ACTIVE(1.9);

        private final Double value;

        Activity(Double value) {
            this.value = value;
        }

        public Double getValue() {
            return value;
        }

    }

    public enum Sex {
        MALE(5),
        FEMALE(-161);
        private final int value;

        Sex(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}