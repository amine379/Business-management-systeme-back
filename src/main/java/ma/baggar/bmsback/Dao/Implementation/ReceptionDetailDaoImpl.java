package ma.baggar.bmsback.Dao.Implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.ReceptionDetailDao;
import ma.baggar.bmsback.Dto.ReceptionDetailDto;
import ma.baggar.bmsback.Entity.ReceptionDetail;
import ma.baggar.bmsback.Repository.ReceptionDetailRepository;
@Repository
public class ReceptionDetailDaoImpl implements ReceptionDetailDao {
	@Autowired
ReceptionDetailRepository receptionDetailRepository;
	@Override
	public ReceptionDetailDto saveReceptionDetail(ReceptionDetailDto receptionDetailDto) {
		ModelMapper modelMapper=new ModelMapper();
		ReceptionDetail receptionDetail=modelMapper.map(receptionDetailDto,ReceptionDetail.class);
		ReceptionDetail receptionDetailCreated=receptionDetailRepository.save(receptionDetail);
		ReceptionDetailDto receptionDetailDtoCreated=modelMapper.map(receptionDetailCreated, ReceptionDetailDto.class);
		return receptionDetailDtoCreated;
	}

}
