package ma.baggar.bmsback.Response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ma.baggar.bmsback.Entity.Article;

public class UniteResponse {
	@JsonProperty("id ")
	private int id;
    private String name;
	private List<Article> article;
}
