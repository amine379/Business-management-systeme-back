package ma.baggar.bmsback.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class ClientDto {
	@JsonProperty("id")
	private int id;
	private String nom;
	private String ice;
	private Boolean situation=true;
	private String adress;
	private Double telephone;
	private Double resteaPayer;
	private List<AgenceDto> agenceDtos;
}
