package ws.eliseev.fitness.service.userexport;

import com.lowagie.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service("UserXLSXExport")
public class UserXlsxExporter implements IUserExporter {
    private final Logger logger = LoggerFactory.getLogger("Export logger");
    private XSSFSheet sheet;

    private void writeHeaderLine(XSSFWorkbook workbook) {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Username", style);
        createCell(row, 2, "First Name", style);
        createCell(row, 3, "Last Name", style);
        createCell(row, 4, "Email", style);
        createCell(row, 5, "Phone", style);
        createCell(row, 6, "Age", style);
        createCell(row, 7, "Sex", style);
        createCell(row, 8, "Roles", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(List<UserDto> listUsers, XSSFWorkbook workbook) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (UserDto user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, String.valueOf(user.getId()), style);
            createCell(row, columnCount++, user.getUsername(), style);
            createCell(row, columnCount++, user.getFirstName(), style);
            createCell(row, columnCount++, user.getLastName(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getPhone(), style);
            createCell(row, columnCount++, user.getAge(), style);
            createCell(row, columnCount++, String.valueOf(user.getSex()), style);
            //createCell(row, columnCount, user.getRoles().toString(), style);
        }
    }

    @Override
    public void exportAllUsers(HttpServletResponse response, List<UserDto> listUsers) {
        try (ServletOutputStream outputStream = response.getOutputStream(); XSSFWorkbook workbook = new XSSFWorkbook()) {
            writeHeaderLine(workbook);
            writeDataLines(listUsers, workbook);
            workbook.write(outputStream);
            logger.info("Saved to xlsx...");
        } catch (IOException | DocumentException documentException) {
            logger.error("Error While writing PDF ", documentException);
        }
    }
}
