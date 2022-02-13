package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.WorkoutDTO;
import ws.eliseev.fitness.model.Workout;

/**
 * Преобразовние сущности Workout в DTO
 *
 * @author Корнеев Аркадий
 * @see ws.eliseev.fitness.model.Workout
 * @see WorkoutDTO
 */
@Mapper(componentModel = "spring")
public interface IWorkoutMapper {

    /**
     * метод преобразования объекта в DTO
     *
     * @param entity сущность Workout
     * @return объект типа DTO
     */
    WorkoutDTO mapToDto(Workout entity);

    /**
     * метод преобразования объекта в entity
     *
     * @param dto объект WorkoutDTO
     * @return сущность Workout
     */
    Workout mapToModel(WorkoutDTO dto);
}
