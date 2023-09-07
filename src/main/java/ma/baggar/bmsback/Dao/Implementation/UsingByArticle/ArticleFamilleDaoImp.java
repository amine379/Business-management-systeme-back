package ma.baggar.bmsback.Dao.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleFamilleDao;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesFamilleRepository;

public class ArticleFamilleDaoImp implements ArticleFamilleDao {
	@Autowired
ArticlesFamilleRepository articlesFamilleRepository;
	@Override
	public ArticlesFamille createArticleFamille(ArticlesFamille articleFamille) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticlesFamille> getAllArticleFamille() {
		List<ArticlesFamille> allFamilles=articlesFamilleRepository.findAll();
		return allFamilles;
	}

	@Override
	public ArticlesFamille getArticleFamilleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
