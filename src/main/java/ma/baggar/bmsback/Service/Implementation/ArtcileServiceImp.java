package ma.baggar.bmsback.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.ArticleDao;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Service.ArticleService;
@Service
public class ArtcileServiceImp implements ArticleService {
	@Autowired
ArticleDao articleDao;
	@Override
	public ArticleDto createArticle(ArticleDto articleDto) {
		
		return articleDao.createArticle(articleDto);
	}
	@Override
	public List<ArticleDto> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticles();
	}
	@Override
	public ArticleDto gatArticleByName(String name) {
		// TODO Auto-generated method stub
		return articleDao.gatArticleByName(name);
	}
	@Override
	public ArticleDto gatArticleById(Long id) {
		// TODO Auto-generated method stub
		return articleDao.gatArticleById(id);
	}

}
