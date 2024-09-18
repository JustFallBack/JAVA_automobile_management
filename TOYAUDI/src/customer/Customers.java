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
     * Add a private customer to the collection.
     * @param name The name of the customer.
     * @param firstName The first name of the customer.
     * @param address The address of the customer.
     * @param age The age of the customer.
     * @param date The date of birth of the customer.
     * @param nbRentals The number of times the customer has rented a vehicle.
     */
    public void addPrivateCustomer(String name, String firstName, String address, int age, String date, int nbRentals) {
        try {
            PrivateCustomer customer = new PrivateCustomer(name, firstName, address, age, date, nbRentals);
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
     * @param date The date when the customer became a professional customer.
     * @param discountRate The discount rate of the customer.
     */
    public void addProfessionalCustomer(String name, String date, double discountRate) {
        try {
            ProfessionalCustomer customer = new ProfessionalCustomer(name, date, discountRate);
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
