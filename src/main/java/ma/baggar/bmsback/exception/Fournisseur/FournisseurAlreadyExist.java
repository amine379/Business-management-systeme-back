package ma.baggar.bmsback.exception.Fournisseur;

public class FournisseurAlreadyExist extends  RuntimeException{
    public FournisseurAlreadyExist() {
    }

    public FournisseurAlreadyExist(String message) {
        super(message);
    }


}
