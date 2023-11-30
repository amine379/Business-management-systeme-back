package ma.baggar.bmsback.Dao;

import java.util.List;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Entity.Article;

public interface ArticleDao {
ArticleDto createArticle(ArticleDto articleDto);
ArticleDto updateArticle(Long id,ArticleDto articleDto);
List<ArticleDto> getAllArticles();
ArticleDto gatArticleByName(String name);
ArticleDto gatArticleById(Long id);
List<ArticleDto> getArticlesWithPagination(int offset,int pageSize);
List<ArticleDto> getArticleWithPaginationSorting(int offset,int pageSize,String field);
List<ArticleDto> getArticleWithSorting(String field);
boolean checkifArticleExist(Article article);
}
