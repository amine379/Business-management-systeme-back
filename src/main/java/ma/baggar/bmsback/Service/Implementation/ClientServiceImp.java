package ma.baggar.bmsback.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.baggar.bmsback.Entity.Client;
import ma.baggar.bmsback.Repository.ClientRepository;
import ma.baggar.bmsback.Request.ClientRequest;
import ma.baggar.bmsback.Response.ClientResponse;
import ma.baggar.bmsback.Service.ClientService;
 @Service
 @RequiredArgsConstructor
public class ClientServiceImp implements ClientService {
	
 private final ClientRepository clientRepository;
 
	@Override
	public void createClient(ClientRequest clientRequest) {
		ModelMapper modelMapper=new ModelMapper();
		Client client=modelMapper.map(clientRequest, Client.class);
		clientRepository.save(client);
		
	}

	@Override
	public ClientResponse updateClient(ClientRequest clientRequest) {
		ModelMapper mapper=new ModelMapper();
		Client existingClient = clientRepository.findById(clientRequest.getId());
		if(existingClient==null) {return null;}
		existingClient.setNom(clientRequest.getNom());
		existingClient.setAdress(clientRequest.getAdress());
		existingClient.setAgences(clientRequest.getAgences());
		existingClient.setTelephone(clientRequest.getTelephone());
		existingClient.setIce(clientRequest.getIce());
		existingClient.setSituation(clientRequest.getSituation());
		Client clientUpdated= clientRepository.save(existingClient);
		ClientResponse clientResponse=mapper.map(clientUpdated, ClientResponse.class);
		return clientResponse;
	}

	@Override
	public boolean  deleteClient(int id) {
		Client existingClient = clientRepository.findById(id);
		if(existingClient==null) {return false;}
		else {
			clientRepository.delete(existingClient);
			return true;
		}
	}

	@Override
	public List<ClientResponse> getAllClient() {
		List<ClientResponse> clientResponses=new ArrayList<>();
		ModelMapper modelMapper=new ModelMapper();
		List<Client> clients=clientRepository.findAll();
		for(Client client :clients) {
		ClientResponse clientResponse=modelMapper.map(client, ClientResponse.class);
		clientResponses.add(clientResponse);
	}
		return clientResponses;
		}

	@Override
	public boolean checkIfClientExist(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

}
