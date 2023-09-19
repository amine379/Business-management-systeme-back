package ma.baggar.bmsback.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.FournisseurDao;
import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Service.FournisseurService;
@Service
public class FournisseurServiceImp implements FournisseurService{
	@Autowired
FournisseurDao fournisseurDao;
	
	/*
	 * public FournisseurDto CreateFournisseur(FournisseurDto
	 * fournisseurDto,List<Integer> agenceIds) {
	 * 
	 * return fournisseurDao.CreateFournisseur(fournisseurDto,agenceIds); }
	 */
	@Override
	public List<FournisseurDto> getAllFournisseurs() {
		// TODO Auto-generated method stub
		return fournisseurDao.getAllFournisseur();
	}
	@Override
	public FournisseurDto addAgencesToFournisseur(int fournisseuId, List<Integer> agencesIds) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDtos) {
		// TODO Auto-generated method stub
		return fournisseurDao.CreateFournisseur(fournisseurDtos);
	}


}
