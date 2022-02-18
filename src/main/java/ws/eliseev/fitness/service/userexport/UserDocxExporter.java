package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service("UserDOCXExport")
public class UserDocxExporter implements IUserExporter {
    private final Logger logger = LoggerFactory.getLogger("Export logger");

    private void writeDataLines(List<UserDto> listUsers, XWPFDocument document) {
        XWPFTable table = document.createTable();
        XWPFTableRow tableRowOne = table.getRow(0);

        tableRowOne.getCell(0).setText("ID");
        tableRowOne.addNewTableCell().setText("Username");
        tableRowOne.addNewTableCell().setText("First Name");
        tableRowOne.addNewTableCell().setText("Last Name");
        tableRowOne.addNewTableCell().setText("Email");
        tableRowOne.addNewTableCell().setText("Phone");
        tableRowOne.addNewTableCell().setText("Age");
        tableRowOne.addNewTableCell().setText("Sex");
        //tableRowOne.addNewTableCell().setText("Roles");

        for (UserDto user : listUsers) {
            XWPFTableRow row = table.createRow();
            int columnCount = 0;
            row.getCell(columnCount++).setText(String.valueOf(user.getId()));
            row.getCell(columnCount++).setText(user.getUsername());
            row.getCell(columnCount++).setText(user.getFirstName());
            row.getCell(columnCount++).setText(user.getLastName());
            row.getCell(columnCount++).setText(user.getEmail());
            row.getCell(columnCount++).setText(String.valueOf(user.getPhone()));
            row.getCell(columnCount++).setText(String.valueOf(user.getAge()));
            row.getCell(columnCount++).setText(String.valueOf(user.getSex()));
                //row.getCell(columnCount).setText(user.getRoles().toString());
        }
    }

    @Override
    public void exportAllUsers(HttpServletResponse response, List<UserDto> listUsers) {
        try (ServletOutputStream outputStream = response.getOutputStream(); XWPFDocument document = new XWPFDocument()) {
            writeDataLines(listUsers, document);
            document.write(outputStream);
            logger.info("Saved to docx...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error While writing docx ", documentException);
        }
    }


}

