package management;

import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

import vehicle.SpecificVehicle;
import customer.SpecificCustomer;

/**
 * Avant de procéder à l’implémentation des classes de gestion de la location/vente des véhicules, 
 * vous allez ajouter une classe de structuration des informations Gestion qu’il n’est pas possible 
 * d’instancier, ayant pour rôle de sauvegarder toutes les données permettant de gérer les 
 * locations/ventes : les véhicules disponibles à la location (HashSet) et disponibles à la vente (LinkedList) 
 * ainsi que les véhicules en cours de location (HashMap) sous forme d’un tableau associant un client à une automobile. 
 * La classe Gestion disposera également des attributs indiquant le kilométrage à partir duquel un véhicule est disposé à 
 * la vente (double) ainsi que le kilométrage maximum à pattir duquel un véhicule ne peut plus être proposé à la vente (double).
 * 
 * 
 */
public abstract class Management {
    /**
     * Set of every available vehicles to rent.
     */
    private HashSet<SpecificVehicle> rentAvailableVehicles;
    /**
     * List of every available vehicles to sell.
     */
    private LinkedList<SpecificVehicle> saleAvailableVehicles;
    /**
     * Hash map where a customer is associated to a car. The customer is renting the car.
     */
    private HashMap<SpecificCustomer, SpecificVehicle> currentlyRentedVehicles;
    /**
     * Kilometer threshold from which a vehicle is available for sale.
     */
    private double saleThreshold;
    /**
     * Kilometer limit from which a vehicle is not available for sale.
     */
    private double maxSaleThreshold;



    /**
     * Remove a vehicle from the list of vehicles available for rent.
     * @param vehicle The vehicle being removed from the list of vehicles available for rent.
     * @return true if the vehicle is successfully removed from the list of vehicles available for rent, false otherwise.
     */
    public boolean removeFromRentAvailableVehicles(SpecificVehicle vehicle) {
        return this.rentAvailableVehicles.remove(vehicle);
    }

    /**
     * Remove a vehicle from the list of vehicles currently rented.
     * @param customer The customer renting the vehicle.
     * @return true if the vehicle is successfully removed from the list of vehicles currently rented, false otherwise.
     */
    public boolean removeFromCurrentlyRentedVehicles(SpecificCustomer customer) {
         return (this.currentlyRentedVehicles.remove(customer) != null);
    }

    /**
     * Remove a vehicle from the list of vehicles available for sale.
     * @param vehicle
     * @return true if the vehicle is successfully removed from the list of vehicles available for sale, false otherwise.
     */
    public boolean removeFromSaleAvailableVehicles(SpecificVehicle vehicle) {
        return this.saleAvailableVehicles.remove(vehicle);
    }

    /**
     * Add a vehicle to the list of vehicles available for rent.
     * @param vehicle The vehicle to add.
     * @return true if the vehicle is successfully added to the list of vehicles available for rent, false otherwise.
     */
    public boolean addToRentAvailableVehicles(SpecificVehicle vehicle) {
        return this.rentAvailableVehicles.add(vehicle);
    }

    /**
     * Add the vehicle and the customer to the HashMap of vehicles/customers currently rented.
     * Same client cannot rent two vehicles at the same time.
     * The vehicle must be in the list of vehicles available for rent.
     * When rented, a vehicle is removed from the list of vehicles available for rent and for sale.
     * @param customer The customer renting the vehicle.
     * @param vehicle The vehicle to rent.
     * @return true if the vehicle and the customer are successfully added to the HashMap of vehicles/customers currently rented, false otherwise.
     */
    public boolean addToCurrentlyRentedVehicles(SpecificCustomer customer, SpecificVehicle vehicle) {
        if (!currentlyRentedVehicles.containsKey(customer) && rentAvailableVehicles.contains(vehicle)) {
            currentlyRentedVehicles.put(customer, vehicle);
            removeFromRentAvailableVehicles(vehicle);
            removeFromSaleAvailableVehicles(vehicle);
            return true;
        }
        return false;
    }

    /**
     * Add a vehicle to the list of vehicles available for sale, if the mileage is between the sale thresholds.
     * @return
     */
    public boolean addToSaleAvailableVehicles(SpecificVehicle vehicle) {
        if (vehicle.getMileage() >= this.saleThreshold && vehicle.getMileage() < this.maxSaleThreshold) {
            return this.saleAvailableVehicles.add(vehicle);
        }
        return false;
    }


    public HashSet<SpecificVehicle> getRentAvailableVehicles() {
        return this.rentAvailableVehicles;
    }
    public LinkedList<SpecificVehicle> getSaleAvailableVehicles() {
        return this.saleAvailableVehicles;
    }
    public HashMap<SpecificCustomer, SpecificVehicle> getCurrentlyRentedVehicles() {
        return this.currentlyRentedVehicles;
    }
    public double getSaleThreshold() {
        return this.saleThreshold;
    }
    public double getMaxSaleThreshold() {
        return this.maxSaleThreshold;
    }
}
