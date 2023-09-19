package ma.baggar.bmsback.Dao;

import java.util.List;

import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Entity.Agence;

public interface AgenceDao {
AgenceDto createAgence(AgenceDto agenceDto);
List<AgenceDto> getAllAgences();
boolean checkIfExist(Agence agence);
}
