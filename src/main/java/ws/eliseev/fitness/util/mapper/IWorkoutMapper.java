package ws.eliseev.fitness.util.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.model.Workout;

/**
 * Преобразовние сущности Workout в DTO
 *
 * @author Корнеев Аркадий
 * @see ws.eliseev.fitness.model.Workout
 * @see ws.eliseev.fitness.dto.WorkoutDto
 */
@Mapper(componentModel = "spring")
public interface IWorkoutMapper {

    /**
     * метод преобразования объекта в DTO
     *
     * @param entity сущность Workout
     * @return объект типа DTO
     */
    WorkoutDto mapToDto(Workout entity);

    /**
     * метод преобразования объекта в entity
     *
     * @param dto объект WorkoutDto
     * @return сущность Workout
     */
    Workout mapToModel(WorkoutDto dto);
}
