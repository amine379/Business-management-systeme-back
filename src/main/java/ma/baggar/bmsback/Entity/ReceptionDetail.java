package ma.baggar.bmsback.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ReceptionDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;
	@ManyToOne @NotNull(message = "ajouter l article")
private Article article;
	@NotNull(message = "il faut ajouter la quantité")
private float quantite;
private double prixTtc;
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "reception_id", nullable = false)
@JsonIgnore 
private Reception reception;
}
