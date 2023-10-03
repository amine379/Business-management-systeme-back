package ma.baggar.bmsback.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
@Data @AllArgsConstructor @NoArgsConstructor
public class UniteResponse {
	@JsonProperty("id ")
	private int id;
    private String name;
	private List<Article> article;
}
