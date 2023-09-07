package ma.baggar.bmsback.Dao.UsingByAricle;

import java.util.List;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;

public interface ArticleUniteDao {
ArticlesUnite createArticleUnite(ArticlesUnite uite);
List<ArticlesUnite> getAllUnite();
ArticlesUnite getUniteById();
}
