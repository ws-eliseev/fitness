package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service("UserCSVExport")
public class UserCsvExporter implements IUserExporter {
    private final Logger logger = LoggerFactory.getLogger("Export logger");

    @Override
    public void exportAllUsers(HttpServletResponse response, List<UserDto> listUsers) {
        try (CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID","Username","First Name","Last Name","E-mail","Phone","Age","Sex","Roles");
            for (UserDto user : listUsers) {
                csvPrinter.printRecord(
                        String.valueOf(user.getId()),
                        user.getUsername(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPhone(),
                        String.valueOf(user.getAge()),
                        String.valueOf(user.getSex()));
                        //user.getRoles());

            }
            logger.info("Saved to csv...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error while writing csv ", documentException);
        }
    }
}

