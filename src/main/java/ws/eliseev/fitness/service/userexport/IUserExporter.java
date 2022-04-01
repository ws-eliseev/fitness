package ws.eliseev.fitness.service.userexport;

import ws.eliseev.fitness.model.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IUserExporter {
    void exportAllUsers(HttpServletResponse response, List<User> listUsers);
}
