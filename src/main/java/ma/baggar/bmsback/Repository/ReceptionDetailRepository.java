package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.ReceptionDetail;

@Repository
public interface ReceptionDetailRepository extends JpaRepository<ReceptionDetail, Long>{

}
