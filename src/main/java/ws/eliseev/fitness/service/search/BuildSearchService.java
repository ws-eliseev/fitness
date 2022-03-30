package ws.eliseev.fitness.service.search;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
class BuildSearchService implements ApplicationListener<ApplicationEvent> {
        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public void onApplicationEvent(@NonNull ApplicationEvent event) {
                try {
                        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
                        fullTextEntityManager.createIndexer().startAndWait();
                } catch(InterruptedException e){
                        System.out.println("An error occurred trying to build the search index: " + e);
                }
        }
}

