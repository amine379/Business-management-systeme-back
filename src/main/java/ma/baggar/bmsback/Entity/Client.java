package ma.baggar.bmsback.Entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
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
	private String ice;
	@Column(nullable = true)
	private Boolean situation=true;
	@Column(nullable = true)
	private String adress;
	@Column(nullable = true)
	private Double telephone;
	@Column(nullable = true)
	private BigDecimal resteaPayer;
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
	@OneToMany(mappedBy = "client")
	private List<Facture> factures;


 }
