package ma.baggar.bmsback.Controller;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Request.ArticleRequest;
import ma.baggar.bmsback.Response.ArticleResponse;
import ma.baggar.bmsback.Service.ArticleService;


@RestController
@RequestMapping("api/article")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@GetMapping
public List<ArticleResponse> getAllArticles(){
	ModelMapper modelMapper=new ModelMapper();
	List<ArticleResponse> articleResponses=new ArrayList<>();
	List<ArticleDto> articleDtos=articleService.getAllArticles();
	for(ArticleDto articleDto:articleDtos) {
		ArticleResponse articleResponse=modelMapper.map(articleDto, ArticleResponse.class);
		articleResponses.add(articleResponse);
	}
	return articleResponses;
}
	@GetMapping(path="/{nom}")
	public ResponseEntity<ArticleResponse>  gatArticleByName(@PathVariable String nom) {
		ModelMapper modelMapper=new ModelMapper();
		ArticleDto articleDto=articleService.gatArticleByName(nom);
		ArticleResponse articleResponse=modelMapper.map(articleDto, ArticleResponse.class);
		return new ResponseEntity<ArticleResponse> (articleResponse,HttpStatus.OK);
	}
	@GetMapping(path="/{id}")
	public ResponseEntity<ArticleResponse>  gatArticleByName(@PathVariable Long id) {
		ModelMapper modelMapper=new ModelMapper();
		ArticleDto articleDto=articleService.gatArticleById(id);
		ArticleResponse articleResponse=modelMapper.map(articleDto, ArticleResponse.class);
		return new ResponseEntity<ArticleResponse> (articleResponse,HttpStatus.OK);
	}

@PostMapping
public ResponseEntity<ArticleResponse> creteArticle(@RequestBody @Valid ArticleRequest articleRequest){
ModelMapper modelmapper=new ModelMapper();
ArticleDto articleDto=modelmapper.map(articleRequest, ArticleDto.class);
articleDto=articleService.createArticle(articleDto);
ArticleResponse articleResponse=modelmapper.map(articleDto, ArticleResponse.class);
return new ResponseEntity<ArticleResponse>(articleResponse , HttpStatus.CREATED) ;
}

}
