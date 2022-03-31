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
import ws.eliseev.fitness.model.Address;
import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.service.AddressService;
import ws.eliseev.fitness.service.DocumentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Address", description = "Address API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    /**
     * Получает список всех адресов
     */
    @Operation(summary = "Gets all address", tags = "address")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all address"
            )
    })
    @GetMapping()
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    /**
     * Получает адрес по ID
     *
     * @param id - Идентификационный номер адреса в БД
     */
    @Operation(summary = "Gets address by ID", tags = "address")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found address by ID"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> getAddresstById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    /**

    /**
     * Сохраняет или обновляет aдресс в базе данных
     *
     * @param address - Основной Entity address
     */
    @Operation(summary = "Saves address", tags = "address")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved address"
            )
    })
    @PostMapping()
    public ResponseEntity<Address> saveOrUpdateDocument(@Valid @RequestBody Address address) {
        return ResponseEntity.ok(addressService.saveOrUpdateAddress(address));

    }

    /**
     * Удаляет адрес из БД по ID
     *
     * @param id - Идентификационный номер адреса в БД
     */
    @Operation(summary = "Deletes address by ID", tags = "address")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted address")
    })
    @DeleteMapping("/{id}")
    public String deleteAddressById(@PathVariable("id") Long id) {
        addressService.deleteAddressById(id);
        return "Address deleted. (OK)";
    }

}
