package management;

import java.math.BigDecimal;
import java.math.RoundingMode;

import customer.PrivateCustomer;
import customer.SpecificCustomer;
import vehicle.SpecificVehicle;
import exceptions.AutomobileManagementDateException;
import exceptions.AutomobileManagementVehiculesRentException;

/**
 * Manages the rental of vehicles.
 * @extends Management
 */
public class RentingManagement extends Management {
    private static RentingManagement instance;

    public static RentingManagement getInstance() {
        if (instance == null) {
            instance = new RentingManagement();
        }
        return instance;
    }

    public RentingManagement() {
        super();
    }

    /**
     * Method to request a rental. No verification on the mileage.
     * If the vehicle is available for rent, it is removed from the list of available vehicles for rent and for sale (done in Management class).
     * The rental date is updated for the customer.
     * @param vehicle The vehicle to rent.
     * @param customer The customer renting the vehicle.
     * @return true if the rental request is successful, false otherwise.
     */
    public boolean rentalRequest(
                                SpecificVehicle vehicle, 
                                SpecificCustomer customer, 
                                String rentalDate) 
                                throws AutomobileManagementVehiculesRentException {

        try {
            if (super.getRentAvailableVehicles().contains(vehicle)) {
                DateManagement newRentalDate = new DateManagement(rentalDate); // check the validity of the date
                addToCurrentlyRentedVehicles(customer, vehicle);
                customer.setRentalDate(newRentalDate); 
                if (customer instanceof PrivateCustomer) {
                    ((PrivateCustomer) customer).incrementNbRentals();
                }
                System.out.println("---------- Rental confirmed ----------\n" + vehicle.toStringShort() + "\n" + customer.toStringShort());
                return true;
            }
            return false;
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementVehiculesRentException(e.getMessage());
        }
    }

    /**
     * Method to end a rental. The vehicle is added to the list of available vehicles for rent and for sale, if allowed.
     * The end rental date and the end rental mileage are updated on the vehicle.
     * @param customer The customer ending the rental.
     * @param vehicle The vehicle rented by the customer.
     * @param endRentalDate The date the rental ends. 
     * @param endRentalMileage The mileage of the vehicle when the rental ends.
     * @return True if the rental ends successfully, exception raised otherwise.
     * @throws AutomobileManagementVehiculesRentException
     */
    public boolean endRental(
                        SpecificCustomer customer, 
                        SpecificVehicle vehicle, 
                        String endRentalDate, 
                        double endRentalMileage)
                        throws AutomobileManagementVehiculesRentException {

        // Check if the customer is renting a vehicle.
        if (!(super.getCurrentlyRentedVehicles().containsKey(customer))) {
            throw new AutomobileManagementVehiculesRentException("The customer is not renting any vehicle : \n" + customer.toString());
        }
        
        // Check if the vehicle passed as an argument and the vehicle rented by the customer are the same.
        if (super.getCurrentlyRentedVehicles().get(customer) != vehicle) {
            throw new AutomobileManagementVehiculesRentException("The customer is not renting this vehicle : \n" + customer.toString() + "\n" + vehicle.toString());
        }

        // Remove the vehicle from the list of vehicles currently rented and add it to the list of vehicles available for rent and for sale.
        super.removeFromCurrentlyRentedVehicles(customer);
        super.addToRentAvailableVehicles(vehicle);
        super.addToSaleAvailableVehicles(vehicle);

        // Update the end rental date and the end rental mileage on the vehicule.
        try {
            DateManagement dateManagement = new DateManagement(endRentalDate); // check the validity of the date
            if (dateManagement.isBefore(endRentalDate, customer.getRentalDate(), false)) { // doesn't affect dateManagement instance
                throw new AutomobileManagementVehiculesRentException("The end rental date (" + endRentalDate + ") must be after the rental date (" + customer.getRentalDate() + ").");
            }
            vehicle.setEndRentalDate(dateManagement);
            endRentalMileage = checkMileage(endRentalMileage);
            if (vehicle.getMileage() > endRentalMileage) {
                throw new AutomobileManagementVehiculesRentException("The end rental mileage (" + endRentalMileage +") must be greater than the current mileage (" + vehicle.getMileage() + ")of the vehicle.");
            }
            vehicle.setEndRentalMileage(endRentalMileage);
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementVehiculesRentException(e.getMessage());
        }
        // Get the bill and set the mileage to the end rental mileage.
        getReceipt(customer, vehicle);
        return true;
    }

    /**
     * Print the receipt for the rental.
     * The mileage of the car is updated.
     * @param customer The customer who rented the vehicle.
     * @param vehicle The vehicle rented by the customer.
     * @throws AutomobileManagementVehiculesRentException
     */
    public void getReceipt(SpecificCustomer customer, SpecificVehicle vehicle) throws AutomobileManagementVehiculesRentException {
        System.out.println("\n---------- Receipt for the rental -----\n");
        System.out.println(customer.toStringShort() + "\n" + vehicle.toStringShort() + "\n");
        System.out.println("Rental period : from " + customer.getRentalDate() + " to " + vehicle.getEndRentalDate());
        System.out.println("Distance traveled : " + checkMileage((vehicle.getEndRentalMileage() - vehicle.getMileage())) + " km");
        System.out.println("Total price of the rental : $" + super.getRentalPrice(customer, vehicle));
        vehicle.setNewMileage(vehicle.getEndRentalMileage());
    }

    /**
     * Method to check the mileage of a vehicle.
     * @param mileage The mileage to check.
     * @return The mileage rounded to 2 decimal places.
     * @throws AutomobileManagementVehiculesRentException
     */
    private double checkMileage(double mileage) throws AutomobileManagementVehiculesRentException {
        if (mileage <= 0 || mileage > 1000000) {
            throw new AutomobileManagementVehiculesRentException("Mileage must be positive and under 1,000,000 km : " + mileage);
        }
        return new BigDecimal(mileage).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
