package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.ReceptionDto;

public interface ReceptionService {
ReceptionDto saveReception(ReceptionDto receptionDto);
List<ReceptionDto> getAllReception();
}
