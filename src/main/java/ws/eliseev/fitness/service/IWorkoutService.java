package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.WorkoutDTO;

import java.util.List;

@Service
public interface IWorkoutService {

    /**
     * метод получения списка всех Тренировок
     *
     * @return коллекции WorkoutDTO в List
     */
    List<WorkoutDTO> listWorkout();

    /**
     * метод создания или обновления сущности Workout
     *
     * @param workout WorkoutDTO
     */
    void saveOrUpdateWorkout(WorkoutDTO workout);

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
     * @return объект WorkoutDTO
     */
    WorkoutDTO getWorkoutByID(Long id);
}
