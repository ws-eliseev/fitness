package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.eliseev.fitness.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
