package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Workout;

import java.util.List;

public interface WorkoutService {

    List<Workout> listWorkout();

    void saveOrUpdateWorkout(Workout workout);

    void deleteWorkout(Long id);

    Workout getWorkoutByID(Long id);
}
