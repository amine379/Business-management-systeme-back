package ma.baggar.bmsback.Dao.Implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ma.baggar.bmsback.Dao.FournisseurDao;
import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Repository.FournisseurRepository;

public class FournisseurDaoImp implements FournisseurDao{
	@Autowired
FournisseurRepository fournisseurRepository;
	@Override
	public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto) {
		ModelMapper modelMapper=new ModelMapper();
		Fournisseur fournisseur =modelMapper.map(fournisseurDto, Fournisseur.class);
		if(checkifFournisseurExist(fournisseur)) {return null;} 
		else {
			Fournisseur fournisseurToSave=fournisseurRepository.save(fournisseur);
			FournisseurDto fournisserDtoSave=modelMapper.map(fournisseurToSave, FournisseurDto.class);
			return fournisserDtoSave;
		}
		
		
	}

	@Override
	public List<FournisseurDto> getAllFournisseur() {
		// TODO Auto-generated method stub
		return null;
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
		Fournisseur fournisseurToCheck= fournisseurRepository.findById(fournisseur.getId());
		
		return (fournisseurToCheck.getNom()!=null || fournisseurToCheck.getIce()!=null);
	}

}
