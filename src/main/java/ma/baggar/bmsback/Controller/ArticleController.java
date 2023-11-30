package ma.baggar.bmsback.Controller;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Dto.Shared.ApiResponsePagination;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Repository.ArticleRepository;
import ma.baggar.bmsback.Request.ArticleRequest;
import ma.baggar.bmsback.Response.ArticleResponse;
import ma.baggar.bmsback.Service.ArticleService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/article")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	ModelMapper modelMapper;

	 @GetMapping
public List<ArticleResponse> getAllArticles(){
	List<ArticleResponse> articleResponses=new ArrayList<>();
	List<ArticleDto> articleDtos=articleService.getAllArticles();
	for(ArticleDto articleDto:articleDtos) {
		ArticleResponse articleResponse=modelMapper.map(articleDto, ArticleResponse.class);
		articleResponses.add(articleResponse);
	}
	return articleResponses;
}

	 @GetMapping("/pagination/{offset}/{pageSize}")
	    public  List<ArticleResponse> getProductsWithPagination(@RequestParam int offset, @PathVariable int pageSize) {
		 List<ArticleResponse> articleResponses=new ArrayList<>();
	        List<ArticleDto>  articleDtos= articleService.getArticlesWithPagination(offset, pageSize);
			for(ArticleDto article:articleDtos){
				articleResponses.add(modelMapper.map(article,ArticleResponse.class));
			}
	        return articleResponses;}
	
	
	/*@GetMapping
	public ApiResponsePagination<List<Article>> getAllArticles(){
		List<Article> allArticles=articleRepository.findAll();
		return new ApiResponsePagination<List<Article>>(allArticles.size(), allArticles);
	}*/
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
public ResponseEntity<ArticleResponse> creteArticle(@RequestBody ArticleRequest articleRequest){
ArticleDto articleDto=modelMapper.map(articleRequest, ArticleDto.class);
articleDto=articleService.createArticle(articleDto);
ArticleResponse articleResponse=modelMapper.map(articleDto, ArticleResponse.class);
return new ResponseEntity<ArticleResponse>(articleResponse , HttpStatus.CREATED) ;
}

}
