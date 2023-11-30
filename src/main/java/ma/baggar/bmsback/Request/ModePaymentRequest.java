package ma.baggar.bmsback.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class ModePaymentRequest {
	@JsonProperty("id")
	private int id;
private String name;
}
