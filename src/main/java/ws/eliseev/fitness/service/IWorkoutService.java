package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.WorkoutDto;

import java.util.List;

@Service
public interface IWorkoutService {

    /**
     * метод получения списка всех Тренировок
     *
     * @return коллекции WorkoutDto в List
     */
    List<WorkoutDto> listWorkout();

    /**
     * метод создания или обновления сущности Workout
     *
     * @param workout WorkoutDto
     */
    void saveOrUpdateWorkout(WorkoutDto workout);

    /**
     * метод удаления сущности Workout из БД по ID
     *
     * @param id Первичный ключ сущности Workout
     */
    void deleteWorkoutByID(Long id);

    /**
     * метод получения сущности Workout по ID
     *
     * @param id Первичный ключ сущности Workout
     * @return объект WorkoutDto
     */
    WorkoutDto getWorkoutByID(Long id);
}
