package ma.baggar.bmsback.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientResponse {
	private int id;
	private String nom;
	private Long ice;
	private Boolean situation=true;
	private String adress;
	private Double telephone;
	private Double resteaPayer;
	private List<Agence> agences;
}
