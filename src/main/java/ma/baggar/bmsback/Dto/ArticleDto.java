package ma.baggar.bmsback.Dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.TvaEntity;

@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleDto {
	private Long id;
	@NotNull
	private String name;
	
	private Double purchase_price;
	private Double selling_price;
	private TvaEntity tva;
	private float Stock;
	@NotNull
	private boolean situation;
//il faut ajouter not null
	@NotNull
	int id_unite;
	int id_famille;
	int id_sousFamille;
	List<Integer> agenceIds;
	List<Integer> fournisseurIds;
}
