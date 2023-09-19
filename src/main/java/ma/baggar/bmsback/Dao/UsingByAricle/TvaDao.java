package ma.baggar.bmsback.Dao.UsingByAricle;

import java.util.List;

import ma.baggar.bmsback.Entity.TvaEntity;

public interface TvaDao {
TvaEntity createTva(TvaEntity tvaEntity);
List<TvaEntity> getAllTva();
boolean checkIfExiste(TvaEntity tvaEntity);

}
