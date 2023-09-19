package ma.baggar.bmsback.Response;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AgenceResponse {
	@JsonProperty("id")
private int id;
private String name;
//private List<Fournisseur> fournisseur;
//private List<Article> articles;
//private List<Reception> receptions;
}
