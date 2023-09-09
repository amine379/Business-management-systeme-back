package ma.baggar.bmsback.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.Reception;
@Data @AllArgsConstructor @NoArgsConstructor
public class AgenceDto {
	private int id;
	private String name;
	private List<Fournisseur> fournisseur;
	private List<Article> articles;
	private List<Reception> receptions;
}