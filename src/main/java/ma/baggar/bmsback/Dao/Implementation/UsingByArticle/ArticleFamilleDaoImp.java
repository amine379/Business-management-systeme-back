package ma.baggar.bmsback.Dao.Implementation.UsingByArticle;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.UsingByAricle.ArticleFamilleDao;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesFamilleRepository;
@Repository
public class ArticleFamilleDaoImp implements ArticleFamilleDao {
	@Autowired
ArticlesFamilleRepository articlesFamilleRepository;

	@Override
	public ArticleFamilleDto createArticleFamille(ArticleFamilleDto articleFamilleDto) {
ModelMapper modelMapper=new ModelMapper();
ArticlesFamille articlesFamille=modelMapper.map(articleFamilleDto, ArticlesFamille.class);
ArticlesFamille articleFamilleCreated=articlesFamilleRepository.save(articlesFamille);
ArticleFamilleDto articleDtoCreated=modelMapper.map(articleFamilleCreated, ArticleFamilleDto.class);
		return articleDtoCreated;
	}

	@Override
	public List<ArticleFamilleDto> getAllArticleFamille() {
		List<ArticleFamilleDto> articleFamilleDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		List<ArticlesFamille> articlesFamilles=articlesFamilleRepository.findAll();
		for(ArticlesFamille articlesFamille:articlesFamilles) {
			ArticleFamilleDto articleFamilleDto=modelMapper.map(articlesFamille, ArticleFamilleDto.class);
			articleFamilleDtos.add(articleFamilleDto);
		}
		return articleFamilleDtos;
	}

	@Override
	public ArticleFamilleDto getArticleFamilleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
