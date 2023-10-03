package ma.baggar.bmsback.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Reception;
@Data @NoArgsConstructor @AllArgsConstructor
public class ReceptionDetailResponse {
	@JsonProperty("id")
public Long id;
private Article article;
private float quantite;
private float prixTtc;
private Reception reception;

}
