package ws.eliseev.fitness.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.repository.IWorkoutRepository;
import ws.eliseev.fitness.util.mapper.IWorkoutMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService implements IWorkoutService {

    private final IWorkoutRepository workoutRepository;

    private final IWorkoutMapper workoutMapper;

    public WorkoutService(IWorkoutRepository workoutRepository, IWorkoutMapper workoutMapper) {
        this.workoutRepository = workoutRepository;
        this.workoutMapper = workoutMapper;
    }

    @Transactional(readOnly = true)
    public List<WorkoutDto> listWorkout() {
        return workoutRepository.findAll().stream()
                .map(workoutMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void saveOrUpdateWorkout(WorkoutDto workout) {
        workoutRepository.save(workoutMapper.mapToModel(workout));

    }

    @Override
    @Transactional
    public void deleteWorkoutByID(Long id) {
        workoutRepository.delete(workoutMapper.mapToModel(getWorkoutByID(id)));

    }

    @Override
    @Transactional(readOnly = true)
    public WorkoutDto getWorkoutByID(Long id) {
        return workoutMapper.mapToDto(workoutRepository.findById(id).get());
    }
}
