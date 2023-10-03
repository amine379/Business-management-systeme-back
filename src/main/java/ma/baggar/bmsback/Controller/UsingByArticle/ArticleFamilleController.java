package ma.baggar.bmsback.Controller.UsingByArticle;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.UsingByArticles.ArticleFamilleDto;
import ma.baggar.bmsback.Request.ArticleFamilleRequest;
import ma.baggar.bmsback.Response.ArticleFamilleResponse;
import ma.baggar.bmsback.Service.UsingByArticle.ServiceArticleFamille;

@RestController
@RequestMapping ("api/famille")
public class ArticleFamilleController {
	@Autowired
	ServiceArticleFamille serviceArticleFamille;
@PostMapping
public ResponseEntity<ArticleFamilleResponse> createArticleFamille(@RequestBody @Valid ArticleFamilleRequest articleFamilleRequest){
	ModelMapper modelMapper=new ModelMapper();
	ArticleFamilleDto articleFamilleDto=modelMapper.map(articleFamilleRequest, ArticleFamilleDto.class);
	ArticleFamilleDto articleFamilleDtoCreated=serviceArticleFamille.createArticleFamille(articleFamilleDto);
	ArticleFamilleResponse articleFamilleResponse =modelMapper.map(articleFamilleDtoCreated, ArticleFamilleResponse.class) ;
	return new ResponseEntity<ArticleFamilleResponse> (articleFamilleResponse,HttpStatus.CREATED);
}
@GetMapping 
public List<ArticleFamilleResponse> getAllArticleFamille(){
	ModelMapper modelMapper=new ModelMapper();
	List<ArticleFamilleResponse> articleFamilleResponses=new ArrayList<>();
	List<ArticleFamilleDto> articleFamilleDtos=serviceArticleFamille.getAllArticlesFamille();
	for(ArticleFamilleDto articleFamilleDto:articleFamilleDtos) {
		ArticleFamilleResponse articleFamilleResponse=modelMapper.map(articleFamilleDto, ArticleFamilleResponse.class);
		articleFamilleResponses.add(articleFamilleResponse);
	}
	return articleFamilleResponses;
}
}
