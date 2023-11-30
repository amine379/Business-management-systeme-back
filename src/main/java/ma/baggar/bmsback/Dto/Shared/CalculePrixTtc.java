package ma.baggar.bmsback.Dto.Shared;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component

public class CalculePrixTtc {
public BigDecimal calcule(BigDecimal pu, double tva, double qte){
	BigDecimal tvaBigDecimal = BigDecimal.valueOf(tva);
	BigDecimal qteBigDecimal = BigDecimal.valueOf(qte);

	// Calculate the result with BigDecimal
	BigDecimal result = pu.multiply(qteBigDecimal).multiply(BigDecimal.ONE.add(tvaBigDecimal));

	return result;
}
}
