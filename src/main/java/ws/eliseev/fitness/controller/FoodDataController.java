package ws.eliseev.fitness.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/fdc")
@Tag(name = "FDC", description = "API для получения продуктов и их описания (калорийности)")
@Log4j2
@RequiredArgsConstructor
public class FoodDataController {

    private static final String URL = "https://api.nal.usda.gov/fdc/v1";
    private static final String APIKEY = "DEMO_KEY";

    private final WebClient webClient = WebClient.builder().baseUrl(URL).build();

    /**
     * Метод, позволяющий получить продукт по Id.
     *
     * @param fdcId Идентификатор продукта.
     * @return Json.
     */
    @Operation(summary = "Получение продукта по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукт успешно получен"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукт не найден")})
    @GetMapping("/food/{fdcId}")
    public ResponseEntity<JsonNode> getFoodById(@PathVariable("fdcId") Long fdcId) {
        log.info("Get food with fdcId: {}", fdcId);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/food/")
                        .path(fdcId.toString())
                        .queryParam("api_key", APIKEY)
                        .build())
                .retrieve()
                .toEntity(JsonNode.class)
                .block();
    }
}
