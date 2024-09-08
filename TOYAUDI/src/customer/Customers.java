package customer;

/*
 * Add a Customers class of type ArrayList (not a class containing an ArrayList...) to store individual or professional customers with a method to display the customers.
 * Only one instance of Customers can be created.
 * Modify the constructor(s) to add a new instance of individual or professional customers to the list of customers in Customers.
 */
import exceptions.AutomobileManagementProfessionalCustomerException;
import exceptions.AutomobileManagementPrivateCustomerException;

import java.util.ArrayList;

public class Customers extends ArrayList<Customers> {
    private static Customers instance;

    public static Customers getInstance() {
        if(instance == null){
            instance = new Customers();
        }
        return instance;
    }

    public void displayCustomers() {
        for (Customers customers : this) {
            System.out.println(customers);
        }
    }

    // Search in the ArrayList of customers if the customerObject passed as an argument exists.
    public boolean existsCustomers(Customers customersObject) {
        for (Customers customers : this) {
            if (customers.equals(customersObject)) {
                return true;
            }
        }
        return false;
    }

    public void addPrivateCustomer(String name, String firstName, String address, int age, String date, int nbRentals) {
        try {
            PrivateCustomer customer = new PrivateCustomer(name, firstName, address, age, date, nbRentals);
            if(!existsCustomers(customer)) {
                this.add(customer);
            }
            else {
                throw new AutomobileManagementPrivateCustomerException("This customer already exists :\n" + customer);
            }
        } catch(AutomobileManagementPrivateCustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addProfessionalCustomer(String name, String date, double discountRate) {
        try {
            ProfessionalCustomer customer = new ProfessionalCustomer(name, date, discountRate);
            if (!existsCustomers(customer)) {
                this.add(customer);
            }
            else {
                throw new AutomobileManagementProfessionalCustomerException("This customer already exists :\n" + customer);
            }
        } catch(AutomobileManagementProfessionalCustomerException e) {
            System.out.println(e.getMessage());
        }
    }
}
