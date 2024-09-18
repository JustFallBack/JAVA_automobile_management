package test;

import customer.Customers;

public class TestProfessionalCustomer {
    public static void main(String[] args) {
        Customers customers = Customers.getInstance();

        /* Valid customers */
        customers.addProfessionalCustomer("M&M's","05/04/2013",0.023);
        customers.addProfessionalCustomer("Elysee", "01/01/2001", 0.01);
        customers.addProfessionalCustomer("Big du BigDeal", "04/01/2000", 0.8);

        /* Invalid customers */
        // Name too short
        customers.addProfessionalCustomer("","05/04/2013",0.1);
        // Customer already exists
        customers.addProfessionalCustomer("M&M's","05/04/2013",0.023);
        // Rate is out of range
        customers.addProfessionalCustomer("M&M's","05/04/2013",28);
        // Rate is negative
        customers.addProfessionalCustomer("M&M's","05/04/2013",-0.023);
        // Date is not in the correct format
        customers.addProfessionalCustomer("M&M's","05/04/",0.023);
        // Date is before the creation date of TOYAUDI.
        customers.addProfessionalCustomer("Mmmmmmm", "05/04/1999", 0.8);
        // Customer name is too long
        customers.addProfessionalCustomer("UnNomTrèsLongQuiNeVaPasEtreAccepté:p", "05/05/2005", 0.002);

        customers.displayCustomers();
    }
}
