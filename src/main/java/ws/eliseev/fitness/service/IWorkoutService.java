package ws.eliseev.fitness.service;

import ws.eliseev.fitness.dto.WorkoutDto;

import java.util.List;

public interface IWorkoutService {

    List<WorkoutDto> listWorkout();

    void saveOrUpdateWorkout(WorkoutDto workout);

    void deleteWorkoutByID(Long id);

    WorkoutDto getWorkoutByID(Long id);
}
