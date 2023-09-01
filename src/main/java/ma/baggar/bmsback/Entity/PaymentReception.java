package ma.baggar.bmsback.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class PaymentReception {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date paymentDate;
private Boolean situationPayment;
private String modePayment;
@OneToOne
private Reception reception;
}
