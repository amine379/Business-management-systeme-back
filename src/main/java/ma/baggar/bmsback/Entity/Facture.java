package ma.baggar.bmsback.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name ="facture" )
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@ManyToOne
    @NotNull
	private Client client;
	@Column(nullable =false)
    private String referance;
	@Column(nullable =false)
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private Date dateFacture;
    @ManyToOne
   private ModePayment modePayment;
   @OneToMany(mappedBy = "facture")
   @NotNull
private List<FactureDetail> factureDetails;
@Column(nullable =false)
private BigDecimal totalHt;
@Column(nullable =false)
private BigDecimal totalTtc;
@Column(nullable =true)
private BigDecimal remise;
@Column(nullable =false)
private BigDecimal tva;
@Column(nullable = true)
private String remarque;
}
