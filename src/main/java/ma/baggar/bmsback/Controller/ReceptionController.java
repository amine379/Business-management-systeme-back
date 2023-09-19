package ma.baggar.bmsback.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Request.ReceptionRequest;
import ma.baggar.bmsback.Response.ReceptionResponse;
import ma.baggar.bmsback.Service.ReceptionService;

@RestController
@RequestMapping("api/reception")
public class ReceptionController {
	@Autowired
ReceptionService receptionService;
	public ResponseEntity<ReceptionResponse> saveReception(@RequestBody @Valid ReceptionRequest receptionRequest){
		return null;
	}
}
