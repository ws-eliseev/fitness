package ws.eliseev.fitness.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ws.eliseev.fitness.model.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DocumentServiceTest {

    @Autowired
    private IDocumentService iDocumentService;

    private Document document;

    @BeforeEach
    public void initMethod() {
        document = new Document();
        document.setId(1L);
        document.setDateOfCreation(new Date(12122022));
        document.setLastModified(new Date(04042022));
        document.setDocumentType("отчет");
        document.setContent(new byte[]{1, 2, 3});
        document.setAuthor("Andrey Melnik");
    }


    @Test
    void getAllDocument() {
        List<Document> list = new ArrayList<>();
        iDocumentService.saveOrUpdateDocument(document);
        list.add(document);

        Optional<List<Document>> optionalFoundedListDocument = ofNullable(iDocumentService.getAllDocument());
        optionalFoundedListDocument.ifPresent(messages -> assertEquals(list, optionalFoundedListDocument.get(), "Document not equals"));

    }

    @Test
    void saveOrUpdateDocument() {

        Optional<Document> createdDocument = Optional.ofNullable(iDocumentService.saveOrUpdateDocument(document));
        createdDocument.ifPresent(message -> assertEquals(document, createdDocument.get(), "document not equals"));

    }

    @Test
    void getDocumentById() {

        iDocumentService.saveOrUpdateDocument(document);
        Optional<Document> documentById = ofNullable(iDocumentService.getDocumentById(document.getId()).get());
        documentById.ifPresent(message -> assertEquals(document, documentById.get()));

    }

    @Test
    void deleteDocumentById() {

        iDocumentService.saveOrUpdateDocument(document);
        iDocumentService.deleteDocumentById(document.getId());
        assertEquals(Optional.empty(), iDocumentService.getDocumentById(document.getId()));

    }
}