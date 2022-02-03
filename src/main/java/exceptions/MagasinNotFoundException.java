package exceptions;

public class MagasinNotFoundException extends RuntimeException {

    private final int id;

    public MagasinNotFoundException(int id) {
        super("Le magasin " + id + " n'a pas été trouvé.");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
