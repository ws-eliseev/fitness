package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Address;


@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
