package ma.baggar.bmsback.Service.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleFamilleDao;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;
import ma.baggar.bmsback.Service.UsingByArticle.ServiceArticleFamille;
@Service
public class ServiceArticleFamilleImp implements ServiceArticleFamille {
	@Autowired
ArticleFamilleDao articleFamilleDao;

	@Override
	public ArticleFamilleDto createArticleFamille(ArticleFamilleDto articleFamilleDto) {
		// TODO Auto-generated method stub
		return articleFamilleDao.createArticleFamille(articleFamilleDto);
	}

	@Override
	public List<ArticleFamilleDto> getAllArticlesFamille() {
		// TODO Auto-generated method stub
		return articleFamilleDao.getAllArticleFamille();
	}

}
