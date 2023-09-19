package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.AgenceDao;
import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Repository.AgenceRepository;
@Repository
public class AgenceDaoImp implements AgenceDao {
	@Autowired
AgenceRepository agenceRepository;
	@Override
	public AgenceDto createAgence(AgenceDto agenceDto) {
		ModelMapper modelMapper=new ModelMapper();
		Agence agence=modelMapper.map(agenceDto, Agence.class);
		if(!checkIfExist(agence)) {
		Agence agenceToSave=agenceRepository.save(agence);
		AgenceDto agenceDtoToSave=modelMapper.map(agenceToSave, AgenceDto.class);
		return agenceDtoToSave;
		}
	
		return null;
	}
	@Override
	public boolean checkIfExist(Agence agence) {
		// TODO Auto-generated method stub
		Agence agenceToTestIfExist=agenceRepository.findByName(agence.getName());
		return (agenceToTestIfExist!=null);
	}
	@Override
	public List<AgenceDto> getAllAgences() {
		List<Agence> agences=agenceRepository.findAll();
		if(agences != null && !agences.isEmpty()) {
			List<AgenceDto> agencesDto=new ArrayList<>();
			ModelMapper modelMapper=new ModelMapper();
			for(Agence agence:agences) {
				AgenceDto agenceDto=modelMapper.map(agence, AgenceDto.class);
				agencesDto.add(agenceDto);
				
			}
			return agencesDto;
		}
		else
		return null;
	}

}
