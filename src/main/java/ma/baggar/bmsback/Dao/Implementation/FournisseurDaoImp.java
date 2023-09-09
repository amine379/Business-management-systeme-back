package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.FournisseurDao;
import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Repository.AgenceRepository;
import ma.baggar.bmsback.Repository.FournisseurRepository;
@Repository
public class FournisseurDaoImp implements FournisseurDao{
	@Autowired
FournisseurRepository fournisseurRepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Override
	public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto) {
		ModelMapper modelMapper=new ModelMapper();
		Fournisseur fournisseur =modelMapper.map(fournisseurDto, Fournisseur.class);
		
		  if(checkifFournisseurExist(fournisseur)) {return null;} else {
		 
			Fournisseur fournisseurToSave=fournisseurRepository.save(fournisseur);
			FournisseurDto fournisserDtoSave=modelMapper.map(fournisseurToSave, FournisseurDto.class);
			return fournisserDtoSave;
		
		
		
	}}

	@Override
	public List<FournisseurDto> getAllFournisseur() {
		List<FournisseurDto> fournisseurDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		List<Fournisseur> allFournisseur=fournisseurRepository.findAll();
		for(Fournisseur fournisseur:allFournisseur) {
			FournisseurDto fournisseurDto=modelMapper.map(fournisseur, FournisseurDto.class);
			fournisseurDtos.add(fournisseurDto);
		}
		return fournisseurDtos;
	}

	@Override
	public FournisseurDto getFournisseurByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FournisseurDto getFournisseurByStatus(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkifFournisseurExist(Fournisseur fournisseur) {
		Fournisseur fournisseurToCheck= fournisseurRepository.findByNom(fournisseur.getNom());
		
		return (fournisseurToCheck!=null );
	}

	@Override
	public FournisseurDto addAgencesToFournisseur(int FournisseurId, List<Integer> agenceIds) {
		Fournisseur fournisseur=fournisseurRepository.findById(FournisseurId);
		if(checkifFournisseurExist(fournisseur)) {
			ModelMapper modelMapper=new ModelMapper();
			List<Agence> agences=agenceRepository.findAllById(agenceIds);
			fournisseur.setAgences(agences);
			Fournisseur fournisseurUpdated= fournisseurRepository.save(fournisseur);
			FournisseurDto fournisseurDto=modelMapper.map(fournisseurUpdated, FournisseurDto.class);
			return fournisseurDto;
		}
		else
		return null;
	}

}
