package ma.baggar.bmsback.Entity.UsingByArticle;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter 
public class ArticlesSousFamilles {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = true)
private String name;

@ManyToOne
private ArticlesFamille articleFamille;
	@OneToMany(mappedBy ="articleSousFamilles",fetch = FetchType.LAZY )
	private List<Article> articles;
}
