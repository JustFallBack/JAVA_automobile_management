package exceptions;

/**
 * Exception that will be thrown if an attempt is made to add the same vehicle twice, or if the vehicle has incorrect information.
 */
public class AutomobileManagementVehicleException extends AutomobileManagementException {
    public AutomobileManagementVehicleException(String s) {
        super(s);
    }
}
