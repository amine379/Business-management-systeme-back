package ma.baggar.bmsback.exception.Agence;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException() {
        super();
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
