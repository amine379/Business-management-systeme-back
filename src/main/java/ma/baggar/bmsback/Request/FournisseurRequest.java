package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class FournisseurRequest {
	@JsonProperty("id")
	private Long id;
@NotNull
	private String nom;
@NotNull 
	private Long Ice;
	private String Adress;
	private Double telephone;
	private String countrie;
	private Boolean situation;
	private Double resteaPayer;
}
