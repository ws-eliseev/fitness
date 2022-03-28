package ws.eliseev.fitness.service;


import ws.eliseev.fitness.model.Document;
import ws.eliseev.fitness.model.Recipe;
import ws.eliseev.fitness.repository.IDocumentRepository;

import java.util.List;
import java.util.Optional;


public class DocumentService implements IDocumentService {

    private final IDocumentRepository iDocumentRepository;

    public DocumentService(IDocumentRepository iDocumentRepository) {
        this.iDocumentRepository = iDocumentRepository;
    }

    @Override
    public List<Document> getAllDocument() {
        return iDocumentRepository.findAll();
    }

    @Override
    public Document saveOrUpdateDocument(Document document) {
     return  iDocumentRepository.save(document);
    }

    @Override
    public Optional<Document> getDocumentById(Long id) {
        return iDocumentRepository.findById(id);
    }


    @Override
    public Optional<Document> getDocumentByAuthor(String author) {
        return iDocumentRepository.findByAuthor(author);
    }

    @Override
    public void deleteDocumentById(Long id) {
        iDocumentRepository.deleteById(id);

    }
}
