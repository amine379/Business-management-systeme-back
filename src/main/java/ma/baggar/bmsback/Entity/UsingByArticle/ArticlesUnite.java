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
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class ArticlesUnite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
private String name;
	@OneToMany(mappedBy = "unite",fetch = FetchType.LAZY)
	private List<Article> article;
}
