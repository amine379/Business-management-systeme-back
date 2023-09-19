package ma.baggar.bmsback.Dao;

import java.util.List;


import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Entity.Article;

public interface ArticleDao {
ArticleDto createArticle(ArticleDto articleDto);
List<ArticleDto> getAllArticles();
ArticleDto gatArticleByName(String name);
ArticleDto gatArticleById(Long id);

boolean checkifArticleExist(Article article);
}
