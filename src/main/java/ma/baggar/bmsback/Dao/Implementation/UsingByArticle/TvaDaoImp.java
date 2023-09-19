package ma.baggar.bmsback.Dao.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.UsingByAricle.TvaDao;
import ma.baggar.bmsback.Entity.TvaEntity;
import ma.baggar.bmsback.Repository.TvaRepository;
@Repository
public class TvaDaoImp implements TvaDao{
	@Autowired
TvaRepository tvaRepository;
	@Override
	public TvaEntity createTva(TvaEntity tvaEntity) {
		if(!checkIfExiste(tvaEntity)) {
			TvaEntity tvaEntityCreated= tvaRepository.save(tvaEntity);
			return tvaEntityCreated;
		}
		return null;
	}

	@Override
	public List<TvaEntity> getAllTva() {
		List<TvaEntity> tvaEntities=tvaRepository.findAll();
		if(tvaEntities!=null) {System.out.print("ccccccreated"+tvaEntities);
			return tvaEntities;}
		else	{System.out.print("nnnnnnnnuuuuuuuuuuuuuuuuumllllllllllllllllll");
		return null;}
	}

	@Override
	public boolean checkIfExiste(TvaEntity tvaEntity) {
		TvaEntity tvaEntityByCode=tvaRepository.findByCode(tvaEntity.getCode());
		TvaEntity tvaEntityByValue=	tvaRepository.findByValue(tvaEntity.getValue());	
		return (tvaEntityByCode!=null || tvaEntityByValue!=null);
	}

}
