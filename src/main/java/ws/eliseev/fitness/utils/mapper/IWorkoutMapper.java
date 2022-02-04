package ws.eliseev.fitness.utils.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.model.Workout;

/**
 * Преобразовние сущности Workout в DTO
 * @see ws.eliseev.fitness.model.Workout
 * @see ws.eliseev.fitness.dto.WorkoutDto
 * @autor Корнеев Аркадий
 */
@Mapper(componentModel = "spring")
public interface IWorkoutMapper {

//    WorkoutDto mapWorkoutToWorkoutDto (Workout entity);


//    Workout mapWorkoutDtoToEntityWorkout (WorkoutDto dto);

    /**
     * метод преобразования объекта в DTO
     * @param entity сущность Workout
     * @return объект типа DTO
     */
    default WorkoutDto mapToDto(Workout entity) {
        WorkoutDto dto = new WorkoutDto();
        if (dto == null) {
            return null;
        }
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setExercise(entity.getExercise());
        dto.setSet(entity.getSet());
        dto.setRepeat(entity.getRepeat());
        dto.setArea(entity.getArea());
        return dto;
    }

    /**
     * метод преобразования объекта в сущность Workout
     * @param dto объект WorkoutDto
     * @return сущность Workout
     */
    default Workout mapToModel(WorkoutDto dto) {
        Workout entity = new Workout();
        if (entity == null) {
            return null;
        }
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setExercise(dto.getExercise());
        entity.setSet(dto.getSet());
        entity.setRepeat(dto.getRepeat());
        entity.setArea(dto.getArea());
        return entity;
    }
}
