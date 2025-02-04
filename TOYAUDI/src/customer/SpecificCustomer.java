package customer;

import exceptions.AutomobileManagementCustomerException;
import management.DateManagement;

/**
 * Abstract class that represents a specific customer.
 * @extends Customers
 */
public abstract class SpecificCustomer extends Customers {
    /**
     * The name of the customer (private or professional).
     * Must be between 2 and 20 characters long.
     */
    private String name;
    /**
     * The date the customer rented a vehicle.
     * When created, a customer has not rented a vehicle yet, so the constructor doesn't take a rental date as a parameter.
     */
    private DateManagement rentalDate;

    /**
     * The constructor of the class SpecificCustomer.
     * @param name The name of the customer (private or professional).
     * @throws AutomobileManagementCustomerException
     */
    public SpecificCustomer(String name) throws AutomobileManagementCustomerException {
        try {
            if (name == null) {
                throw new AutomobileManagementCustomerException("Name can not be null.");
            }
            if (name.length() < 2 || name.length() > 20) {
                throw new AutomobileManagementCustomerException("The client name must be between 2 and 20 characters long : " + name);
            }
        } catch (AutomobileManagementCustomerException e) {
            throw e;
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public String getRentalDate() {
        try {
            return this.rentalDate.getDate();
        } catch (NullPointerException e) {
            return "No rental date.";
        }
    }
    public void setRentalDate(DateManagement rentalDate) {
        this.rentalDate = rentalDate;
    }

    public abstract CustomerType getType();
    public abstract String toStringShort();
}
