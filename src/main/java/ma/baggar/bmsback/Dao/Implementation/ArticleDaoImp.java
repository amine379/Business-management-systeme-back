package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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



@Repository
public class ArticleDaoImp implements ArticleDao{
	@Autowired
ArticleRepository articleRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	ArticlesUniteRepository articlesUniteRepository;
	@Autowired
	ArticlesFamilleRepository articlesFamilleRepository;
	@Autowired
	ArticlesSousFamillesRepository articlesSousFamillesRepository;

	
	@Override
	public ArticleDto createArticle(ArticleDto articleDto) {
		ModelMapper modelMapper=new ModelMapper();
		List<Fournisseur> fournisseurs=fournisseurRepository.findAllById(articleDto.getFournisseurIds());
		List<Agence> agences=agenceRepository.findAllById(articleDto.getAgenceIds());
		ArticlesUnite articlesUnite=articlesUniteRepository.findById(articleDto.getId_unite());
		ArticlesFamille articlesFamille=articlesFamilleRepository.findById(articleDto.getId_famille());
		ArticlesSousFamilles articlesSousFamilles=articlesSousFamillesRepository.findById(articleDto.getId_sousFamille());
		Article article=modelMapper.map(articleDto, Article.class);
		article.setFournisseur(fournisseurs);article.setAgence(agences);article.setUnite(articlesUnite);article.setArticleFamille(articlesFamille);article.setArticleSousFamilles(articlesSousFamilles);
		if(!checkifArticleExist(article)) {
			Article articleSave=articleRepository.save(article);
			ArticleDto articleDtoSave=modelMapper.map(articleSave, ArticleDto.class);
			return articleDtoSave;
		}
	return null;
	}

	@Override
	public boolean checkifArticleExist(Article article) {
		Article articeExistant=articleRepository.findByName(article.getName());
		return articeExistant!=null;
	}

	@Override
	public List<ArticleDto> getAllArticles() {
		ModelMapper modelMapper=new ModelMapper();
		List<ArticleDto> articleDtos=new ArrayList<>();
		List<Article> articles=articleRepository.findAll();
		for(Article article:articles) {
		ArticleDto articleDto=modelMapper.map(article, ArticleDto.class);
		articleDtos.add(articleDto);
		}
		return articleDtos;
	}

	@Override
	public ArticleDto gatArticleByName(String name) {
		ModelMapper modelMapper=new ModelMapper();
		Article article=articleRepository.findByName(name);
		ArticleDto articleDto=modelMapper.map(article, ArticleDto.class);
		return articleDto;
	}

	@Override
	public ArticleDto gatArticleById(Long id) {
		ModelMapper modelMapper=new ModelMapper();
		Optional<Article> article=articleRepository.findById(id);
		ArticleDto articleDto=modelMapper.map(article, ArticleDto.class);
		return articleDto;
	}

}
