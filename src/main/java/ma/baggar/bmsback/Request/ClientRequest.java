package ma.baggar.bmsback.Request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
@Data @AllArgsConstructor @NoArgsConstructor
public class ClientRequest {
	@JsonProperty("id")
	private int id;
	@NotNull
	private String nom;
	@NotNull
	private Long ice;
	private Boolean situation=true;
	private String adress;
	private Double telephone;
	private Double resteaPayer;
	private List<Agence> agences;
}
