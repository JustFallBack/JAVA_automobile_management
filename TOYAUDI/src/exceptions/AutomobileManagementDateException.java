package exceptions;

/**
 * Will be thrown if the date is not in the correct format.
 */
public class AutomobileManagementDateException extends AutomobileManagementException {
    public AutomobileManagementDateException(String s) {
        super(s);
    }
    
}
