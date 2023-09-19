package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor @Getter
public class TvaRequest {
	@JsonProperty("id")
	private Long id;
	@NotNull
private String code;
	@NotNull
private Double value;
}
