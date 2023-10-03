package ma.baggar.bmsback.Entity;



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
	private Double Remise;
	@Column(nullable = true)
	private String Remarque;
	@Column(unique = true)
	private String factureRef;
	@Column(nullable = true)
	private Double fret;
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
	
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name="Reception-articles",
//	joinColumns=@JoinColumn(name="reception_id"),
//	inverseJoinColumns=@JoinColumn(name="article_id"))
//	private List<Article> articles;
//	@Column(nullable = false)
//	private List<Double> quantite=new ArrayList<>();
}
