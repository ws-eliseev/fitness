package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.calculators.ICalculator;
import ws.eliseev.fitness.model.calculators.UserParametersDto;
import ws.eliseev.fitness.model.calculators.calculatorfactory.CalculatorFactory;

@RestController
@RequestMapping("/calculators")
public class CalculatorController {
    CalculatorFactory calculatorFactory = new CalculatorFactory();

    @GetMapping("/calories/harris")
    public ResponseEntity<Integer> calculateCaloriesHarris(@RequestBody UserParametersDto calorieDto){
        ICalculator harrisCalculator = calculatorFactory.getHarrisCalculator();
        return ResponseEntity.ok(harrisCalculator.calculate(calorieDto));
    }
    @GetMapping("/calories/mifflin")
    public ResponseEntity<Integer> calculateCaloriesMifflin(@RequestBody UserParametersDto calorieDto){
        ICalculator mifflinCalculator =  calculatorFactory.getMifflinCalculator();
        return ResponseEntity.ok(mifflinCalculator.calculate(calorieDto));
    }
}
