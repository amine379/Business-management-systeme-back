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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Entity @Table(name="client") @Data @AllArgsConstructor @NoArgsConstructor 
public class Client {
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
	@Column(nullable =true)
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          })
	@JoinTable(name = "agence_client",
	joinColumns=@JoinColumn(name="client_id"),
	inverseJoinColumns=@JoinColumn(name="agence_id"))
	private List<Agence> agences;

}
