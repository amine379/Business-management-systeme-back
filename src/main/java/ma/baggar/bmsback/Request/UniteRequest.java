package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class UniteRequest {
	@JsonProperty("id ")
	private int id;
	@NotNull
    private String name;

}
