package ma.baggar.bmsback.Dao.UsingByAricle;

import java.util.List;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;

public interface ArticleFamilleDao {
	ArticlesFamille createArticleFamille(ArticlesFamille articleFamille);
	List<ArticlesFamille> getAllArticleFamille();
	ArticlesFamille getArticleFamilleById(int id);
	
	

}
