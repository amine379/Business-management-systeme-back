package ma.baggar.bmsback.Entity;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Reception")
public class Reception {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column(nullable = false)
	private Date dateDoc;
	private Date dateEcheance;
	@Column(name = "Toatal-HT" ,nullable = false)
	private Double totalHt;
	@Column(name = "total-TTC" ,nullable = false)
	private Double totalTtc;
	@Column(nullable = true)
	private BigDecimal remise;
	@Column(nullable = true)
	private String Remarque;
	@Column(unique = true)
	private String factureRef;
	@Column(nullable = true)
	private BigDecimal fret;
	@ManyToOne
	@JoinColumn(name = "agence_id",nullable = false)
	private Agence agence;
	@ManyToOne
	@JoinColumn(name="fournisseur_id",nullable = false)
	private Fournisseur fournisseur;
	////c est a modifier la /***************/*/***************/*/*-
	@OneToOne
	private PaymentReception paymentReception;
	@OneToMany
	private List<ReceptionDetail> receptionDetails;


}
