package ma.baggar.bmsback.Service.Implementation.UsingByArticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleUniteDao;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
import ma.baggar.bmsback.Service.UsingByArticle.ServiceArticleUnite;
@Service
public class ArticleUniteServiceImp implements ServiceArticleUnite{
	@Autowired
ArticleUniteDao articleUniteDao;
	@Override
	public ArticlesUnite CreateArticleUnite(ArticlesUnite unite) {
		// TODO Auto-generated method stub
		return articleUniteDao.createArticleUnite(unite);
	}

}
