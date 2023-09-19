package ma.baggar.bmsback.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class TvaResponse {
	@JsonProperty("id")
private int id;
private String code;
private Double value;
}
