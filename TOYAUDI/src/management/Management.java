package management;

import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Avant de procéder à l’implémentation des classes de gestion de la location/vente des véhicules, 
 * vous allez ajouter une classe de structuration des informations Gestion qu’il n’est pas possible 
 * d’instancier, ayant pour rôle de sauvegarder toutes les données permettant de gérer les 
 * locations/ventes : les véhicules disponibles à la location (HashSet) et disponibles à la vente (LinkedList) 
 * ainsi que les véhicules en cours de location (HashMap) sous forme d’un tableau associant un client à une automobile. 
 * La classe Gestion disposera également des attributs indiquant le kilométrage à partir duquel un véhicule est disposé à 
 * la vente (double) ainsi que le kilométrage maximum à pattir duquel un véhicule ne peut plus être proposé à la vente (double).
 */
public abstract class Management {
    /**
     * Set of every available vehicles to rent.
     */
    private HashSet rentAvailableVehicles;
    /**
     * List of every available vehicles to sell.
     */
    private LinkedList saleAvailableVehicles;
    /**
     * Hash map where a customer is associated to a car. The customer is renting the car.
     */
    private HashMap currentlyRentedVehicles;
}
