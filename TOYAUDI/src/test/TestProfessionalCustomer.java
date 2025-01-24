package test;

import customer.Customers;

/**
 * Class to test the ProfessionalCustomer class.
 * It tests different cases of valid and invalid creation of professional customers.
 */
public class TestProfessionalCustomer {
    public static void main(String[] args) {
        Customers customers = Customers.getInstance();

        /* Valid customers */
        customers.addProfessionalCustomer("M&M's", 0.023);
        customers.addProfessionalCustomer("Elysee", 0.01);

        // Limit rates
        customers.addProfessionalCustomer("Big du BigDeal", 1.0);
        customers.addProfessionalCustomer("Jones and Jack", 0);

        /* Invalid customers */
        // Customer already exists
        customers.addProfessionalCustomer("M&M's", 0.75);
        
        /* Invalid name */
        // Name is null
        customers.addProfessionalCustomer(null, 1.0);
        // Name too short
        customers.addProfessionalCustomer("", 0.1);
        // Name too long
        customers.addProfessionalCustomer("NameNameNameNameNameNameNameNameName", 0);
        
        /* Invalid rate */
        // Rate is out of range
        customers.addProfessionalCustomer("Metrot", 28);
        // Rate is negative
        customers.addProfessionalCustomer("StarBuick", -0.023);

        customers.displayCustomers();
    }
}
