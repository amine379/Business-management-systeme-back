package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.ArticleDto;

public interface ArticleService {
ArticleDto createArticle(ArticleDto articleDto);
List<ArticleDto> getAllArticles();
ArticleDto gatArticleByName(String name);
ArticleDto gatArticleById(Long id);
}
