package exceptions;

/**
 * Will be thrown in the case where the user tries to create a private customer with incorrect information (e.g. negative age).
 */
public class AutomobileManagementPrivateCustomerException extends AutomobileManagementCustomerException {
    public AutomobileManagementPrivateCustomerException(String s) {
        super(s);
    }
}
