package ma.baggar.bmsback.Service;

import java.math.BigDecimal;
import java.util.List;

import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.ReceptionDetail;

public interface ReceptionService {
ReceptionDto saveReception(ReceptionDto receptionDto);
List<ReceptionDto> getAllReception();
BigDecimal getPrixTtcOfArticle(BigDecimal prixAchat, float quantite, double tvaValue);
BigDecimal calculePrixHt(List<BigDecimal> prixHt);
BigDecimal calculePrixTtc(List<BigDecimal> prixTtc,BigDecimal fret,BigDecimal remise);
List<BigDecimal> getListOfPrixHtFromReceptionDetails(List<ReceptionDetail> receptionDetails );
List<BigDecimal> getListOfPrixTtcFromReceptionDetails(List<ReceptionDetail> receptionDetails );

}
