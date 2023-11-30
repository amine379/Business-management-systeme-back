package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor
public class FactureDetailRequest {
	@JsonProperty("id")
	private Long id;
private ArticleRequest article;
@NotNull(message = "ajouter la quantité")
private float quantity;
@NotNull(message = "il faut ajouté le prixHt de produit")
private BigDecimal prixHt;
private BigDecimal prxiTtc;
private FactureRequest facture;
@NotNull(message = "ajouter la tva ")
private double tvaValue;
}
