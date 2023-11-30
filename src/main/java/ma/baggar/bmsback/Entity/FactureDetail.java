package ma.baggar.bmsback.Entity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity @Table(name = "factureDetail")
@Data @AllArgsConstructor @NoArgsConstructor
public class FactureDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@ManyToOne
private Article article;
	@Column(nullable = false)
private double quantityOfArticle;
private BigDecimal prixHt;
private BigDecimal prxiTtc;
	@ManyToOne
	private Facture facture;
	private double tvaValue;

}
