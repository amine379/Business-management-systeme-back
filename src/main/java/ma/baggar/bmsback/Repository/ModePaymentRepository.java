package ma.baggar.bmsback.Repository;

import ma.baggar.bmsback.Entity.ModePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModePaymentRepository extends JpaRepository<ModePayment,Integer> {

}
