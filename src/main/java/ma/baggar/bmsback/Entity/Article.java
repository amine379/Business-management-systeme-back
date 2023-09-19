package ma.baggar.bmsback.Entity;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Designation",nullable = false,unique = true)
	private String name;
	@Column(name = "Prix-achat")
	private Double purchase_price;
	@Column(name ="Prix_vente")
	private Double selling_price;
	@ManyToOne
	@JoinColumn(name = "tva_id",nullable = false)
	private TvaEntity tva;
	@Column(nullable = true)
	private boolean situation;
	@Column(nullable = false)
	private float Stock=0;
	@ManyToOne
	@JoinColumn(name = "unite_id",nullable = false)
	private ArticlesUnite unite;
	@ManyToOne
	@JoinColumn(name = "articleFamille_id",nullable = false)
	private ArticlesFamille articleFamille;
	@ManyToOne 
	@JoinColumn(name = "articleSousFamille_id",nullable = false)
	private ArticlesSousFamilles articleSousFamilles;
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(name="fournisseur-articles")
	private List<Fournisseur> fournisseur;
	@ManyToMany(mappedBy = "articles",fetch = FetchType.EAGER)
    private List<Agence> agence;
	@ManyToMany(mappedBy = "articles",fetch = FetchType.EAGER)
	private List<Reception> reception;

	}
	
	
	

