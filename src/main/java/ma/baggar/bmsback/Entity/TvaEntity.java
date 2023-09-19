package ma.baggar.bmsback.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class TvaEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Column(nullable = false)
private String code="20%";
	@Column(nullable = false)
private Double value=0.2;
	@OneToMany (mappedBy = "tva",cascade = CascadeType.ALL)
	private List<Article> articles;
}
