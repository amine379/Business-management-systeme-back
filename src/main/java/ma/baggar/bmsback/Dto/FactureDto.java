package ma.baggar.bmsback.Dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.ModePayment;
@AllArgsConstructor @NoArgsConstructor @Data
public class FactureDto {
	@JsonProperty("id")
	private Long id;
	
	private ClientDto client;
private String referance;
private Date dateFacture;
private ModePayment modePayment;
private List<FactureDetailDto> factureDetails;
private BigDecimal totalHt;
private BigDecimal totalTtc;
private BigDecimal remise;
private BigDecimal tva;
private String remarque;

	public FactureDto( ClientDto clientDto, String referance, Date dateFacture, ModePayment modePayment, BigDecimal remise,String remarque) {

		this.client = clientDto;
		this.referance = referance;
		this.dateFacture = dateFacture;
		this.modePayment = modePayment;
		this.remise = remise;
		this.remarque=remarque;

	}
}
 