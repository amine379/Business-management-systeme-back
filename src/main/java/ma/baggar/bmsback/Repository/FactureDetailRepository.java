package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.FactureDetail;
@Repository
public interface FactureDetailRepository extends JpaRepository<FactureDetail, Long> {

}
