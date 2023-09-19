package ma.baggar.bmsback.Dao.Implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Reception;
import ma.baggar.bmsback.Repository.ReceptionRepository;
@Repository
public class ReceptionDaoImp implements ReceptionDao {
	@Autowired
ReceptionRepository receptionRepository;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		ModelMapper modelMapper=new ModelMapper();
		Reception reception=modelMapper.map(receptionDto, Reception.class);
		Reception receptionSaved=receptionRepository.save(reception);
		ReceptionDto receptionDtoResponse=modelMapper.map(receptionSaved, ReceptionDto.class);
		
		return receptionDtoResponse;
	}
	@Override
	public boolean checkIfExiste(Reception reception) {
		List<Reception> fournisseurs=receptionRepository.findByFournisseur(reception.getFournisseur());
		List<Reception> dateDoc=receptionRepository.findByDateDoc(reception.getDateDoc());
		List<Reception> prixTTC=receptionRepository.findByTotalTtc(reception.getTotalTtc());
		return (fournisseurs!=null && dateDoc!=null && prixTTC!=null);
	}

}
