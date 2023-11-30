package ma.baggar.bmsback.exception.Agence;

public class AgenceNotFoundException extends RuntimeException{
    public AgenceNotFoundException() {
    }

    public AgenceNotFoundException(String message) {
        super(message);
    }

}
