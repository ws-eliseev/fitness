package ws.eliseev.fitness.service.userexport;

import ws.eliseev.fitness.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IUserExporter {
    void exportAllUsers(HttpServletResponse response, List<UserDto> listUsers);
}
