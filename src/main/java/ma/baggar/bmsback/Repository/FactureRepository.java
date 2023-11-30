package ma.baggar.bmsback.Repository;

import ma.baggar.bmsback.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Facture;

import java.util.Date;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
Facture findById(long id);
List<Facture> findByClient(Client client);
Facture findByReferance(String referance);
List<Facture> findByDateFacture(Date dateFacture);
}
