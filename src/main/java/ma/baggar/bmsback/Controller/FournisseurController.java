package ma.baggar.bmsback.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Repository.FournisseurRepository;
import ma.baggar.bmsback.Request.FournisseurRequest;
import ma.baggar.bmsback.Response.FournisseurResponse;
import ma.baggar.bmsback.Service.FournisseurService;
@CrossOrigin("*")
@RestController
@RequestMapping("api/fournisseur")
public class FournisseurController {
	@Autowired
	FournisseurService fournisseurService;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@GetMapping
	public List<FournisseurResponse> getAllFournisseurs(){
		List<FournisseurResponse> fournisseurResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		List<FournisseurDto> fournisseurDtos =fournisseurService.getAllFournisseurs();
		for(FournisseurDto fournisseur:fournisseurDtos) {
			FournisseurResponse fournisseurToget=modelMapper.map(fournisseur, FournisseurResponse.class);
			fournisseurResponses.add(fournisseurToget);
		}
		return fournisseurResponses;
	}
	@GetMapping(path = "/{name}")
public 	Fournisseur getFournisseurBynom(@PathVariable String name) {
		return fournisseurRepository.findByNom(name);
	}
	
@PostMapping
public ResponseEntity<FournisseurResponse> saveFournisseur(@RequestBody @Valid FournisseurRequest fournisseurRequest){
	ModelMapper modelMapper=new ModelMapper();
	FournisseurDto fournisseurDto=modelMapper.map(fournisseurRequest, FournisseurDto.class);
	FournisseurDto fournisseurDtoToSave=fournisseurService.CreateFournisseur(fournisseurDto);
	FournisseurResponse fournisseurResponse=modelMapper.map(fournisseurDtoToSave, FournisseurResponse.class);
	return new ResponseEntity<FournisseurResponse>(fournisseurResponse , HttpStatus.CREATED)  ;	
}
}
