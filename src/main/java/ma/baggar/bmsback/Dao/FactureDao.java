package ma.baggar.bmsback.Dao;

import ma.baggar.bmsback.Dto.FactureDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface FactureDao {
FactureDto createFacture(FactureDto factureDto);
FactureDto CalculeFacture(Long factureId, BigDecimal prixHt,BigDecimal prixTtc);
List<FactureDto> getAllFacture();
List<FactureDto> getFactureByClient(int clientId);
FactureDto getFactureByReferance(String refetence);
List<FactureDto> getFactureByDate(Date dateFacture);
void deleteFacture(int id);
}
