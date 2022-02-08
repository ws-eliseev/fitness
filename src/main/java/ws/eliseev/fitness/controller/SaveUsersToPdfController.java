package ws.eliseev.fitness.controller;

import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import ws.eliseev.fitness.service.savetofile.SaveUsersToPdf;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveUsersToPdfController {
    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);


        SaveUsersToPdf exporter = new SaveUsersToPdf();
        exporter.exportToPdf(response);

    }
}
