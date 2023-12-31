package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class UniteRequest {
	@JsonProperty("id ")
	private int id;
	@NotNull
    private String name;

}
