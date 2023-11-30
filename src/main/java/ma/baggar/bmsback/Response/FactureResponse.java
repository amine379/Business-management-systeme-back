package ma.baggar.bmsback.Response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class FactureResponse {
	@JsonProperty("id")
	private Long id;
	private ClientResponse client;
private String referance;
private Date dateFacture;
private ModePaymentResponse modePaymentResponse;
private List<FactureDetailResponse> factureDetails;
private BigDecimal totalHt;
private BigDecimal totalTtc;
private BigDecimal remise;
private BigDecimal tva;
private String remarque;
}
