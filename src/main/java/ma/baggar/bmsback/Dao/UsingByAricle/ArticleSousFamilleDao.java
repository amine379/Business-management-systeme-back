package ma.baggar.bmsback.Dao.UsingByAricle;

import java.util.List;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;

public interface ArticleSousFamilleDao {
ArticlesSousFamilles createArticleSousFamille(ArticlesSousFamilles articleSousFamille);
List<ArticlesSousFamilles> getAllArticleSousFamille();
ArticlesSousFamilles getArticleSousFamilleById();
}
