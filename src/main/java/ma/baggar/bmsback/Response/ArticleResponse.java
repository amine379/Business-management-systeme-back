package ma.baggar.bmsback.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.TvaEntity;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleResponse {
	@JsonProperty("id")
	private Long id;
	private String name;
	private Double purchase_price;
	private Double selling_price;
	private TvaResponse tva;
	private float Stock;
	private boolean situation;
	private ArticlesUnite unite;
	private ArticlesFamille articleFamille;
	private ArticlesSousFamilles articleSousFamilles;
	private List<Fournisseur> fournisseur;
	private List<Agence> agence;
}
