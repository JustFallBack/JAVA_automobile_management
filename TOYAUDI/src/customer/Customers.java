package customer;

import exceptions.AutomobileManagementProfessionalCustomerException;
import exceptions.AutomobileManagementCustomerException;
import exceptions.AutomobileManagementPrivateCustomerException;

import java.util.ArrayList;

/**
 * Class of type ArrayList to store individual or professional customers.
 * Only one instance of Customers can be created.
 * @extends ArrayList<Customers>
 */
public class Customers extends ArrayList<Customers> {
    private static Customers instance;

    public static Customers getInstance() {
        if(instance == null){
            instance = new Customers();
        }
        return instance;
    }

    public void displayCustomers() {
        for (Customers customer : this) {
            System.out.println(customer);
        }
    }

    /**
     * Check if a customer already exists in the collection.
     * @param customerObject The customer to compare.
     * @return True if the customer already exists in the collection, false otherwise.
     */
    public boolean existsCustomer(Customers customerObject) {
        for (Customers customer : this) {
            if (customer.equals(customerObject)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a PrivateCustomer from the collection.
     * @param name The name of the customer.
     * @param firstName The first name of the customer.
     * @return The PrivateCustomer instance if it exists in the collection, null otherwise.
     */
    public PrivateCustomer getCustomer(String name, String firstName) {
        for (Customers customer : this) {
            if (((PrivateCustomer) customer).getName().equals(name) && ((PrivateCustomer) customer).getFirstName().equals(firstName)) {
                return (PrivateCustomer) customer;
            }
        }
        return null;
    }

    /**
     * Get a ProfessionalCustomer from the collection.
     * @param name The name of the customer.
     * @return The ProfessionalCustomer instance if it exists in the collection, null otherwise.
     */
    public ProfessionalCustomer getCustomer(String name) {
        for (Customers customer : this) {
            if (((ProfessionalCustomer) customer).getName().equals(name)) {
                return (ProfessionalCustomer) customer;
            }
        }
        return null;
    }

    /**
     * Add a private customer to the collection.
     * @param name The name of the customer.
     * @param firstName The first name of the customer.
     * @param address The address of the customer.
     * @param age The age of the customer.
     * @param nbRentals The number of times the customer has rented a vehicle.
     */
    public void addCustomer(String name, String firstName, String address, int age, int nbRentals) {
        try {
            PrivateCustomer customer = new PrivateCustomer(name, firstName, address, age, nbRentals);
            if(!existsCustomer(customer)) {
                this.add(customer);
            }
            else {
                throw new AutomobileManagementPrivateCustomerException("A customer with the same name and first name already exists : " + customer.getName() + " " + customer.getFirstName());
            }
        } catch(AutomobileManagementCustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Add a professional customer to the collection.
     * @param name The name of the customer.
     * @param discountRate The discount rate of the customer.
     */
    public void addCustomer(String name, double discountRate) {
        try {
            ProfessionalCustomer customer = new ProfessionalCustomer(name, discountRate);
            if (!existsCustomer(customer)) {
                this.add(customer);
            }
            else {
                throw new AutomobileManagementProfessionalCustomerException("A customer with the same name already exists : " + customer.getName());
            }
        } catch(AutomobileManagementCustomerException e) {
            System.out.println(e.getMessage());
        }
    }
}
