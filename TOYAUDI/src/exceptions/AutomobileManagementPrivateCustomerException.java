package exceptions;

/*
 * Will be thrown in the case where the user tries to create a customer with a negative age.
 */
public class AutomobileManagementPrivateCustomerException extends AutomobileManagementCustomerException {
    public AutomobileManagementPrivateCustomerException(String s) {
        super(s);
    }
}
