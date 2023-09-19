package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.AgenceDto;

public interface AgenceService {
AgenceDto CreateAgence(AgenceDto agenceDto);
List<AgenceDto> getAllAgences();
}
