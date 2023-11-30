package ma.baggar.bmsback.Dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.PaymentReception;
import ma.baggar.bmsback.Entity.ReceptionDetail;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReceptionDto {
	private Long id;
	private Date dateDoc;
	private Date dateEcheance;
	private BigDecimal totalHt;
	private BigDecimal totalTtc;
	private BigDecimal remise;
	private String Remarque;
	private String factureRef;
	private BigDecimal fret;
	private AgenceDto agence;
	private FournisseurDto fournisseur;
	private PaymentReception paymentReception;
	private List<ReceptionDetailDto> receptionDetails;
	public ReceptionDto( Date dateDoc,
					  Date dateEcheance,
					  BigDecimal remise,
					  String remarque,
					  String factureRef,
					  BigDecimal fret,
					  AgenceDto agence,
					  FournisseurDto fournisseur,
					  PaymentReception paymentReception) {
		this.dateDoc = dateDoc;
		this.dateEcheance = dateEcheance;
		this.remise = remise;
		Remarque = remarque;
		this.factureRef = factureRef;
		this.fret = fret;
		this.agence = agence;
		this.fournisseur = fournisseur;
		this.paymentReception = paymentReception;
	}
}
