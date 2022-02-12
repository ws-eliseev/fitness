package ws.eliseev.fitness.service.userexport;

import javax.servlet.http.HttpServletResponse;

public interface IUserExporter {
    void exportAllUsers(HttpServletResponse response);
}
