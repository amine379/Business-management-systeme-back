package ma.baggar.bmsback.Controller;

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
import ma.baggar.bmsback.Dto.AgenceDto;

import ma.baggar.bmsback.Request.AgenceRequest;
import ma.baggar.bmsback.Response.AgenceResponse;
import ma.baggar.bmsback.Service.AgenceService;
@CrossOrigin("*")
@RestController
@RequestMapping("api/agence")
public class AgenceController {
	@Autowired
AgenceService agenceService;

	@GetMapping
	public List<AgenceResponse> getAllAgences() {
		ModelMapper modelMapper=new ModelMapper();
		List<AgenceResponse> agenceResponses=new ArrayList<>();
		List<AgenceDto> agenceDtos=agenceService.getAllAgences();
		for(AgenceDto agenceDto:agenceDtos) {
			AgenceResponse agenceResponse=modelMapper.map(agenceDto, AgenceResponse.class);
			agenceResponses.add(agenceResponse);
		}
		return agenceResponses;
	}
	
 @PostMapping
public ResponseEntity<AgenceResponse> createAgence(@RequestBody @Valid AgenceRequest agenceRequest){
	ModelMapper modelMapper=new ModelMapper();
	AgenceDto agenceDto=modelMapper.map(agenceRequest, AgenceDto.class);
	AgenceDto agenceDtoToCreate=agenceService.CreateAgence(agenceDto);
 AgenceResponse agenceResponse=modelMapper.map(agenceDtoToCreate, AgenceResponse.class);
	return new ResponseEntity<AgenceResponse> (agenceResponse,HttpStatus.CREATED);
}
}
