package ma.baggar.bmsback.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.AgenceDao;
import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Service.AgenceService;
@Service
public class AgenceServiceImp implements AgenceService {
	@Autowired
 AgenceDao agenceDao;

	@Override
	public AgenceDto CreateAgence(AgenceDto agenceDto) {
		// TODO Auto-generated method stub
		return agenceDao.createAgence(agenceDto);
	}

	@Override
	public List<AgenceDto> getAllAgences() {
		
		return agenceDao.getAllAgences();
	}

}
