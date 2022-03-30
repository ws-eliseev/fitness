package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.calculators.calculatorfactory.CalculatorFactory;
import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;

@Tag(name = "Calculator",
        description = "Calculator API; Вы можете использовать следующие параметры и типы " +
                "калькуляторов для проверок: Калькуляторы: HARRISON, MIFFLIN, WEIGHT_LOSS Параметры: 1) activity (активность юзера), " +
                "возможные варианты - SEDENTARY(1.2) - сидячий образ жизни, LIGHTLY(1.375) - легкая активность, " +
                "MODERATELY_ACTIVE(1.55) - средняя активность, VERY_ACTIVE(1.725) - высокая активность, " +
                "EXTRA_ACTIVE(1.9) - очень высокая активность; 2) WeightLossOrGain(потеря или набор веса " +
                "для калькулятора WEIGHT_LOSS) SMALL_LOSS(0.85) - низкая потеря веса, MEDIUM_LOSS(0.80) - средняя потеря веса, " +
                "LARGE_LOSS(0.75) - высокая потеря веса, SMALL_GAIN(1.10) - низкий набор веса, " +
                "MEDIUM_GAIN(1.15) - средний набор веса, LARGE_GAIN(1.20) - высокий набор веса;")

@RestController
@RequestMapping("/calculators")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorFactory calculatorFactory;

    /**
     * @param userParametersDto - DTO параметров пользователя для вычислений
     * @return - возращает числовой результат вычислений
     */
    @Operation(summary = "Calculates result", tags = "calculator")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got calculation result"
            )
    })
    @GetMapping("")
    public ResponseEntity<Number> calculate(@RequestBody UserParametersDto userParametersDto) {
        return ResponseEntity.ok(calculatorFactory.getCalculatorResult(userParametersDto));
    }
}
