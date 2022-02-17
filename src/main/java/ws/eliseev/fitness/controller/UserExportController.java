package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserService;
import ws.eliseev.fitness.service.userexport.IUserExporter;
import ws.eliseev.fitness.service.userexport.UserExportFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Tag(name = "Export to File", description = "Сохранение списка пользователей в файл; поддержиавются форматы: csv, pdf, xlsx, docx")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/export")

public class UserExportController {
    private final UserExportFactory factory;
    private final IUserService service;

    @GetMapping("/{filetype}")
    @Operation(summary = "Save all users to file", tags = "Получение списка всех пользователей в файл")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное сохранение списка пользователей"),
            @ApiResponse(responseCode = "500", description = "Данный формат не поддерживается")})

    public void exportAllUsers(HttpServletResponse response, @PathVariable String filetype) {
        List<User> listUsers = service.getAllUser();
        response.setContentType("application/" + filetype + ";charset=UTF-8");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=all_users" + "." + filetype;
        response.setHeader(headerKey, headerValue);

        IUserExporter exporter = factory.getExportFactory(filetype);
        exporter.exportAllUsers(response, listUsers);
    }
}
