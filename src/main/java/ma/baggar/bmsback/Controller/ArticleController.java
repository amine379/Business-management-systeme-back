package ma.baggar.bmsback.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Request.ArticleRequest;
import ma.baggar.bmsback.Response.ArticleResponse;
import ma.baggar.bmsback.Service.ArticleService;


@RestController
@RequestMapping("api/aricle")
public class ArticleController {
	@Autowired
	ArticleService articleService;
@PostMapping
public ResponseEntity<ArticleResponse> creteArticle(@RequestBody @Valid ArticleRequest articleRequest,@RequestParam (defaultValue = "1") int id_unite,@RequestParam (defaultValue = "1") int id_famille,@RequestParam (defaultValue = "1") int id_sousFamille,@RequestParam List<Integer> agenceIds,@RequestParam List<Integer> fournisseurIds){
ModelMapper modelmapper=new ModelMapper();
ArticleDto createArticle=modelmapper.map(articleRequest, ArticleDto.class);
ArticleDto articleCreated =articleService.createArticle(createArticle, id_unite, id_famille, id_sousFamille, agenceIds, fournisseurIds);
ArticleResponse articleResponse=modelmapper.map(articleCreated, ArticleResponse.class);

	return new ResponseEntity<ArticleResponse>(articleResponse , HttpStatus.CREATED) ;
}
}
