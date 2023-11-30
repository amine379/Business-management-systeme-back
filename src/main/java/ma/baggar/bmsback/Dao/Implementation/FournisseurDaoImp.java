package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ma.baggar.bmsback.exception.Facture.FactureNotFoundException;
import ma.baggar.bmsback.exception.Fournisseur.FournisseurAlreadyExist;
import ma.baggar.bmsback.exception.Fournisseur.FournisseurNotFound;
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
	@Autowired
	ModelMapper modelMapper;

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
		Fournisseur fournisseur=fournisseurRepository.findByNom(name);
	if(fournisseur!=null){
		return modelMapper.map(fournisseur,FournisseurDto.class);
	}
		throw  new FournisseurNotFound("Fournisseur Not found With name"+name);
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
		throw  new FournisseurNotFound("Fournisseur Not Found with id"+FournisseurId);
	}

	@Override
	public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto) {
		ModelMapper modelMapper=new ModelMapper();
		Fournisseur fournisseur =modelMapper.map(fournisseurDto, Fournisseur.class);

	  if(checkifFournisseurExist(fournisseur)) {throw  new FournisseurAlreadyExist("le fournisseur deja existe"+fournisseurDto.getNom());}
		  else {
			  if(!fournisseurDto.getAgences().isEmpty()) {
				  List<Agence> agences=
						  fournisseurDto.getAgences()
								  .stream()
								  .map(agenceDto -> modelMapper.map(agenceDto,Agence.class))
								  .collect(Collectors.toList());
			fournisseur.setAgences(agences);
			  }
			Fournisseur fournisseurToSave=fournisseurRepository.save(fournisseur);
	return  modelMapper.map(fournisseurToSave, FournisseurDto.class);

		
	}
	}

	@Override
	public FournisseurDto getFournisseurById(int id) {
		Fournisseur fournisseur=fournisseurRepository.findById(id);
		try{
			if(fournisseur!=null){
				return modelMapper.map(fournisseur,FournisseurDto.class);
			}
			else {
				throw new FactureNotFoundException("fournisseur with id:"+id+" Not found");
			}
		}
		catch (Exception e){
			throw new RuntimeException("probleme de getFournisseurByid et fournisseur with id"+id+" existee");
		}

	}

}
