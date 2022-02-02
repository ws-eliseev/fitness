package ws.eliseev.fitness;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Use http://localhost:8082/swagger-ui/index.html to open UI
// or http://localhost:8082/v3/api-docs.yaml to generate YAML file
// you can also use http://localhost:8082/v3/api-docs without .yaml to open docs in browser
@OpenAPIDefinition(info = @Info(title = "FITNESS API", version = "IN DEV", description = "Fitness App"))
public class FitnessApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);

    }
}