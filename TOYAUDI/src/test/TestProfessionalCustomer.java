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
        customers.addProfessionalCustomer("M&M's","05/04/2013",0.023);
        customers.addProfessionalCustomer("Elysee", "01/01/2001", 0.01);

        // Limit rates
        customers.addProfessionalCustomer("Big du BigDeal", "04/01/2000", 1.0);
        customers.addProfessionalCustomer("Jones and Jack", "12/12/2012", 0);

        // Limit dates
        customers.addProfessionalCustomer("LimitDateLower", "01/01/2000", 0);
        customers.addProfessionalCustomer("LimitDateUpper", "31/12/2099", 0.5);

        /* Invalid customers */
        // Customer already exists
        customers.addProfessionalCustomer("M&M's","28/01/2012",0.75);
        
        /* Invalid name */
        // Name is null
        customers.addProfessionalCustomer(null, "05/09/2029", 1.0);
        // Name too short
        customers.addProfessionalCustomer("","05/04/2013",0.1);
        // Name too long
        customers.addProfessionalCustomer("NameNameNameNameNameNameNameNameName", "01/01/2001", 0);
        
        /* Invalid rate */
        // Rate is out of range
        customers.addProfessionalCustomer("Metrot","05/04/2013",28);
        // Rate is negative
        customers.addProfessionalCustomer("StarBuick","05/04/2013",-0.023);

        /* Invalid date */
        // Date is null
        customers.addProfessionalCustomer("NoDate",null,0.023);
        // Date is not in the correct format
        customers.addProfessionalCustomer("TooBadToStay","05/04/",0.023);
        // Date is before the creation date of TOYAUDI.
        customers.addProfessionalCustomer("Mmmmmmm", "31/12/1999", 0.8);

        customers.displayCustomers();
    }
}
