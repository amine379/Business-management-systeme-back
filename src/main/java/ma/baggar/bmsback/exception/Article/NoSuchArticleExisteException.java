package ma.baggar.bmsback.exception.Article;

import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Error.ErrorMessages;

public class NoSuchArticleExisteException extends RuntimeException {
	
private String message;

public NoSuchArticleExisteException() {	
	super(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()+".entite"+Article.class.getSimpleName());
}
public NoSuchArticleExisteException(String msg) {
	 super(msg);
     this.message = msg;
}
}
