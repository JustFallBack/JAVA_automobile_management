package exceptions;

/*
 * Will be thrown if an attempt is made to sell a vehicle with mileage exceeding the maximum value defined
 * in the Gestion class. This class will have a parameterless constructor, but will initialize the message of
 * its base class to "This vehicle is no longer available for sale". Finally, add the derived class
 * AutomobileManagementVehiculesRentException, which will be thrown in the rentalRequest method of
 * RentalManagement if an attempt is made to rent a vehicle that is not in the list of vehicles available for rent.
 */
public class AutomobileManagementVehicleSaleException extends AutomobileManagementVehicleException {
    public AutomobileManagementVehicleSaleException() {
        super("This vehicle is no longer available for sale.");
    }
}
