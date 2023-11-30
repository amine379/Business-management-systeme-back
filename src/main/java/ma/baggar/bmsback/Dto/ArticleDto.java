package ma.baggar.bmsback.Dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleSousFamilleDto;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleUniteDto;
import ma.baggar.bmsback.Entity.TvaEntity;


@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleDto {
	private Long id;
	@NotNull
	private String name;
	
	private BigDecimal purchase_price;
	private BigDecimal selling_price;
	private TvaEntity tva;
	private float Stock;
	@NotNull
	private boolean situation;
//il faut ajouter not null
	@NotNull
	private ArticleUniteDto unite;
	private ArticleFamilleDto articleFamille;
	private ArticleSousFamilleDto articleSousFamille;
	private List<AgenceDto> agence;
	private List<FournisseurDto> fournisseur;
}
