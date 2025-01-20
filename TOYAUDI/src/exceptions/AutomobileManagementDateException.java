package exceptions;

/**
 * Will be thrown if the date is not in the correct format, or if the date is before the creation date, or if the date is null.
 */
public class AutomobileManagementDateException extends AutomobileManagementException {
    public AutomobileManagementDateException(String s) {
        super(s);
    }
    
}
