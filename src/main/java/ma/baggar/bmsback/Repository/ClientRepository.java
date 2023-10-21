package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
Client findById(long id);
}
