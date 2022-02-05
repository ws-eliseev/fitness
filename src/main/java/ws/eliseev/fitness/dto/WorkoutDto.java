package ws.eliseev.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO объект от сущности Workout
 * @see ws.eliseev.fitness.model.Workout
 * @author Корнеев Аркадий
 */
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {

    /** Поле id */
    private Long id;

    /** Поле название упражнения */
    private String name;

    /** Поле указания группы мышц */
    private String exercise;

    /** Поле количество подходов */
    private int set;

    /** Поле количество повторений */
    private int repeat;

    /** Поле месторасположение для занятий */
    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
