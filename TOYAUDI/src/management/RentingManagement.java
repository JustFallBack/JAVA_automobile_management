package management;

import vehicle.*;

/**
 * Écrivez ensuite une classe GestionLocation qui sera composée des méthodes demandeDeLocation et getTarif qui 
 * prendront en paramètre une voiture et un client et de la méthode finDeLocation qui elle aura comme argument, 
 * en plus des deux précédents, la date et le kilométrage de fin de location. Ajoutez aux véhicules les attributs 
 * kilometrageFin et dateFin nécessaire à l’estimation du tarif de location. demandeDeLocation permettra d’ajouter 
 * le véhicule dans les collections adéquats de Gestion (fin de location, disponible à la vente au vu du nouveau 
 * kilométrage ?, mise-à-jour de la date de début de location pour le client, etc.) et d’incrémenter le nombre de 
 * locations déjà effectuées par le client particulier (retourne true si tout c’est bien passé). Cette méthode vérifera 
 * si le véhicule est contenu dans la liste des véhicules disponibles (HashSet) de la classe Gestion à l’aide de la méthode 
 * contains. Modifez votre code pour permettre cela. finDeLocation mettra à jour les collections de la classe Gestion et 
 * retournera la facture à l’aide de la méthode getTarif explicitée ci-après.
 */
public class RentingManagement {
    
    public void rentalRequest(SpecificVehicle vehicle) {

    }
}
