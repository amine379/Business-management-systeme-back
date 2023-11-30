package ma.baggar.bmsback.Service.Implementation;

import ma.baggar.bmsback.Dao.FactureDao;
import ma.baggar.bmsback.Dto.FactureDto;
import ma.baggar.bmsback.Service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServieImp implements FactureService {
    @Autowired
    FactureDao factureDao;
    @Override
    public FactureDto createFacture(FactureDto factureDto) {
        return  factureDao.createFacture(factureDto);
    }
}
