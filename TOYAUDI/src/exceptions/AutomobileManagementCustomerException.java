package exceptions;

import customer.Customers;

/**
 * Exception that will be thrown if an attempt is made to add a client with incorrect attribute.
 */
public class AutomobileManagementCustomerException extends AutomobileManagementException {
    public AutomobileManagementCustomerException(String s) {
        super(s);
    }
    public AutomobileManagementCustomerException(String message, Customers customer) {
        super(message + " Customer : " + customer.toString());
    }
}

