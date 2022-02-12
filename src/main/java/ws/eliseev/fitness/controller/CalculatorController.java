package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.calculators.calculatorfactory.CalculatorFactory;
import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;

@RestController
@RequestMapping("/calculators")
public class CalculatorController {
    CalculatorFactory calculatorFactory = new CalculatorFactory();

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
