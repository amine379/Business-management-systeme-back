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
import ma.baggar.bmsback.Entity.ReceptionDetail;

@Data @AllArgsConstructor @NoArgsConstructor @Setter
public class ReceptionRequest {
	@JsonProperty("id")
	private int id;
	@NotNull(message = "il faut ajouter la date de document")
	private Date dateDoc;
	private Date dateEcheance;
	private Double Remise;
	private String Remarque;
	@NotNull(message = "il faut ajouter la reference de la facture")
	private String factureRef;
	private Double fret;
	@NotNull (message = "il faut ajouter l'agence")
	private Agence agence;
	@NotNull(message = "il faut ajouter le fournisseur")
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
	@NotNull
	private List<ReceptionDetail> receptionDetailIds;

}
