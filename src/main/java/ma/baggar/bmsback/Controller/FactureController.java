package ma.baggar.bmsback.Controller;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Dto.FactureDto;
import ma.baggar.bmsback.Request.FactureRequest;
import ma.baggar.bmsback.Response.FactureResponse;
import ma.baggar.bmsback.Service.FactureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/facture")
public class FactureController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FactureService factureService;
    @GetMapping
    public List<FactureResponse> getAllFacture(){
        return null;
    }
    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public  FactureResponse createFacture(@RequestBody @Valid FactureRequest factureRequest){
        FactureDto factureDto=modelMapper.map(factureRequest,FactureDto.class);
       FactureDto factureDtoCreated= factureService.createFacture(factureDto);
       return modelMapper.map(factureDtoCreated,FactureResponse.class);
    }
}
