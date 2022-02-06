package ws.eliseev.fitness.service.savetofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.service.ISaveUsersToFileService;

@Service
public class SaveUsersToDocx implements ISaveUsersToFileService {

    private final Logger logger = LoggerFactory.getLogger("SaveToFileLogger");

    @Override
    public void saveUserToFileService() {
        logger.info("Saving to docx...");
    }
}