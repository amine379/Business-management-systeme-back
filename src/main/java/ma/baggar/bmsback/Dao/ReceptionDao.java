package ma.baggar.bmsback.Dao;

import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Reception;

public interface ReceptionDao {
ReceptionDto saveReception(ReceptionDto receptionDto);
boolean checkIfExiste(Reception reception);
}
