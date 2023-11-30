package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.ArticleDto;

public interface ArticleService {
ArticleDto createArticle(ArticleDto articleDto);
List<ArticleDto> getAllArticles();
List<ArticleDto> getArticlesWithPagination(int offset,int pageSize);
List<ArticleDto> getArticleWithPaginationSorting(int offset,int pageSize,String field);
List<ArticleDto> getArticleWithSorting(String field);
ArticleDto gatArticleByName(String name);
ArticleDto gatArticleById(Long id);

}
