package ma.baggar.bmsback.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.ReceptionDetailDao;
import ma.baggar.bmsback.Dto.ReceptionDetailDto;
import ma.baggar.bmsback.Service.ReceptionDetailService;
@Service
public class ReceptionDetailServiceImp implements ReceptionDetailService {
	@Autowired
ReceptionDetailDao receptionDetailDao;
	@Override
	public ReceptionDetailDto saveReceptionDetail(ReceptionDetailDto receptionDetailDto) {
		// TODO Auto-generated method stub
		return receptionDetailDao.saveReceptionDetail(receptionDetailDto);
	}

}
