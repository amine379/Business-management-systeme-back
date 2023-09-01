package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.PaymentReception;
@Repository
public interface PaymentReceptionRepository extends JpaRepository<PaymentReception, Long> {

}
