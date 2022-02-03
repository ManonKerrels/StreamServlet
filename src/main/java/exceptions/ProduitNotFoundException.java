package exceptions;

public class ProduitNotFoundException extends RuntimeException {

    public ProduitNotFoundException() {
        super("Le produit désiré n'est pas disponible");
    }

}
