package exceptions;

/*
 * Exception that will be thrown if an attempt is made to add the same client twice in the Customers class (same name, etc.).
 * Add a constructor with a string parameter to this class. Rewrite the method for adding a customer (individual or professional)
 * so that it throws AutomobileManagementCustomerException: the exception is constructed by passing a string indicating the identity
 * of the private or professional customer and a message highlighting that this customer already exists in the Customers class.
 */

import customer.Customers;

public class AutomobileManagementCustomerException extends AutomobileManagementException {
    public AutomobileManagementCustomerException(String s) {
        super(s);
    }
    public AutomobileManagementCustomerException(String message, Customers customer) {
        super(message + " Customer : " + customer.toString());
    }
}

