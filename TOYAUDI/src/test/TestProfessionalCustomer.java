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
        customers.addCustomer("M&M's", 0.023);
        customers.addCustomer("Elysee", 0.01);

        // Limit rates
        customers.addCustomer("Big du BigDeal", 1.0);
        customers.addCustomer("Jones and Jack", 0);

        /* Invalid customers */
        // Customer already exists
        customers.addCustomer("M&M's", 0.75);
        
        /* Invalid name */
        // Name is null
        customers.addCustomer(null, 1.0);
        // Name too short
        customers.addCustomer("", 0.1);
        // Name too long
        customers.addCustomer("NameNameNameNameNameNameNameNameName", 0);
        
        /* Invalid rate */
        // Rate is out of range
        customers.addCustomer("Metrot", 28);
        // Rate is negative
        customers.addCustomer("StarBuick", -0.023);

        customers.displayCustomers();
    }
}
