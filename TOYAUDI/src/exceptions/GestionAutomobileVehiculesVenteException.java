package exceptions;

/*
 * Sera levée si on tente de vendre un véhicule pour lequel le kilométrage dépasse la valeur maximale définit
 * dans la classe Gestion. Cette classe aura un constructeur sans argument, mais initialisera le message de
 * sa classe de base «Ce véhicule n’est plus dis- ponible à la vente». Enfin, ajoutez la classe dérivée
 * GestionAutomobileVehiculesLocationException qui sera levée dans la méthode demandeDeLocation de
 * GestionLocation si on désire louer un véhicule ne fgurant pas dans la liste des véhicules disponibles à la location.
 */
public class GestionAutomobileVehiculesVenteException extends GestionAutomobileVehiculesException {
    public GestionAutomobileVehiculesVenteException() {
        super("Ce véhicule n'est plus disponible à la vente.");
    }
}
