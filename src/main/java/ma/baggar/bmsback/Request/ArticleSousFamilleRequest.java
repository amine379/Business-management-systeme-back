package ma.baggar.bmsback.Request;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor 
public class ArticleSousFamilleRequest {
	@JsonProperty("id ")
	private int id;
	@NotNull(message = "ajouter le nom de sousFamille")
private String name;
	@NotNull(message = "ajouter l article famille")
private ArticleFamilleRequest articleFamilleRequest;
}
