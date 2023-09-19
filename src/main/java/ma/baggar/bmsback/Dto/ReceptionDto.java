package ma.baggar.bmsback.Dto;

import java.sql.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.PaymentReception;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReceptionDto {
	private Date date_doc;
	private Date date_echeance;
	private Double totalHt;
	private Double totalTtc;
	private List<Double> quantite;
	private List<Double> prixTtc;
	private Double Remise;
	private String Remarque;
	private Double tva;
	private Double fret;
	private Agence agence;
	private List<Article> articles;
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
}
