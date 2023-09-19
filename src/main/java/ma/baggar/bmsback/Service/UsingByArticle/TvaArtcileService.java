package ma.baggar.bmsback.Service.UsingByArticle;

import java.util.List;

import ma.baggar.bmsback.Entity.TvaEntity;

public interface TvaArtcileService {
	TvaEntity createTvaEntity(TvaEntity tvaEntity);
	List<TvaEntity> getAllEntityTva();
	TvaEntity getEntityTva(int id);
}
