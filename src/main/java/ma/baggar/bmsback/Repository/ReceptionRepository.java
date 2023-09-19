package ma.baggar.bmsback.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.Reception;
@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Long> {
List<Reception> findByFournisseur(Fournisseur fournisseur);
List<Reception> findByDateDoc(Date datedoc);
List<Reception> findByTotalTtc(Double prixTTC);

}
