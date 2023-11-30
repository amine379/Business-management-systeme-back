package ma.baggar.bmsback.Dao.Implementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ma.baggar.bmsback.Dto.ReceptionDetailDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Reception;
import ma.baggar.bmsback.Entity.ReceptionDetail;
import ma.baggar.bmsback.Repository.ReceptionDetailRepository;
import ma.baggar.bmsback.Repository.ReceptionRepository;
import ma.baggar.bmsback.exception.Reception.ReceptionExistsException;
@Repository
public class ReceptionDaoImp implements ReceptionDao {
	@Autowired
  ReceptionRepository receptionRepository;
	@Autowired
	ReceptionDetailRepository receptionDetailRepository;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto)  {
		List<ReceptionDetail> receptionDetails=new ArrayList<>();
		if(receptionDto.getReceptionDetails()==null || receptionDto.getReceptionDetails().isEmpty())
		{
			throw new IllegalArgumentException("Reception must have at least one Reception detail.");
		}
		List<ReceptionDetailDto> receptionDetailDtos=receptionDto.getReceptionDetails();
		ReceptionDto receptionDtoBeforAddReceptionDetails=new ReceptionDto(
				receptionDto.getDateDoc(),receptionDto.getDateEcheance(),receptionDto.getRemise(),
				receptionDto.getRemarque(),receptionDto.getFactureRef(),receptionDto.getFret(),
				receptionDto.getAgence(),receptionDto.getFournisseur(),receptionDto.getPaymentReception()
		);
		Reception reception=modelMapper.map(receptionDtoBeforAddReceptionDetails,Reception.class);
		Reception receptionCreated=receptionRepository.save(reception);
		ReceptionDto receptionDtoCreated=modelMapper.map(receptionCreated,ReceptionDto.class);
		BigDecimal totalHtFacture = BigDecimal.ZERO;
		BigDecimal totalTtcFacture = BigDecimal.ZERO;
		for(ReceptionDetailDto receptionDetail:receptionDto.getReceptionDetails()){
			if(Float.isNaN(receptionDetail.getQuantite())){throw new RuntimeException("quantité est un champs obligatoire");}
			receptionDetail.setReception(receptionDtoCreated);
			receptionDetail.setPrixTtc(cal);

		}



		/*=====================yarabbbbak==================*/
		for(ReceptionDetail receptionDetail:receptionDto.getReceptionDetails()) {
		receptionDetails.add(receptionDetailRepository.save(receptionDetail));
			}
		receptionDto.setReceptionDetails(receptionDetails);
		Reception reception=modelMapper.map(receptionDto, Reception.class);
		if(!checkIfExiste(reception)) {
		Reception receptionCreated=receptionRepository.save(reception);
		ReceptionDto receptionDtoCreated=modelMapper.map(receptionCreated, ReceptionDto.class);
		return receptionDtoCreated;
		}
		else   
			throw new ReceptionExistsException("Reception already exists");
			
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
		List<Reception> receptions=receptionRepository.findAll();
		for(Reception reception:receptions) {
			ReceptionDto  receptionDto=modelMapper.map(reception, ReceptionDto.class);
			receptionDtos.add(receptionDto);
		}
		return receptionDtos;
	}

}
