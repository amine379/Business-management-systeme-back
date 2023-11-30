package ma.baggar.bmsback.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class ArticleSousFamilleResponse {
	@JsonProperty("id ")
private int id;
private String name;
private ArticleFamilleResponse articleFamilleResponse;
private List<ArticleResponse> articlesArticleResponses;
}
