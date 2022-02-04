package ws.eliseev.fitness.utils.mapper;

import org.mapstruct.Mapper;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.model.Workout;

@Mapper(componentModel = "spring")
public interface IWorkoutMapper {

//    default Workout toModel(WorkoutDto workoutDto) {
//        if (workoutDto == null) {
//            return null;
//        }
//
//        return Workout.builder()
//                .id(workoutDto.getId())
//                .name(workoutDto.getName())
//                .exercise(workoutDto.getExercise())
//                .set(workoutDto.getSet())
//                .repeat(workoutDto.getRepeat())
//                .area(workoutDto.getArea())
//                .build();
//    }
//
//    default WorkoutDto toDto(Workout workout) {
//        WorkoutDto workoutDto = new WorkoutDto();
//        if (workout == null) {
//            return null;
//        }
//        workoutDto.setId(workout.getId());
//        workoutDto.setName(workout.getName());
//        workoutDto.setExercise(workoutDto.getExercise());
//        workoutDto.setSet(workoutDto.getSet());
//        workoutDto.setRepeat(workoutDto.getRepeat());
//        workoutDto.setArea(workout.getArea());
//
//        return workoutDto;
//    }

//    IWorkoutMapper INSTANCE = Mappers.getMapper( IWorkoutMapper.class );

//    WorkoutDto mapWorkoutToWorkoutDto (Workout entity);

//    Workout mapWorkoutDtoToEntityWorkout (WorkoutDto dto);

    default WorkoutDto mapToDto(Workout entity) {
        WorkoutDto dto = new WorkoutDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setExercise(entity.getExercise());
        dto.setSet(entity.getSet());
        dto.setRepeat(entity.getRepeat());
        dto.setArea(entity.getArea());
        return dto;
    }

    default Workout mapToModel(WorkoutDto dto) {
        Workout entity = new Workout();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setExercise(dto.getExercise());
        entity.setSet(dto.getSet());
        entity.setRepeat(dto.getRepeat());
        entity.setArea(dto.getArea());
        return entity;
    }
}
