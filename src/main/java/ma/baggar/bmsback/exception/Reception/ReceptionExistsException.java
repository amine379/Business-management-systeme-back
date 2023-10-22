package ma.baggar.bmsback.exception.Reception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.CONFLICT)
public class ReceptionExistsException extends RuntimeException {
	 public ReceptionExistsException(String message) {
	        super(message);
	    }
}
