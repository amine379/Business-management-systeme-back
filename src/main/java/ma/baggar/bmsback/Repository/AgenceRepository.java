package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Agence;
@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer>{

}
