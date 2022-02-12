package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.calculators.ICalculator;
import ws.eliseev.fitness.model.calculators.calculatorfactory.UserParametersDto;
import ws.eliseev.fitness.model.calculators.calculatorfactory.CalculatorFactory;

@RestController
@RequestMapping("/calculators")
public class CalculatorController {
    CalculatorFactory calculatorFactory = new CalculatorFactory();

    @GetMapping("")
    public ResponseEntity<Number> calculate(@RequestBody UserParametersDto userParametersDto){
        return ResponseEntity.ok(calculatorFactory.getCalculatorResult(userParametersDto));
    }
}
