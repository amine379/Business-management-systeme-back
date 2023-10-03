package ma.baggar.bmsback.Dto.UsingByArticles;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;

@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleFamilleDto {
	private Integer id;
	@NotNull
private String name;
private List<ArticlesSousFamilles> articlesSousFamilles;
private List<Article> article;
}
