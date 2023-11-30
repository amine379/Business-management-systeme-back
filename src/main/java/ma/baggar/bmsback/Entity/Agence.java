package ma.baggar.bmsback.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Agence")
public class Agence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

	@Column(nullable = false,unique=true)
private String name;
	@JsonIgnore
	  @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "agences")
private List<Fournisseur> fournisseur;
	@JsonIgnore
	  @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "agences")
private List<Client> clients;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Agence-articles",
	joinColumns=@JoinColumn(name="agence_id"),
	inverseJoinColumns=@JoinColumn(name="aricle_id")
	)
private List<Article> articles;
	@JsonIgnore
	@OneToMany(mappedBy = "agence",fetch = FetchType.LAZY)
private List<Reception> receptions;
	public Agence(String name){
		this.name=name;
	}
}
