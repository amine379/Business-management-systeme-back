package ma.baggar.bmsback.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.Entity.Reception;
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AgenceDto {
	private int id;
	private String name;
	private List<Fournisseur> fournisseur;
	private List<Article> articles;
	private List<Reception> receptions;
}
