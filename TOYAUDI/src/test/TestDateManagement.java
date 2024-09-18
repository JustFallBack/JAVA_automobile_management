package test;

import exceptions.AutomobileManagementDateException;
import management.DateManagement;

/**
 * Class to test the DateManagement class.
 */
abstract public class TestDateManagement {


    public static void main(String[] args) {
        try {
            // Valid date
            DateManagement date1 = new DateManagement("11/04/2004");
            System.out.println(date1);

            // Invalid date
            // Format is not correct
            DateManagement date2 = new DateManagement("112004");
            System.out.println(date2);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        try {
            // Date is before the creation date of TOYAUDI
            DateManagement date3 = new DateManagement("01/01/1999");
            System.out.println(date3);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        try {
            // With the way the DateManagement class is implemented, this date is considered valid
            DateManagement date4 = new DateManagement("01/35/2001");
            System.out.println(date4);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
    }
}
