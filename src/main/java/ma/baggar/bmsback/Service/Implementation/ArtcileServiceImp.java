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
	public ArticleDto createArticle(ArticleDto articleDto,int id_unite,int id_famille,int id_sousFamille,List<Integer> agenceIds,List<Integer> fournisseurIds) {
		
		return articleDao.createArticle(articleDto, id_unite, id_famille, id_sousFamille, agenceIds, fournisseurIds);
	}

}
