package ma.baggar.bmsback.exception.Facture;

public class FactureNotFoundException extends RuntimeException{
    String msg;
    public FactureNotFoundException() {
    }

    public FactureNotFoundException(String message) {
        super(message);
        this.msg=message;
    }
}
