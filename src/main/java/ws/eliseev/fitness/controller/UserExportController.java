package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.service.IUserService;
import ws.eliseev.fitness.service.userexport.IUserExporter;
import ws.eliseev.fitness.service.userexport.UserExportFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Tag(name = "Export to File", description = "Сохранение списка пользователей в файл; поддержиавются форматы: csv, pdf, xlsx, docx")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/export")

public class UserExportController {
    private final UserExportFactory factory;
    private final IUserService service;
    private final Logger logger = LoggerFactory.getLogger("Export logger");


    @GetMapping("/{filetype}")
    @Operation(summary = "Save all users to file", tags = "Получение списка всех пользователей в файл")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное сохранение списка пользователей"),
            @ApiResponse(responseCode = "400", description = "Данный формат не поддерживается")})

    public void exportAllUsers(HttpServletResponse response, @PathVariable String filetype) {
        List<UserDto> listUsers = service.getAllUser();
        try {
            IUserExporter exporter = factory.getExportFactory(filetype);
            response.setContentType("application/" + filetype + ";charset=UTF-8");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=all_users" + "." + filetype;
            response.setHeader(headerKey, headerValue);
            exporter.exportAllUsers(response, listUsers);
        } catch (IOException wrongFormatException) {
            response.setStatus(400);
            logger.error("Export format not supported!", wrongFormatException);
        }
    }
}
