package ma.baggar.bmsback.exception.Article;

import org.modelmapper.spi.ErrorMessage;

import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Error.ErrorMessages;

public class AlReadyExistException extends RuntimeException{
	String message;
	public AlReadyExistException() {
		super(ErrorMessages.RECORD_ALREADY_EXISTS +".Entity"+Article.class.getSimpleName());
	}
	public AlReadyExistException(String msg) {
		super(msg);
		this.message=msg;
	}

}
