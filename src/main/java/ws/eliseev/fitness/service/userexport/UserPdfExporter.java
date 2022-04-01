package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service("UserPDFExport")
public class UserPdfExporter implements IUserExporter {
    private final Logger logger = LoggerFactory.getLogger("Export logger");

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase("ID"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Username"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("First Name"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Last Name"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("E-mail"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Phone"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Age"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Sex"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Passport"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Address"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Photo"));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table, List<User> listUsers) {
        for (User user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUsername());
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getEmail());
            table.addCell(user.getPhone());
            table.addCell(String.valueOf(user.getAge()));
            table.addCell(String.valueOf(user.getSex()));
            table.addCell(String.valueOf(user.getPassport()));
            table.addCell(String.valueOf(user.getAddress()));
            table.addCell(String.valueOf(user.getPhoto()));
        }
    }

    @Override
    public void exportAllUsers(HttpServletResponse response, List<User> listUsers) {
        try (Document document = new Document(PageSize.A4)) {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            PdfPTable table = new PdfPTable(11);
            table.setWidthPercentage(100f);
            table.setWidths(new float[]{1.1f, 2.5f, 3.0f, 3.0f, 3.0f, 3.5f, 1.3f, 2.2f, 4.0f, 3.0f, 3.0f});
            writeTableHeader(table);
            writeTableData(table, listUsers);
            document.add(table);
            logger.info("Saved to PDF...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error While writing PDF ", documentException);
        }
    }
}
