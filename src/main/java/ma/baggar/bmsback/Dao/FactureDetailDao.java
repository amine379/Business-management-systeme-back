package ma.baggar.bmsback.Dao;

import ma.baggar.bmsback.Dto.FactureDetailDto;
import ma.baggar.bmsback.Entity.Facture;

public interface FactureDetailDao {
FactureDetailDto createFactureDetail(FactureDetailDto factureDetailDto);
FactureDetailDto createFactureDetailForFacture(Facture Facture, FactureDetailDto factureDetailDto);
}
