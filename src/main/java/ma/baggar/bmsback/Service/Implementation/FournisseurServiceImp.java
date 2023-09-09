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
	@Override
	public FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto) {
		
		return fournisseurDao.CreateFournisseur(fournisseurDto);
	}
	@Override
	public List<FournisseurDto> getAllFournisseurs() {
		// TODO Auto-generated method stub
		return fournisseurDao.getAllFournisseur();
	}

}
