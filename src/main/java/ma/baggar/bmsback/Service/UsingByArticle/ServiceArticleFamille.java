package ma.baggar.bmsback.Service.UsingByArticle;

import java.util.List;

import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;

public interface ServiceArticleFamille {
	ArticleFamilleDto createArticleFamille(ArticleFamilleDto articleFamilleDto);
	List<ArticleFamilleDto> getAllArticlesFamille();
	
	
}
