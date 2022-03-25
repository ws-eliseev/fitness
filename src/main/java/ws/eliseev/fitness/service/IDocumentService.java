package ws.eliseev.fitness.service;

import ws.eliseev.fitness.dto.DocumentDto;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.model.Document;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {

    /**
     * @return Возвращаем список всех Document-ов из базы данных
     */
    List<Document> getAllDocument();

    /**
     * @param document Добавляем/изменяем в базе данных новый документ
     */
    Document saveOrUpdateDocument(Document document);

    /**
     * @param id Получаем Document по id из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<Document> getDocumentById(Long id);

    /**
     * @param author Получаем Document по его автору  из базы данных
     * @return Возвращаем полученного User-a
     */
    Optional<Document> getDocumentByAuthor(String author);

    /**
     * @param id Удаляем Document из базы данных
     */
    void deleteDocumentById(Long id);
}
