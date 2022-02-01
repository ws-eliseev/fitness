package ws.eliseev.fitness.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.repository.IWorkoutRepository;
import ws.eliseev.fitness.utils.mapper.IWorkoutMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutServiceImpl implements IWorkoutService {

    private IWorkoutRepository workoutRepository;

    private IWorkoutMapper workoutMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WorkoutDto> listWorkout() {
        return workoutRepository.findAll().stream()
                .map(workoutMapper::mapWorkoutToWorkoutDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveOrUpdateWorkout(WorkoutDto workout) {
        workoutRepository.save(workoutMapper.mapWorkoutDtoToEntityWorkout(workout));

    }

    @Override
    @Transactional
    public void deleteWorkoutByID(Long id) {
        workoutRepository.delete(workoutMapper.mapWorkoutDtoToEntityWorkout(getWorkoutByID(id)));

    }

    @Override
    @Transactional(readOnly = true)
    public WorkoutDto getWorkoutByID(Long id) {
        return workoutMapper.mapWorkoutToWorkoutDto(workoutRepository.findById(id).get());
    }
}
