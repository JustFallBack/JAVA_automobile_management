package management;

import customer.PrivateCustomer;
import customer.SpecificCustomer;
import vehicle.SpecificVehicle;
import exceptions.AutomobileManagementCustomerException;
import exceptions.AutomobileManagementDateException;
import exceptions.AutomobileManagementException;
import exceptions.AutomobileManagementVehiculesRentException;

/**
 * Écrivez ensuite une classe GestionLocation qui sera composée des méthodes demandeDeLocation et getTarif qui 
 * prendront en paramètre une voiture et un client et de la méthode finDeLocation qui elle aura comme argument, 
 * en plus des deux précédents, la date et le kilométrage de fin de location.
 * Ajoutez aux véhicules les attributs kilometrageFin et dateFin nécessaire à l’estimation du 
 * tarif de location.
 * demandeDeLocation permettra d’ajouter le véhicule dans les collections adéquats de Gestion 
 * (fin de location, disponible à la vente au vu du nouveau kilométrage ?, mise-à-jour de la date de début de location pour le client, etc.)
 * et d’incrémenter le nombre de locations déjà effectuées par le client particulier 
 * (retourne true si tout c’est bien passé). Cette méthode vérifera si le véhicule est contenu 
 * dans la liste des véhicules disponibles (HashSet) de la classe Gestion à l’aide de la méthode contains.
 * Modifez votre code pour permettre cela. 
 * finDeLocation mettra à jour les collections de la classe Gestion et retournera la facture
 * à l’aide de la méthode getTarif explicitée ci-après.
 * 
 * La méthode getTarif dans la classe GestionLocation, retournera le prix de la location dans le cas d’un client particulier 
 * ou un professionnel et dans la classe GestionVente le prix de vente. 
 * Dans le cas de la location, elle fera appel à la méthode prixLocation de la classe Gestion (à implémenter) 
 * qui permettra de retourner le prix de la location et sera égale à : 
 * reduction x (prixParKilometrePourCeTypeDeVehicule x kilometrageEffectue + prixParuourPourCeTypeDeVehicule x nombreDeuour x (1 + nombreDePortes/10) ).
 * La réduction ne peut être négative. 
 * Pour un client particulier, la réduction sera égale à : 1.0 – 0.005 x nbLocations, et pour un 
 * client professionnel, la réduction sera égale au taux. 
 * Pour la réalisation de ce calcul du prix de la location, faites en sorte de ne pas avoir à tester le type de l’instance du client. 
 * De plus, la méthode prixLocation ne prend pas en paramètre de client.
 */
public class RentingManagement extends Management {
    
    /**
     * Method to request a rental. No verification on the mileage.
     * @param vehicle The vehicle to rent.
     * @param customer The customer renting the vehicle.
     * @return true if the rental request is successful, false otherwise.
     */
    public boolean rentalRequest(SpecificVehicle vehicle, SpecificCustomer customer) {
        if (removeFromRentAvailableVehicles(vehicle)) {
            addToCurrentlyRentedVehicles(customer, vehicle);
            if (customer instanceof PrivateCustomer) {
                ((PrivateCustomer) customer).incrementNbRentals();
            }
            return true;
        }
        return false;

    }

    public void getPrice(SpecificVehicle vehicle, SpecificCustomer customer) {

    }

    // need to add the endRentalDate and endRentalMileage
    public void endRental(
                        SpecificVehicle vehicle, 
                        SpecificCustomer customer, 
                        String endRentalDate, 
                        double endRentalMileage)
                        throws AutomobileManagementVehiculesRentException {

        if (super.getCurrentlyRentedVehicles().containsKey(customer)) {
            super.removeFromCurrentlyRentedVehicles(customer);
            super.addToRentAvailableVehicles(vehicle);
        }
        else {
            throw new AutomobileManagementVehiculesRentException("The customer is not renting any vehicle.");
        }
        // the endRentalDate is updated in the customer object
        try {
            customer.setRentalDate(new DateManagement(endRentalDate));
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementVehiculesRentException(e.getMessage());
        }
    }
}
