package ws.eliseev.fitness.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.model.Passport;
import ws.eliseev.fitness.service.DocumentService;
import ws.eliseev.fitness.service.PassportService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Passport", description = "Passport API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/passports")
public class PassportController {

    private final PassportService passportService;

    /**
     * Получает список всех паспортов
     */
    @Operation(summary = "Gets all passports", tags = "passports")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all passports"
            )
    })
    @GetMapping()
    public ResponseEntity<List<Passport>> getAllPassport() {
        return ResponseEntity.ok(passportService.getAllPassport());
    }

    /**
     * Получает паспорт по ID
     *
     * @param id - Идентификационный номер паспорта в БД
     */
    @Operation(summary = "Gets passport by ID", tags = "passport")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found passport by ID"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Passport>> getPassportById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(passportService.getPassportById(id));
    }



    /**
     * Сохраняет или обновляет паспорт в базе данных
     *
     * @param passport - Основной Entity passport
     */
    @Operation(summary = "Saves passport", tags = "passport")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved passport"
            )
    })
    @PostMapping()
    public ResponseEntity<Passport> saveOrUpdatePassport(@Valid @RequestBody Passport passport) {
        return ResponseEntity.ok(passportService.saveOrUpdatePassport(passport));

    }

    /**
     * Удаляет паспорт из БД по ID
     *
     * @param id - Идентификационный номер паспорта в БД
     */
    @Operation(summary = "Deletes passport by ID", tags = "passport")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted passport")
    })
    @DeleteMapping("/{id}")
    public String deletePassportById(@PathVariable("id") Long id) {
        passportService.deletePassportById(id);
        return "Passport deleted. (OK)";
    }
}
