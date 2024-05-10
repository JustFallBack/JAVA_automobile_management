package exceptions;

/*
 * Sera levée dans le cas pour lequel l’utilisateur tentera de créer un client avec un age négatif.
 */
public class GestionAutomobileClientsParticuliersException extends GestionAutomobileClientsException {
    public GestionAutomobileClientsParticuliersException(String s) {
        super(s);
    }
}
