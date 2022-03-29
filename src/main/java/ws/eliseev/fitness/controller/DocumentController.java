package ws.eliseev.fitness.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.service.DocumentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Document", description = "Document API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    /**
     * Получает список всех документов
     */
    @Operation(summary = "Gets all documents", tags = "documents")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Got all documents"
            )
    })
    @GetMapping()
    public ResponseEntity<List<Document>> getAllDocument() {
        return ResponseEntity.ok(documentService.getAllDocument());
    }

    /**
     * Получает документ по ID
     *
     * @param id - Идентификационный номер документа в БД
     */
    @Operation(summary = "Gets document by ID", tags = "document")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found document by ID"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Document>> getDocumentById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    /**
     * Получает документ по  Author
     *
     * @param author - Автор документа в БД
     */
    @Operation(summary = "Gets document by Author", tags = "document")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found document by Author"
            )
    })
    @GetMapping("/{author}")
    public ResponseEntity<Optional<Document>> getDocumentById(@PathVariable("Author") String author) {
        return ResponseEntity.ok(documentService.getDocumentByAuthor(author));
    }

    /**
     * Сохраняет или обновляет документ в базе данных
     *
     * @param document - Основной Entity document
     */
    @Operation(summary = "Saves document", tags = "document")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Saved document"
            )
    })
    @PostMapping()
    public ResponseEntity<Document> saveOrUpdateDocument(@Valid @RequestBody Document document) {
        return ResponseEntity.ok(documentService.saveOrUpdateDocument(document));

    }

    /**
     * Удаляет документ из БД по ID
     *
     * @param id - Идентификационный номер документа в БД
     */
    @Operation(summary = "Deletes document by ID", tags = "document")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleted document")
    })
    @DeleteMapping("/{id}")
    public String deleteDocumentById(@PathVariable("id") Long id) {
        documentService.deleteDocumentById(id);
        return "Document deleted. (OK)";
    }
}
