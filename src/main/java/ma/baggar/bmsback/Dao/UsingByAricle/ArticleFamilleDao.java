package ma.baggar.bmsback.Dao.UsingByAricle;

import java.util.List;

import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;


public interface ArticleFamilleDao {
	ArticleFamilleDto createArticleFamille(ArticleFamilleDto articleFamilleDto);
	List<ArticleFamilleDto> getAllArticleFamille();
	ArticleFamilleDto getArticleFamilleById(int id);
	
	

}
