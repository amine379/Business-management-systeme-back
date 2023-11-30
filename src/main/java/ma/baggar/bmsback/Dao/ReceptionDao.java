package ma.baggar.bmsback.Dao;

import java.util.List;

import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Reception;

public interface ReceptionDao {
ReceptionDto saveReception(ReceptionDto receptionDto);
ReceptionDto saveReceptionWithReceptionDetails(ReceptionDto receptionDto);
List<ReceptionDto> getallReception();
boolean checkIfExiste(Reception reception);
}
