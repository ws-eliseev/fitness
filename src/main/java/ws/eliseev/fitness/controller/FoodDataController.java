package ws.eliseev.fitness.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/fdc")
// Дополнительную документацию можно найти по ссылке -> https://fdc.nal.usda.gov/api-guide.html
@Tag(name = "FDC", description = "API для получения продуктов и их описания (калорийности)")
@Log4j2
@RequiredArgsConstructor
public class FoodDataController {

    private static final String URL = "https://api.nal.usda.gov/fdc/v1";
    private static final String AK = "api_key";
    private static final String APIKEY = "DEMO_KEY";
    private static final Integer MAX_IN_MEMORY_SIZE = 500 * 1024;

    private final WebClient webClient = WebClient
            .builder()
            .codecs(clientCodecConfigurer -> clientCodecConfigurer
                    .defaultCodecs()
                    .maxInMemorySize(MAX_IN_MEMORY_SIZE))
            .baseUrl(URL)
            .build();

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
                        .queryParam(AK, APIKEY)
                        .build())
                .retrieve()
                .toEntity(JsonNode.class)
                .block();
    }

    /**
     * Метод, позволяющий получить информацию о нескольких продуктах питания,
     * используя входные идентификаторы FDC.
     *
     * @param fdcIds коллекция, в которой хранятся идентификаторы.
     * @return Json.
     */
    @Operation(summary = "Получение нескольких продуктов по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукты успешно получены"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукты не найдены")})
    @GetMapping("/foods")
    public ResponseEntity<JsonNode> getFoodsByIds(@RequestParam("fdcIds") List<String> fdcIds) {
        log.info("Get food with fdcIds: {}", fdcIds);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/foods/")
                        .queryParam("fdcIds", fdcIds)
                        .queryParam(AK, APIKEY)
                        .build())
                .retrieve()
                .toEntity(JsonNode.class)
                .block();
    }

    /**
     * Метод, возвращающий постраничный список продуктов в «сокращенном» формате.
     *
     * @param dataType   Фильтровать по определенному типу данных; укажите одно или несколько значений в массиве.
     * @param pageSize   Максимальное количество результатов для текущей страницы. По умолчанию 50.
     * @param pageNumber Номер страницы для получения. Смещение в общем наборе результатов выражается как
     *                   (номер страницы * размер страницы)
     * @param sortBy     Укажите одно из возможных значений для сортировки по этому полю.
     *                   Обратите внимание, что dataType.keyword будет dataType,
     *                   а lowercaseDescription.keyword будет описанием в будущих выпусках.
     * @param sortOrder  Направление сортировки результатов. Применимо, только если указан sortBy.
     * @return Json.
     */
    @Operation(summary = "Получение постраничного списка продуктов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукты успешно получены"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукты не найдены")})
    @GetMapping("/foods/list")
    public ResponseEntity<JsonNode> getFoodsAsList(
            @RequestParam(value = "dataType", required = false) List<String> dataType,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "sortOrder", required = false) String sortOrder) {
        log.info("Get food list");
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/foods/list/")
                        .queryParam("dataType", dataType)
                        .queryParam("pageSize", pageSize)
                        .queryParam("pageNumber", pageNumber)
                        .queryParam("sortBy", sortBy)
                        .queryParam("sortOrder", sortOrder)
                        .queryParam(AK, APIKEY)
                        .build())
                .retrieve()
                .toEntity(JsonNode.class)
                .block();
    }

    /**
     * Метод, позволяющий произвести поиск продуктов по ключевым словам.
     * Результаты могут быть отфильтрованы по типу данных,
     * и есть варианты размеров страницы результатов или сортировки.
     *
     * @param query      Одно или несколько условий поиска.
     * @param dataType   Фильтровать по определенному типу данных; укажите одно или несколько значений в массиве.
     * @param pageSize   Максимальное количество результатов для текущей страницы. По умолчанию 50.
     * @param pageNumber Номер страницы для получения. Смещение в общем наборе результатов выражается как
     *                   (номер страницы * размер страницы)
     * @param sortBy     Укажите одно из возможных значений для сортировки по этому полю.
     * @param sortOrder  Направление сортировки результатов. Применимо, только если указан sortBy.
     * @param brandOwner Отфильтруйте результаты по владельцу бренда продуктов питания.
     *                   Применяется только к фирменным продуктам
     * @return Json.
     */
    @Operation(summary = "Получение списка продуктов, соответствующих ключевым словам")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукты успешно получены"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукты не найдены")})
    @GetMapping("/foods/search")
    public ResponseEntity<JsonNode> getFoodsFromSearch(
            @RequestParam(value = "query") String query,
            @RequestParam(value = "dataType", required = false) List<String> dataType,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "sortOrder", required = false) String sortOrder,
            @RequestParam(value = "brandOwner", required = false) String brandOwner) {
        log.info("Get food list from search");
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/foods/list/")
                        .queryParam("query", query)
                        .queryParam("dataType", dataType)
                        .queryParam("pageSize", pageSize)
                        .queryParam("pageNumber", pageNumber)
                        .queryParam("sortBy", sortBy)
                        .queryParam("sortOrder", sortOrder)
                        .queryParam("brandOwner", brandOwner)
                        .queryParam(AK, APIKEY)
                        .build())
                .retrieve()
                .toEntity(JsonNode.class)
                .block();
    }
}
