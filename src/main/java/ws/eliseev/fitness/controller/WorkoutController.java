package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Workout;
import ws.eliseev.fitness.service.WorkoutServiceImpl;

import java.util.List;

@Tag(name = "Workout", description = "CRUD  операции с тренировкой")
@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutServiceImpl workoutService;

    @Autowired
    public WorkoutController(WorkoutServiceImpl workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping(value = "/allworkouts")
    @Operation(summary = "Gets all Workouts", tags = "Получение списка всех тренировок")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка тренировок"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public List<Workout> getAllWorkouts() {
        return workoutService.listWorkout();
    }

    @PostMapping(value = "/allworkouts")
    @Operation(summary = "Create or update Workout", tags = "Создание или изменение тренировки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные о тренировки обновлены"),
            @ApiResponse(responseCode = "201", description = "Успешное создание тренировки"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public void createOrUpdateWorkout(@RequestBody Workout workout) {
        workoutService.saveOrUpdateWorkout(workout);
    }

    @DeleteMapping(value = "/workout/{id}")
    @Operation(summary = "Delete Workout", tags = "Удаление тренировки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные о тренировки удалены"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }

    @GetMapping(value = "/workout/{id}")
    @Operation(summary = "Get Workout by ID", tags = "Поиск тренировки по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение данных"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public void getWorkoutByID(@PathVariable Long id) {
        workoutService.getWorkoutByID(id);
    }
}

