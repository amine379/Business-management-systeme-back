package ma.baggar.bmsback.Service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Service.ReceptionService;
@Service
public class ReceptionServiceImp implements ReceptionService {
	@Autowired
ReceptionDao receptionDao;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		return receptionDao.saveReception(receptionDto);
	}
	@Override
	public List<ReceptionDto> getAllReception() {
		// TODO Auto-generated method stub
		return receptionDao.getallReception();
	}

}
