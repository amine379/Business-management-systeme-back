package ma.baggar.bmsback.Dao;

import java.util.List;
import java.util.Optional;

import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Entity.Article;

public interface ArticleDao {
ArticleDto createArticle(ArticleDto articleDto,int id_unite,int id_famille,int id_sousFamille,List<Integer> agenceIds,List<Integer> fournisseurIds);
boolean checkifArticleExist(Article article);
}
