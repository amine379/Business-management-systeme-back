package ma.baggar.bmsback.Dao.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleSousFamilleDao;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesSousFamillesRepository;

public class ArticleSousFamilleDaoImp implements ArticleSousFamilleDao {
	@Autowired
ArticlesSousFamillesRepository articlesSousFamillesRepository;
	@Override
	public ArticlesSousFamilles createArticleSousFamille(ArticlesSousFamilles articleSousFamille) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticlesSousFamilles> getAllArticleSousFamille() {
		List<ArticlesSousFamilles> allSousFamilles=articlesSousFamillesRepository.findAll();
		return allSousFamilles;
	}

	@Override
	public ArticlesSousFamilles getArticleSousFamilleById() {
		// TODO Auto-generated method stub
		return null;
	}

}
