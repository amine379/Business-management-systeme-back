package ma.baggar.bmsback.Entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "Fournisseur")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

	@Column(unique = true,nullable = false)
	private String nom;
	@Column(unique = true,nullable = true)
	private Long ice;
	@Column(nullable = true)
	private Boolean situation=true;
	@Column(nullable = true)
	private String adress;
	@Column(nullable = true)
	private Double telephone;
	@Column(nullable = true)
	private Double resteaPayer;
	@ManyToMany(mappedBy = "fournisseur",fetch = FetchType.EAGER)
	private List<Article> articles;
	@OneToMany(mappedBy = "fournisseur",cascade = CascadeType.ALL)
	private List<Reception> receptions;
	@Column(nullable =true)
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          })
	@JoinTable(name = "agence_fournisseurs",
	joinColumns=@JoinColumn(name="fournisseur_id"),
	inverseJoinColumns=@JoinColumn(name="agence_id"))
	private List<Agence> agences;

}
