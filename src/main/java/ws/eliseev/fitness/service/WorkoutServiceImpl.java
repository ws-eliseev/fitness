package ws.eliseev.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.model.Workout;
import ws.eliseev.fitness.repository.WorkoutRepository;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Workout> listWorkout() {
        return workoutRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOrUpdateWorkout(Workout workout) {
        workoutRepository.save(workout);

    }

    @Override
    @Transactional
    public void deleteWorkout(Long id) {
        workoutRepository.delete(getWorkoutByID(id));

    }

    @Override
    @Transactional(readOnly = true)
    public Workout getWorkoutByID(Long id) {
        return workoutRepository.findById(id).get();
    }
}
