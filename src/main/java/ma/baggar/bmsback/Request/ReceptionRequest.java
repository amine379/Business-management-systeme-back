package ma.baggar.bmsback.Request;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.PaymentReception;

@Data @AllArgsConstructor @NoArgsConstructor @Setter
public class ReceptionRequest {
	@JsonProperty("id")
	private int id;
	@NotNull
	private Date dateDoc;
	private Date dateEcheance;
	@NotNull
	private Double totalHt;
	@NotNull
	private Double totalTtc;
	private Double Remise;
	private String Remarque;
	@NotNull
	private String factureRef;
	private Double fret;
	@NotNull
	private Agence agence;
	@NotNull
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
	@NotNull
	private List<Long> receptionDetailIds;

}
