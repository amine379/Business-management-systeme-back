package ma.baggar.bmsback.Service.Implementation;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.ReceptionDetail;
import ma.baggar.bmsback.Service.ReceptionService;
@Service
public class ReceptionServiceImp implements ReceptionService {
	@Autowired
ReceptionDao receptionDao;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		List<ReceptionDetail> receptionDetails=receptionDto.getReceptionDetails().stream()
				.map(receptionDetailDto->modelMapper.map
						(receptionDetailDto,ReceptionDetail.class))
				.collect(Collectors.toList());

		for(ReceptionDetail receptionDetail:receptionDetails) {
			receptionDetail.setPrixTtc(
					getPrixTtcOfArticle(
							receptionDetail.getArticle().getPurchase_price(),
							receptionDetail.getQuantite() ,
							receptionDetail.getArticle().getTva().getValue()));
					
		}

		receptionDto.setReceptionDetails(receptionDetails);
		receptionDto.setTotalHt(calculePrixHt(getListOfPrixHtFromReceptionDetails(receptionDetails)));
		receptionDto.setTotalTtc(
				calculePrixTtc(getListOfPrixTtcFromReceptionDetails(receptionDetails),
						receptionDto.getFret(), receptionDto.getRemise()));
		
		
		return receptionDao.saveReception(receptionDto);
	}
	@Override
	public List<ReceptionDto> getAllReception() {
		// TODO Auto-generated method stub
		return receptionDao.getallReception();
	}
	@Override
	public BigDecimal getPrixTtcOfArticle(BigDecimal prixAchat, float quantite, double tvaValue) {

		BigDecimal tvaBigDecimal = BigDecimal.valueOf(tvaValue);
		BigDecimal qteBigDecimal = BigDecimal.valueOf(quantite);
		return prixAchat.multiply(qteBigDecimal).multiply(BigDecimal.ONE.add(tvaBigDecimal));
	}
	@Override
	public BigDecimal calculePrixHt(List<BigDecimal> prixHt) {
		BigDecimal prixHtTotal=BigDecimal.ZERO;
		for(BigDecimal prix:prixHt) {
			prixHtTotal=prixHtTotal.add(prix);
		}
		return prixHtTotal;
	}
	@Override
	public BigDecimal calculePrixTtc(List<BigDecimal> prixTtc, BigDecimal fret, BigDecimal remise) {
		BigDecimal prixTtcTotal=BigDecimal.ZERO;
		for(BigDecimal prix:prixTtc) {
			prixTtcTotal=prixTtcTotal.add(prix);
		}
		return( prixTtcTotal.add(fret)).subtract(remise);
	}
	@Override
	public List<BigDecimal> getListOfPrixHtFromReceptionDetails(List<ReceptionDetail> receptionDetails) {
		List<BigDecimal> prixHt=new ArrayList<>();
		for(ReceptionDetail receptionDetail:receptionDetails) {
		prixHt.add(receptionDetail.getArticle().getPurchase_price());
		}
		return prixHt;
	}
	@Override
	public List<BigDecimal> getListOfPrixTtcFromReceptionDetails(List<ReceptionDetail> receptionDetails) {
		List<BigDecimal> prixTtc=new ArrayList<>();
		for(ReceptionDetail receptionDetail:receptionDetails) {
			prixTtc.add(receptionDetail.getPrixTtc());
		}
		return prixTtc;
	}

}
