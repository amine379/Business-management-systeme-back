package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Reception;
@Data @AllArgsConstructor @NoArgsConstructor
public class ReceptionDetailRequest {
	@JsonProperty("id")
public Long id;
	@NotNull
private Article article;
	@NotNull
private float quantite;
	@NotNull
private float prixTtc;
 @NotNull
private Reception reception;
}
