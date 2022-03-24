package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Mail;

@Repository
public interface IMailRepository extends JpaRepository<Mail, Long> {

}
