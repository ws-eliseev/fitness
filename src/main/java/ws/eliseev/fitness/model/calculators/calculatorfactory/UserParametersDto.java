package ws.eliseev.fitness.model.calculators.calculatorfactory;


import ws.eliseev.fitness.model.calculators.calculatorfactory.CalculatorType;

public class UserParametersDto {
    private int age;
    private Sex sex;
    private int weight;
    private int height;
    private Activity activity;
    private CalculatorType key;

    public UserParametersDto(int age, Sex sex, int weight, int height, Activity activity, CalculatorType key) {
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
        this.key = key;
    }

    public CalculatorType getKey() {
        return key;
    }

    public void setKey(CalculatorType key) {
        this.key = key;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public enum Activity {
        SEDENTARY(1.2),
        LIGHTLY(1.375),
        MODERATELYACTIVE(1.55),
        VERYACTIVE(1.725),
        EXTRAACTIVE(1.9);

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