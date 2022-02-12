package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.service.IUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service("UserCSVExport")
public class UserCsvExporter implements IUserExporter {
    private final IUserService service;
    private final Logger logger = LoggerFactory.getLogger("Export logger");

    @Override
    public void exportAllUsers(HttpServletResponse response) {
        List<User> listUsers = service.getAllUser();
        try (CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT)) {
            response.setContentType("text/csv");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
            response.setHeader(headerKey, headerValue);
            csvPrinter.printRecord("ID","Username","First Name","Last Name","E-mail","Phone","Age","Sex");
            for (User user : listUsers) {
                csvPrinter.printRecord(
                        String.valueOf(user.getId()),
                        user.getUsername(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPhone(),
                        String.valueOf(user.getAge()),
                        String.valueOf(user.getSex()));
            }
            logger.info("Saved to csv...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error while writing csv ", documentException);
        }
    }
}

