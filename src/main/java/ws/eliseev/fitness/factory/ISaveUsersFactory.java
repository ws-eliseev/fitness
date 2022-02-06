package ws.eliseev.fitness.factory;

import ws.eliseev.fitness.service.ISaveUsersToFileService;

public interface ISaveUsersFactory {

    ISaveUsersToFileService saveUsersToFile();

}
