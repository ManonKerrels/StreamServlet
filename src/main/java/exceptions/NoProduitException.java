package exceptions;

public class NoProduitException extends RuntimeException{

    public NoProduitException() {
        super("Il n'y pas de produit.");
    }
}
