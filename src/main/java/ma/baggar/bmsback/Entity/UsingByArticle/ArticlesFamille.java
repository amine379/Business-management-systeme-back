package ma.baggar.bmsback.Entity.UsingByArticle;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class  ArticlesFamille {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
@Column(nullable = true)
private String name;
@OneToMany(mappedBy = "articleFamille",fetch = FetchType.LAZY)
private List<ArticlesSousFamilles> articlesSousFamilles;
@OneToMany(mappedBy = "articleFamille",fetch = FetchType.LAZY)
private List<Article> article;
}
