package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Reception;
import ma.baggar.bmsback.Entity.ReceptionDetail;
import ma.baggar.bmsback.Repository.ReceptionDetailRepository;
import ma.baggar.bmsback.Repository.ReceptionRepository;
@Repository
public class ReceptionDaoImp implements ReceptionDao {
	@Autowired
ReceptionRepository receptionRepository;
	@Autowired
	ReceptionDetailRepository receptionDetailRepository;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		ModelMapper modelMapper=new ModelMapper();
		List<ReceptionDetail> receptionDetails=receptionDetailRepository.findAllById(receptionDto.getReceptionDetailIds());
		receptionDto.setReceptionDetails(receptionDetails);
		Reception reception=modelMapper.map(receptionDto, Reception.class);
		if(!checkIfExiste(reception)) {
		Reception receptionCreated=receptionRepository.save(reception);
		ReceptionDto receptionDtoCreated=modelMapper.map(receptionCreated, ReceptionDto.class);
		return receptionDtoCreated;
		}
		else return null;
	}
	
	@Override
	public boolean checkIfExiste(Reception reception) {
		List<Reception> fournisseurs=receptionRepository.findByFournisseur(reception.getFournisseur());
		List<Reception> dateDoc=receptionRepository.findByDateDoc(reception.getDateDoc());
		List<Reception> prixTTC=receptionRepository.findByTotalTtc(reception.getTotalTtc());
		return (fournisseurs!=null && dateDoc!=null && prixTTC!=null);
	}
	
	@Override
	public List<ReceptionDto> getallReception() {
		List<ReceptionDto> receptionDtos=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		List<Reception> receptions=receptionRepository.findAll();
		for(Reception reception:receptions) {
			ReceptionDto  receptionDto=modelMapper.map(reception, ReceptionDto.class);
			receptionDtos.add(receptionDto);
		}
		return receptionDtos;
	}

}
