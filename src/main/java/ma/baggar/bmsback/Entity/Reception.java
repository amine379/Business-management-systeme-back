package ma.baggar.bmsback.Entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	@Column(nullable = false)
	private List<Double> prixTtc=new ArrayList<>();
	@Column(nullable = true)
	private Double Remise;
	@Column(nullable = true)
	private String Remarque;
	@Column(nullable = true)
	private Double fret;
	@Column(nullable = false)
	private List<Double> quantite=new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "agence_id",nullable = false)
	private Agence agence;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Reception-articles",
	joinColumns=@JoinColumn(name="reception_id"),
	inverseJoinColumns=@JoinColumn(name="article_id"))
	private List<Article> articles;
	@ManyToOne
	@JoinColumn(name="fournisseur_id",nullable = false)
	private Fournisseur fournisseur;
	////c est a modifier la /***************/*/***************/*/*-
	@OneToOne
	private PaymentReception paymentReception;
}
