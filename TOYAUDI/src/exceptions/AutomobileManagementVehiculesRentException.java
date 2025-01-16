package exceptions;
/**
 * Will be thrown in the rentalRequest method of RentalManagement if an attempt
 *  is made to rent a vehicle that is not in the list of vehicles available for rent.
 */ 
public class AutomobileManagementVehiculesRentException extends AutomobileManagementVehicleException {
    public AutomobileManagementVehiculesRentException(String s) {
        super(s);
    }
}