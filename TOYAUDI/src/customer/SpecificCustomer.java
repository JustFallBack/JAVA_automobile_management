package customer;

import exceptions.AutomobileManagementCustomerException;

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

    public abstract CustomerType getType();
}
