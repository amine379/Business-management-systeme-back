package ma.baggar.bmsback.Entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Table(name="Agence")
public class Agence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

	@Column(nullable = false,unique=true)
private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "agence_fournisseurs",
	joinColumns=@JoinColumn(name="agence_id"),
	inverseJoinColumns=@JoinColumn(name="fournisseur_id"))
private List<Fournisseur> fournisseur;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Agence-articles",
	joinColumns=@JoinColumn(name="agence_id"),
	inverseJoinColumns=@JoinColumn(name="aricle_id")
	)
private List<Article> articles;
	@OneToMany(mappedBy = "agence",fetch = FetchType.LAZY)
private List<Reception> receptions;
}
