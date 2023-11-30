package ma.baggar.bmsback.Dto.UsingByArticles;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Dto.ArticleDto;
@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleSousFamilleDto {
	private int id;
private String name;
private ArticleFamilleDto articleFamilleDto;
	private List<ArticleDto> articlesDtos;
}
