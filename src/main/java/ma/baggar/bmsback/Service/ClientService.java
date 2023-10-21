package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Entity.Client;
import ma.baggar.bmsback.Request.ClientRequest;
import ma.baggar.bmsback.Response.ClientResponse;

public interface ClientService {
void createClient(ClientRequest clientRequest);
ClientResponse updateClient(ClientRequest clientRequest);
boolean deleteClient(int id);
List<ClientResponse> getAllClient();
boolean checkIfClientExist(Client client);

}
