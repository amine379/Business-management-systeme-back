package ma.baggar.bmsback.Response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.PaymentReception;
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ReceptionResponse {
	private Date date_doc;
	private Date date_echeance;
	private Double prix_Ht;
	private Double prix_TTC;
	private Double Remise;
	private String Remarque;
	private List<Double> prixTtc=new ArrayList<>();
	private Double fret;
	private List<Double> quantite=new ArrayList<>();
	private Agence agence;
	private List<Article> articles;
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;

}
