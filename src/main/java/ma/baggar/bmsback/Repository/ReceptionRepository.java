package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Reception;
@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Long> {

}
