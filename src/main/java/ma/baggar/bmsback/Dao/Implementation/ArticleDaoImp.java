package ma.baggar.bmsback.Dao.Implementation;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ma.baggar.bmsback.Dao.ArticleDao;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
import ma.baggar.bmsback.Repository.AgenceRepository;
import ma.baggar.bmsback.Repository.ArticleRepository;
import ma.baggar.bmsback.Repository.FournisseurRepository;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesFamilleRepository;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesSousFamillesRepository;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesUniteRepository;
import ma.baggar.bmsback.exception.Article.AlReadyExistException;

@Repository
public class ArticleDaoImp implements ArticleDao{
	@Autowired
ArticleRepository articleRepository;
	@Autowired
	ArticlesUniteRepository articleUniteRepository;
	@Autowired
	ArticlesFamilleRepository articlesFamilleRepository;
	@Autowired
	ArticlesSousFamillesRepository articlesSousFamillesRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	AgenceRepository agenceRepository;

	
	@Override
	public ArticleDto createArticle(ArticleDto articleDto,int id_unite,int id_famille,int id_sousFamille,List<Integer> agenceIds,List<Integer> fournisseurIds) {
		ModelMapper modelMapper=new ModelMapper();
		Article article=modelMapper.map(articleDto, Article.class);
		if(checkifArticleExist(article)) throw new AlReadyExistException();
		
		if(agenceIds!=null && !agenceIds.isEmpty()) {
			List<Agence> agences=agenceRepository.findAllById(agenceIds);
			article.setAgence(agences);
		}
		else {article.getAgence().clear();}
		
		if(fournisseurIds!=null && !fournisseurIds.isEmpty()) {
			List<Fournisseur> fournisseurs=fournisseurRepository.findAllById(fournisseurIds);
			article.setFournisseur(fournisseurs);
		}
		else { article.getFournisseur().clear();}
		
		ArticlesUnite articleUnite=articleUniteRepository.findById(id_unite);
			article.setUnite(articleUnite);
			
		
			ArticlesFamille articleFamille=articlesFamilleRepository.findById(id_famille);
			article.setArticleFamille(articleFamille);
		
		
			ArticlesSousFamilles articleSousFamille=articlesSousFamillesRepository.findById(id_sousFamille);
			article.setArticleSousFamilles(articleSousFamille);
	
	Article articleCreated=articleRepository.save(article);
	ArticleDto articleDtoCreated=modelMapper.map(articleCreated, ArticleDto.class);
		return articleDtoCreated;
	}

	@Override
	public boolean checkifArticleExist(Article article) {
		Article articeExistant=articleRepository.findByName(article.getName());
		return articeExistant!=null;
	}

}
