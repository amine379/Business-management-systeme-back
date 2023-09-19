package ma.baggar.bmsback.Request;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;

@Data @AllArgsConstructor @NoArgsConstructor
public class FournisseurRequest {
	@JsonProperty("id")
	private Long id;
@NotNull
	private String nom;
@NotNull 
	private Long ice;
	private String Adress;
	private Double telephone;
	private String countrie;
	private Boolean situation;
	private Double resteaPayer;
	public List<Integer> agenceIds;
	
	
}
