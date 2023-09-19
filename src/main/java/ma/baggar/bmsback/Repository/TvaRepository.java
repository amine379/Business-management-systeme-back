package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.TvaEntity;
@Repository
public interface TvaRepository extends JpaRepository<TvaEntity, Integer> {
	TvaEntity findByCode(String code);
	TvaEntity findByValue(Double value);

}
