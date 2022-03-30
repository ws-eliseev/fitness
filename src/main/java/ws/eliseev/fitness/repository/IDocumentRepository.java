package ws.eliseev.fitness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Document;

import java.util.Optional;


@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long> {
    /**
     * Найти документ по автору
     *
     * @param author - название рецепта
     */
    Optional<Document> findByAuthor(String author);
}
