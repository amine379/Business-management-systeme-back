package ma.baggar.bmsback.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="PaymentMode")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModePayment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(nullable = false,unique = true)
private String name;
	@OneToMany(mappedBy = "modePayment")
	private List<Facture> factures;

	public ModePayment(String name) {
		this.name = name;
	}
}
