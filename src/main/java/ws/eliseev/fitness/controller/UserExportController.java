package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.service.userexport.IUserExporter;
import ws.eliseev.fitness.service.userexport.UserExportFactory;

import javax.servlet.http.HttpServletResponse;

@Tag(name = "User Export Controller", description = "Сохранение списка пользователей в файл")
@RestController
@RequiredArgsConstructor
public class UserExportController {
    private final UserExportFactory factory;

    @GetMapping("/export")
    public void exportAllUsers(HttpServletResponse response) {
        IUserExporter exporter = factory.getExportFactory("pdf");
        exporter.exportAllUsers(response);
    }
}
