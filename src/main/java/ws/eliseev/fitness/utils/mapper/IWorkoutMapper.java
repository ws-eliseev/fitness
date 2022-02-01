package ws.eliseev.fitness.utils.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.model.Workout;

@Mapper(componentModel = "spring")
public interface IWorkoutMapper {

    WorkoutDto mapWorkoutToWorkoutDto (Workout entity);

    Workout mapWorkoutDtoToEntityWorkout (WorkoutDto dto);

//    public WorkoutDto mapToDto(Workout entity) {
//        WorkoutDto dto = new WorkoutDto();
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        dto.setExercise(entity.getExercise());
//        dto.setSet(entity.getSet());
//        dto.setRepeat(entity.getRepeat());
//        dto.setArea(entity.getArea());
//        return dto;
//    }
//
//    public Workout mapToEntity(WorkoutDto dto) {
//        Workout entity = new Workout();
//        entity.setId(dto.getId());
//        entity.setName(dto.getName());
//        entity.setExercise(dto.getExercise());
//        entity.setSet(dto.getSet());
//        entity.setRepeat(dto.getRepeat());
//        entity.setArea(dto.getArea());
//        return entity;
//    }
}
