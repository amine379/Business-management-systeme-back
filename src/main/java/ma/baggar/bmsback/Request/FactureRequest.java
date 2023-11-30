package ma.baggar.bmsback.Request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Dto.FactureDetailDto;
@Data @AllArgsConstructor @NoArgsConstructor
public class FactureRequest {
	@JsonProperty("id")
	private Long id;
	@NotNull(message = "ajouter le client")
	private ClientRequest client;
	@NotNull(message ="il faut ajouter la referance" )
private String referance;
	@NotNull(message ="il faut ajouter la date de facture" )
private Date dateFacture;
private ModePaymentRequest modePayment;
@NotNull(message = "ajouter la liste des disignation")
private List<FactureRequest> factureDetails;
private String remarque;

}
