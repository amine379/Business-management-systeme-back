package ma.baggar.bmsback.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Reception;
@Data @AllArgsConstructor @NoArgsConstructor
public class FournisseurResponse {
	@JsonProperty("id")
	private Long id;
	private String nom;
	private Long ice;
	private String Adress;
	private Double telephone;
	private String countrie;
	private Boolean situation;
	private Double resteaPayer;
	private List<Reception> Receptions;
	private List<Article> articles;
	private List<Agence> agences;
}
