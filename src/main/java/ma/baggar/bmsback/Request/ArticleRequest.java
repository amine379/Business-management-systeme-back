package ma.baggar.bmsback.Request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;


@Data @NoArgsConstructor @AllArgsConstructor
public class ArticleRequest {
	@JsonProperty("id")
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private Double purchase_price;
	private Double selling_price;
	private Double tva;
	private float Stock;
	@NotNull
	private ArticlesUnite unite;
//il faut ajouter not null
	private ArticlesFamille articleFamille;
	private ArticlesSousFamilles articleSousFamilles;
	private List<Fournisseur> fournisseur;
	private List<Agence> agence;
}
