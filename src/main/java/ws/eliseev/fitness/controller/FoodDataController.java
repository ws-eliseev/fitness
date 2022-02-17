package ws.eliseev.fitness.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/fdc")
@RequiredArgsConstructor
public class FoodDataController {

    private static final String URL = "https://api.nal.usda.gov/fdc/v1";
    private static final String APIKEY = "DEMO_KEY";

    private final WebClient webClient = WebClient.builder().baseUrl(URL).build();

    @GetMapping("/food/{fdcId}")
    public ResponseEntity<JsonNode> getFoodById(@PathVariable("fdcId") Long fdcId) {
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
