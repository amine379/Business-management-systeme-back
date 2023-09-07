package ma.baggar.bmsback.Dao.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleUniteDao;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesUniteRepository;
@Repository
public class ArticleUniteDaoImp implements ArticleUniteDao{
	@Autowired
ArticlesUniteRepository articleUniteRepository;
	@Override
	public ArticlesUnite createArticleUnite(ArticlesUnite unite) {
		ArticlesUnite saveArticle=articleUniteRepository.save(unite);
		return saveArticle;
	}

	@Override
	public List<ArticlesUnite> getAllUnite() {
		List<ArticlesUnite> allUnit=articleUniteRepository.findAll();
		return allUnit;
	}

	@Override
	public ArticlesUnite getUniteById() {
		// TODO Auto-generated method stub
		return null;
	}

}
