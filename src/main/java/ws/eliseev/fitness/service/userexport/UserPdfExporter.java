package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
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
@Service("UserPDFExport")
public class UserPdfExporter implements IUserExporter {
    private final IUserService service;
    private final Logger logger = LoggerFactory.getLogger("Export logger");

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(Color.BLUE);
//        cell.setPadding(8);
//
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        font.setColor(Color.WHITE);

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
    }

    private void writeTableData(PdfPTable table) {
        List<User> listUsers = service.getAllUser();
        for (User user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getUsername());
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getEmail());
            table.addCell(user.getPhone());
            table.addCell(String.valueOf(user.getAge()));
            table.addCell(String.valueOf(user.getSex()));
        }
    }

    @Override
    public void exportAllUsers(HttpServletResponse response) {
        try (Document document = new Document(PageSize.A4)) {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);

            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
//            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//            font.setSize(18);
//            font.setColor(Color.BLUE);

            Paragraph p = new Paragraph("List of Users");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100f);
            table.setWidths(new float[]{1.1f, 2.5f, 3.0f, 3.0f, 5f, 3.5f, 1.3f, 2.2f});
            //table.setSpacingBefore(5);

            writeTableHeader(table);
            writeTableData(table);
            document.add(table);
            logger.info("Saved to PDF...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error While writing PDF ", documentException);
        }
    }
}
