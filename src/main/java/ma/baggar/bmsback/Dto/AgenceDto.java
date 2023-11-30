package ma.baggar.bmsback.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AgenceDto {
	private int id;
	private String name;
	private List<FournisseurDto> fournisseur;
	private List<ArticleDto> article;
	private List<ReceptionDto> reception;
}
