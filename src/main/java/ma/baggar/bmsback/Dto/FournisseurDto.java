package ma.baggar.bmsback.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Reception;
@Data @NoArgsConstructor @AllArgsConstructor
public class FournisseurDto {
     private int id;
	private String nom;
	private Long ice;
	private Boolean situation=true;
	private String adress;
	private Double telephone;
	private Double resteaPayer;
	private List<ArticleDto> article;
	private List<ReceptionDto> reception;
	private List<AgenceDto> agences;

}
