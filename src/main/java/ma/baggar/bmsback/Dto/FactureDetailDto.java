package ma.baggar.bmsback.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;

import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor
public class FactureDetailDto {
	@JsonProperty("id")
private Long id;
private Article article;
private double  quantity;
private BigDecimal prixHt;
private BigDecimal prxiTtc;
private FactureDto facture;
private double tvaValue;
}
