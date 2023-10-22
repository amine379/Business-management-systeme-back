package ma.baggar.bmsback.Service.Implementation;


import java.util.ArrayList;
import java.util.List;

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
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		List<ReceptionDetail> receptionDetails=receptionDto.getReceptionDetails();
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
	public double getPrixTtcOfArticle(double prixAchat, float quantite, double tvaValue) {
		return ((prixAchat*quantite)*(1+tvaValue));
	}
	@Override
	public double calculePrixHt(List<Double> prixHt) {
		double prixHtTotal=0;
		for(double prix:prixHt) {
			prixHtTotal+=prix;
		}
		return prixHtTotal;
	}
	@Override
	public double calculePrixTtc(List<Double> prixTtc, double fret, double remise) {
		double prixTtcTotal=0;
		for(double prix:prixTtc) {
			prixTtcTotal+=prix;
		}
		return prixTtcTotal+fret-remise;
	}
	@Override
	public List<Double> getListOfPrixHtFromReceptionDetails(List<ReceptionDetail> receptionDetails) {
		List<Double> prixHt=new ArrayList<>();
		for(ReceptionDetail receptionDetail:receptionDetails) {
		prixHt.add(receptionDetail.getArticle().getPurchase_price());
		}
		return prixHt;
	}
	@Override
	public List<Double> getListOfPrixTtcFromReceptionDetails(List<ReceptionDetail> receptionDetails) {
		List<Double> prixTtc=new ArrayList<>();
		for(ReceptionDetail receptionDetail:receptionDetails) {
			prixTtc.add(receptionDetail.getPrixTtc());
		}
		return prixTtc;
	}

}
