package ma.baggar.bmsback.Controller.UsingByArticle;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;
import ma.baggar.bmsback.Repository.UsingByArticle.ArticlesUniteRepository;
import ma.baggar.bmsback.Request.UniteRequest;
import ma.baggar.bmsback.Response.UniteResponse;
import ma.baggar.bmsback.Service.UsingByArticle.ServiceArticleUnite;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/unite")
public class ArticleUniteController {
	@Autowired
ServiceArticleUnite serviceArticleUnite;
	@Autowired
	ArticlesUniteRepository articlesUniteRepository;
	@PostMapping
	public ResponseEntity<UniteResponse> saveUnite(@RequestBody @Valid UniteRequest uniteRequest){
		ModelMapper modelMapper=new ModelMapper();
		ArticlesUnite unite=modelMapper.map(uniteRequest, ArticlesUnite.class);
		ArticlesUnite uniteToCreate=serviceArticleUnite.CreateArticleUnite(unite);
		UniteResponse uniteResponse=modelMapper.map(uniteToCreate, UniteResponse.class);
		return new ResponseEntity<UniteResponse>(uniteResponse,HttpStatus.CREATED);
	}
	@GetMapping 
	public List<ArticlesUnite> getAllUnite() {
		return this.articlesUniteRepository.findAll();
	}
}
