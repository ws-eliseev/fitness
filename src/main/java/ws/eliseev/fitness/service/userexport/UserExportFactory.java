package ws.eliseev.fitness.service.userexport;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
//@RequiredArgsConstructor
public class UserExportFactory {

//    @Qualifier("UserPDFExport")
    private final IUserExporter pdf;
//    @Qualifier("UserCSVExport")
    private final IUserExporter csv;

    public UserExportFactory(@Qualifier("UserPDFExport") IUserExporter pdf, @Qualifier("UserCSVExport")IUserExporter csv) {
        this.pdf = pdf;
        this.csv = csv;
    }

    public IUserExporter getExportFactory(String type) {
        switch (type) {
            case "pdf": return pdf;
            case "csv": return csv;
            default:    return null;
        }
    }
}
