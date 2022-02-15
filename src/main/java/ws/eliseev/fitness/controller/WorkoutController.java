package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.dto.WorkoutDto;
import ws.eliseev.fitness.service.WorkoutService;

import java.util.List;


/**
 * Контроллеры на CRUD  операции с сущностью Workout
 * @author Корнеев Аркадий
 */
//@Log4j
@Tag(name = "Workout", description = "CRUD  операции с тренировкой")
@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * Контроллер на запрос списка всех Тренировок
     * @return http ответ на исход запроса
     */
    @GetMapping(value = "/")
    @Operation(summary = "Gets all Workouts", tags = "Получение списка всех тренировок")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка тренировок"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts() {
        List<WorkoutDto> dtoList = workoutService.listWorkout();
        if (!dtoList.isEmpty()) {
//            log.info("success received list from database");
            return ResponseEntity.ok(dtoList);
        } else {
//            log.error("entity or dto not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Контроллер на создание или обновление Тренировки
     * @param workout - сущность БД
     */
    @PostMapping(value = "/")
    @Operation(summary = "Create or update Workout", tags = "Создание или изменение тренировки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные о тренировки обновлены"),
            @ApiResponse(responseCode = "201", description = "Успешное создание тренировки"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public void createOrUpdateWorkout(@RequestBody WorkoutDto workout) {
        workoutService.saveOrUpdateWorkout(workout);
    }

    /**
     * Контроллер на удаление сущности Workout по ID
     * @param id - Первичный ключ сущности Workout
     */
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete Workout", tags = "Удаление тренировки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные о тренировки удалены"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkoutByID(id);
    }

    /**
     * Контроллер на получение сущности Workout из БД по параметру ID
     * @param id - Первичный ключ сущности Workout
     * @return http ответ на исход запроса
     */
    @GetMapping(value = "/{id}")
    @Operation(summary = "Get Workout by ID", tags = "Поиск тренировки по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение данных"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден")}
    )
    public ResponseEntity<WorkoutDto> getWorkoutByID(@PathVariable Long id) {
        WorkoutDto dto = workoutService.getWorkoutByID(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

