package ws.eliseev.fitness;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Используйте ссылку http://localhost:8082/swagger-ui/index.html чтобы открыть UI
// или http://localhost:8082/v3/api-docs.yaml чтобы сгенерировать YAML файл и сохранить на пк
// также можно использовать http://localhost:8082/v3/api-docs без .yaml чтобы открыть доки в браузере
@OpenAPIDefinition(info = @Info(title = "FITNESS API", version = "IN DEV", description = "Fitness App"))
public class FitnessApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);
    }

}