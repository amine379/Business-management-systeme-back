package ma.baggar.bmsback.Request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.PaymentReception;
@Data @AllArgsConstructor @NoArgsConstructor @Setter
public class ReceptionRequest {
	@NotNull
	private Date date_doc;
	private Date date_echeance;
	@NotNull
	private Double prix_Ht;
	@NotNull
	private Double prix_TTC;
	private Double Remise;
	private String Remarque;
	private List<Double> prixTtc=new ArrayList<>();
	private Double fret;
	@NotNull
	private List<Double> quantite=new ArrayList<>();
	@NotNull
	private Agence agence;
	@NotNull
	private List<Article> articles;
	@NotNull
	private Fournisseur fournisseur;
	private PaymentReception paymentReception;
}
