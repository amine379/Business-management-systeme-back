package ma.baggar.bmsback.Dao;

import java.util.List;

import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Entity.Agence;

public interface AgenceDao {
AgenceDto createAgence(AgenceDto agenceDto);
List<AgenceDto> getAllAgences();
AgenceDto updateAgence(int id,AgenceDto agenceDto);
void deleteAgence(int id);
boolean checkIfExist(Agence agence);
}
