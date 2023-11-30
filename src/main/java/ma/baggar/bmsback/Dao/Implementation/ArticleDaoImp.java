package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.PostConstruct;
import ma.baggar.bmsback.Dao.ArticleDao;
import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Dto.FournisseurDto;
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
import ma.baggar.bmsback.exception.Article.NoSuchArticleExisteException;



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
		Article article=modelMapper.map(articleDto, Article.class);
		List<FournisseurDto> fournisseurDtos=articleDto.getFournisseur();
		List<AgenceDto> agenceDtos=articleDto.getAgence();
		List<Integer> idsFournisseurs=new ArrayList<>();
		List<Integer> idsAgence=new ArrayList<>();
		if(agenceDtos!=null) {
		for(AgenceDto agenceDto:agenceDtos) {
			idsAgence.add(agenceDto.getId());
		}
		List<Agence> agences=agenceRepository.findAllById(idsAgence);
		article.setAgence(agences);
		}
		if(fournisseurDtos!=null) {
		for(FournisseurDto fournisseurDto:fournisseurDtos) {
			idsFournisseurs.add(fournisseurDto.getId());
		}
		List<Fournisseur> fournisseurs=fournisseurRepository.findAllById(idsFournisseurs);
		article.setFournisseur(fournisseurs);
		}
		
		if(articleDto.getUnite()!=null) {
		ArticlesUnite articlesUnite=articlesUniteRepository.findById(articleDto.getUnite().getId());
		article.setUnite(articlesUnite);
		}
		//Optional<ArticlesFamille> articlesFamille=articlesFamilleRepository.findById(articleDto.getArticleFamilleDto().getId());
		if(articleDto.getArticleSousFamille()!=null) {
		ArticlesSousFamilles articlesSousFamilles=articlesSousFamillesRepository.findById(articleDto.getArticleSousFamille().getId());
		article.setArticleSousFamilles(articlesSousFamilles);
		}
		
		
		//if(articlesFamille.isPresent()) {ArticlesFamille articlesFamille2=articlesFamille.get();article.setArticleFamille(articlesFamille2);}
		
		
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

	@Override
	public ArticleDto updateArticle(Long id, ArticleDto articleDto) {
		ModelMapper modelMapper=new ModelMapper();
		Optional<Article> article=articleRepository.findById(id);
		if(article.isPresent()) {
			Article articleToUpdate=article.get();
			articleToUpdate.setName(articleDto.getName());
			articleToUpdate.setPurchase_price(articleDto.getPurchase_price());
			articleToUpdate.setSelling_price(articleDto.getSelling_price());
			articleToUpdate.setTva(articleDto.getTva() );
			articleToUpdate.setStock(articleDto.getStock());
			articleToUpdate.setUnite(articlesUniteRepository.findById(articleDto.getUnite().getId()));
			//articleToUpdate.setArticleFamille(articlesFamilleRepository.findById(articleDto.getArticleFamilleDto().getId()));
			articleToUpdate.setArticleSousFamilles(articlesSousFamillesRepository.findById(articleDto.getArticleSousFamille().getId()));;
			Article articleUpdated=articleRepository.save(articleToUpdate);
			ArticleDto articleDtoUpdatedArticleDto=modelMapper.map(articleUpdated, ArticleDto.class);
			return articleDtoUpdatedArticleDto;
		}
		else 
		throw new NoSuchArticleExisteException("l'aticle que n'existe pas");
	
	}
 /* @PostConstruct
 public void initDB() {
     List<Article> products = IntStream.rangeClosed(1, 200)
            .mapToObj(i -> new Article("article"+i, new Random().nextDouble(100), new Random().nextDouble(50000)))
              .collect(Collectors.toList());
     articleRepository.saveAll(products);
  }*/

	@Override
	public List<ArticleDto> getArticlesWithPagination(int offset, int pageSize) {
		ModelMapper modelMapper=new ModelMapper();
		List<ArticleDto> articleDtos=new ArrayList<>();
		Page<Article> Articles=articleRepository.findAll(PageRequest.of(offset, pageSize));
		List<Article> articleList=Articles.getContent();
		for(Article article:articleList) {
			articleDtos.add(modelMapper.map(article, ArticleDto.class));
		}
		return articleDtos;
	}

	@Override
	public List<ArticleDto> getArticleWithPaginationSorting(int offset, int pageSize, String field) {
		ModelMapper modelMapper=new ModelMapper();
		List<ArticleDto> articleDtos=new ArrayList<>();
		Page<Article> Articles=articleRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		List<Article> articleList=Articles.getContent();
		for(Article article:articleList) {
			articleDtos.add(modelMapper.map(article, ArticleDto.class));
		}
		return articleDtos;
	}

	@Override
	public List<ArticleDto> getArticleWithSorting(String field) {
		ModelMapper modelMapper=new ModelMapper();
		List<ArticleDto> articleDtos=new ArrayList<>();  
		List<Article> articles=articleRepository.findAll(Sort.by(Sort.Direction.ASC,field));
		for(Article article:articles) {
			articleDtos.add(modelMapper.map(article, ArticleDto.class));
		}
		return articleDtos;
	}
	

}
