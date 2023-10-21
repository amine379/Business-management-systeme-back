package ma.baggar.bmsback.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.baggar.bmsback.Request.ClientRequest;
import ma.baggar.bmsback.Response.ClientResponse;
import ma.baggar.bmsback.Service.ClientService;

@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
public class ClientController {
private final ClientService clientService;

@PostMapping
@ResponseStatus(HttpStatus.BAD_REQUEST)
public void createClient(@RequestBody @Valid ClientRequest clientRequest){
	clientService.createClient(clientRequest);
}
@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<ClientResponse> getAllClient(){
return clientService.getAllClient();	
}

}
