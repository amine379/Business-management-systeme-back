package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.ReceptionDetail;

public interface ReceptionService {
ReceptionDto saveReception(ReceptionDto receptionDto);
List<ReceptionDto> getAllReception();
double getPrixTtcOfArticle(double prixAchat,float quantite,double tvaValue);
double calculePrixHt(List<Double> prixHt);
double calculePrixTtc(List<Double> prixTtc,double fret,double remise);
List<Double> getListOfPrixHtFromReceptionDetails(List<ReceptionDetail> receptionDetails );
List<Double> getListOfPrixTtcFromReceptionDetails(List<ReceptionDetail> receptionDetails );



}
