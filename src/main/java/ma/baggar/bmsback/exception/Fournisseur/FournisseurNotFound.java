package ma.baggar.bmsback.exception.Fournisseur;

public class FournisseurNotFound extends RuntimeException{
    public FournisseurNotFound() {
    }

    public FournisseurNotFound(String message) {
        super(message);
    }

}
