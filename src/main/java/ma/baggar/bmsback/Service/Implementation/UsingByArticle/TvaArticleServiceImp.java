package ma.baggar.bmsback.Service.Implementation.UsingByArticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.UsingByAricle.TvaDao;
import ma.baggar.bmsback.Entity.TvaEntity;
import ma.baggar.bmsback.Service.UsingByArticle.TvaArtcileService;

@Service
public class TvaArticleServiceImp implements TvaArtcileService {
	@Autowired
TvaDao tvaDao;
	@Override
	public TvaEntity createTvaEntity(TvaEntity tvaEntity) {
		
		return tvaDao.createTva(tvaEntity);
	}

	@Override
	public List<TvaEntity> getAllEntityTva() {
		
		return tvaDao.getAllTva();
	}

	@Override
	public TvaEntity getEntityTva(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
