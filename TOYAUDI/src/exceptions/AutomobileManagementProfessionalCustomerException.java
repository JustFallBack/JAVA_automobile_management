package exceptions;

/**
 * Will be thrown in the case where the user tries to create a professional customer with incorrect information (e.g. invalid name).
 */
public class AutomobileManagementProfessionalCustomerException extends AutomobileManagementCustomerException {
    public AutomobileManagementProfessionalCustomerException(String s) {
        super(s);
    }
}
