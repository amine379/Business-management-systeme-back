package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ArticleFamilleRequest {
	@JsonProperty("id")
	private int id;
@NotNull
private String name;

}
