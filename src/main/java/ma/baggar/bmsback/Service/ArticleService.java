package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.ArticleDto;

public interface ArticleService {
ArticleDto createArticle(ArticleDto articleDto,int id_unite,int id_famille,int id_sousFamille,List<Integer> agenceIds,List<Integer> fournisseurIds);
}
