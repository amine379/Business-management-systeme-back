package ma.baggar.bmsback.Controller.UsingByArticle;

import java.util.ArrayList;
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
import ma.baggar.bmsback.Entity.TvaEntity;
import ma.baggar.bmsback.Request.TvaRequest;
import ma.baggar.bmsback.Response.TvaResponse;
import ma.baggar.bmsback.Service.UsingByArticle.TvaArtcileService;
@CrossOrigin("*")
@RestController 
@RequestMapping("api/tva")
public class TvaArticleController {
	@Autowired
	TvaArtcileService tvaArtcileService;
	@PostMapping
 ResponseEntity<TvaResponse> createTva(@RequestBody @Valid TvaRequest tvaRequest){
	 ModelMapper modelMapper=new ModelMapper();
 TvaEntity tvaEntity=modelMapper.map(tvaRequest, TvaEntity.class);
 tvaEntity=tvaArtcileService.createTvaEntity(tvaEntity);
 TvaResponse tvaResponse=modelMapper.map(tvaEntity, TvaResponse.class);
	return new ResponseEntity<TvaResponse>(tvaResponse,HttpStatus.CREATED);
 }
	@GetMapping
 public List<TvaResponse> getAllTva(){
		List<TvaEntity> tvaEntities=tvaArtcileService.getAllEntityTva();
		ModelMapper modelMapper=new ModelMapper();
		List<TvaResponse> tvaResponses=new ArrayList<>();
		for(TvaEntity tvaEntity:tvaEntities) {
			TvaResponse tvaResponse=modelMapper.map(tvaEntity, TvaResponse.class);
			tvaResponses.add(tvaResponse);
		}
		return tvaResponses;
	}
}
