package ma.baggar.bmsback.Dto;

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
	private Double totalHt;
	private Double totalTtc;
	private Double Remise;
	private String Remarque;
	private String factureRef;
	private Double fret;
	private Agence agence;
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
	private List<ReceptionDetail> receptionDetails;
}
