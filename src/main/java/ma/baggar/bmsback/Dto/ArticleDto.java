package ma.baggar.bmsback.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleDto {
	private Long id;
	private String name;
	private Double purchase_price;
	private Double selling_price;
	private Double tva;
	private float Stock;
	private boolean active;
	private ArticlesUnite unite;
//il faut ajouter not null
	private ArticlesFamille articleFamille;
	private ArticlesSousFamilles articleSousFamilles;
	private List<Fournisseur> fournisseur;
	private List<Agence> agence;
}
