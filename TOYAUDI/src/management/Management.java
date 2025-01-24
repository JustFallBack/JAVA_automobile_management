package management;

import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

import vehicle.SpecificVehicle;
import customer.SpecificCustomer;
import exceptions.AutomobileManagementDateException;
import exceptions.AutomobileManagementException;
import exceptions.AutomobileManagementVehiculesRentException;
import customer.PrivateCustomer;
import customer.ProfessionalCustomer;

 /**
  * Class that structures the information for the management of the rental/sale of vehicles.
  * Contains all the methods to manage the rental/sale of vehicles (remove and add to the different lists, get the price of the rental/sale).
  * Contains the vehicles available for rent (HashSet), for sale (LinkedList) and the vehicles currently rented (HashMap).
  * Contains the kilometer threshold from which a vehicle is available for sale and the kilometer limit from which a vehicle is not available for sale anymore.
  * Also contains the minimum price for a vehicle for sale.
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
    private final double SALE_THRESHOLD = 75000.00;
    /**
     * Kilometer limit from which a vehicle is not available for sale anymore.
     */
    private final double MAX_SALE_THRESHOLD = 250000.00;
    /**
     * The minimum price for a vehicle for sale (when the mileage equals the MAX_SALE_THRESHOLD).
     */
    private final double MIN_SALE_PRICE = 5000.00;

    /**
     * Constructor of the class Management.
     * Needed to initialize the lists of vehicles available for rent, for sale and the vehicles currently rented.
     */
    public Management() {
        this.rentAvailableVehicles = new HashSet<SpecificVehicle>();
        this.saleAvailableVehicles = new LinkedList<SpecificVehicle>();
        this.currentlyRentedVehicles = new HashMap<SpecificCustomer, SpecificVehicle>();
    }

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
     * @param vehicle The vehicle being removed from the list of vehicles available for sale.
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
     * @param vehicle The vehicle to add.
     * @return true if the vehicle is successfully added to the list of vehicles available for sale, false otherwise.
     */
    public boolean addToSaleAvailableVehicles(SpecificVehicle vehicle) {
        if (vehicle.getMileage() >= this.SALE_THRESHOLD && vehicle.getMileage() < this.MAX_SALE_THRESHOLD) {
            return this.saleAvailableVehicles.add(vehicle);
        }
        return false;
    }

    /**
     * Get the price of the rental.
     * The formula to calculate the discountRate for a private customer is : 1.0 - 0.005 * nbRentals. Above 100 rentals, the discountRate is 0.5.
     * The formula to calculate the rental price is : discountRate * ( pricePerKilometerForThisTypeOfVehicle * distanceTraveled + pricePerDayForThisTypeOfVehicle * nbRentalDays * (1 + numberOfDoors/10) ).
     * @param customer The customer who rented the vehicle.
     * @param vehicle The vehicle rented by the customer.
     * @return The price of the rental.
     * @throws AutomobileManagementException
     */
    public double getRentalPrice(SpecificCustomer customer, SpecificVehicle vehicle) throws AutomobileManagementVehiculesRentException {
        double discountRate;
        if (customer instanceof PrivateCustomer) {
            if (((PrivateCustomer) customer).getNbRentals() > 100) {
                discountRate = 0.5;
            }
            else {
                discountRate = 1.0 - 0.005 * ((PrivateCustomer) customer).getNbRentals();
            }
        }
        else {
            discountRate = ((ProfessionalCustomer) customer).getDiscountRate();
        }
        
        DateManagement dateManagementBlank = new DateManagement(); // blank DateManagement instance to use non-static method
        double distanceTraveled = vehicle.getEndRentalMileage() - vehicle.getMileage();
        try {
            int nbRentalDays = dateManagementBlank.differenceInDays(customer.getRentalDate(), vehicle.getEndRentalDate());
            return ( discountRate ) * ( (vehicle.getType()).getPricePerKilometer() * distanceTraveled + (vehicle.getType()).getDailyRentPrice() * nbRentalDays * (1 + vehicle.getNumberOfDoors() / 10) );
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementVehiculesRentException(e.getMessage());
        }
    }

    /**
     * Get the price of the sale.
     * The formula to calculate the sale price is : purchasingPrice * (1 - (mileage / MAX_SALE_THRESHOLD)) + MIN_SALE_PRICE * (mileage / MAX_SALE_THRESHOLD).
     * With this formula, the price of the vehicle decreases linearly from the purchasing price to the MIN_SALE_PRICE when the mileage reaches the MAX_SALE_THRESHOLD.
     * @param vehicle The vehicle to sell.
     * @return The price of the sale.
     */
    public double getSalePrice(SpecificVehicle vehicle) {
        return vehicle.getPurchasingPrice() * (1 - (vehicle.getMileage() / this.MAX_SALE_THRESHOLD)) + this.getMinSalePrice() * (vehicle.getMileage() / this.MAX_SALE_THRESHOLD);
    }

    /**
     * Print the vehicles currently rented.
     */
    public void printRentedVehicule() {
        System.out.println("---------- All current rentals ----------\n");
        for (SpecificCustomer customer : this.currentlyRentedVehicles.keySet()) {
            System.out.println("---- Customer renting the vehicule ----" + customer.toString());
            System.out.println("---- Vehicle being rented ----" + this.currentlyRentedVehicles.get(customer).toString());
        }
    }

    /**
     * Print the vehicles available for rent.
     */
    public void printRentAvailableVehicles() {
        System.out.println("---------- All vehicles available for rent ----------\n");
        for (SpecificVehicle vehicle : this.rentAvailableVehicles) {
            System.out.println(vehicle.toString());
        }
    }

    /**
     * print the vehicles available for sale.
     */
    public void printSaleAvailableVehicles() {
        System.out.println("---------- All vehicles available for sale ----------\n");
        for (SpecificVehicle vehicle : this.saleAvailableVehicles) {
            System.out.println(vehicle.toString());
        }
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
        return this.SALE_THRESHOLD;
    }
    public double getMaxSaleThreshold() {
        return this.MAX_SALE_THRESHOLD;
    }
    public double getMinSalePrice() {
        return this.MIN_SALE_PRICE;
    }
}
