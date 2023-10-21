package ma.baggar.bmsback.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.ReceptionDetailDto;
import ma.baggar.bmsback.Request.ReceptionDetailRequest;
import ma.baggar.bmsback.Response.ReceptionDetailResponse;
import ma.baggar.bmsback.Service.ReceptionDetailService;

@RestController @RequestMapping("receptionDetail/api")
public class ReceptionDetailController {
	@Autowired
	ReceptionDetailService receptionDetailService;
@PostMapping
public ResponseEntity<ReceptionDetailResponse> saveReceptionDetail(@RequestBody @Valid ReceptionDetailRequest detailRequest){
	ModelMapper modelMapper=new ModelMapper();
	ReceptionDetailDto receptionDetailDto=modelMapper.map(detailRequest, ReceptionDetailDto.class);
	ReceptionDetailDto receptionDetailDtoCreated=receptionDetailService.saveReceptionDetail(receptionDetailDto);
	ReceptionDetailResponse receptionDetailResponse=modelMapper.map(receptionDetailDtoCreated, ReceptionDetailResponse.class);
	return new ResponseEntity<ReceptionDetailResponse> (receptionDetailResponse,HttpStatus.CREATED);
}
}
