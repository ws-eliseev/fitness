package ws.eliseev.fitness.service.userexport;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
//@RequiredArgsConstructor
public class UserExportFactory {

//    @Qualifier("UserPDFExport")
    private final IUserExporter pdf;
    private final IUserExporter csv;
    private final IUserExporter xlsx;
    private final IUserExporter docx;

    public UserExportFactory(@Qualifier("UserPDFExport") IUserExporter pdf,
                             @Qualifier("UserCSVExport") IUserExporter csv,
                             @Qualifier("UserXLSXExport") IUserExporter xlsx,
                             @Qualifier("UserDOCXExport") IUserExporter docx) {
        this.pdf = pdf;
        this.csv = csv;
        this.xlsx = xlsx;
        this.docx = docx;
    }

    public IUserExporter getExportFactory(String type) throws IOException {
        switch (type) {
            case "pdf": return pdf;
            case "csv": return csv;
            case "xlsx": return xlsx;
            case "docx": return docx;
            default:    throw new IOException("Format not supported");
        }
    }
}
