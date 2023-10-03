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
	private Date date_doc;
	private Date date_echeance;
	private Double totalHt;
	private Double totalTtc;
	private Double Remise;
	private String factureRef;
	private String Remarque;
	private Double tva;
	private Double fret;
	private Agence agence;
	private List<ReceptionDetail> receptionDetails;
	private List<Long> receptionDetailIds;
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
}
