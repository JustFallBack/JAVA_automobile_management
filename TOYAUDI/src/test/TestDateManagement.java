package test;

import exceptions.AutomobileManagementDateException;
import management.DateManagement;

/**
 * Class to test the DateManagement class.
 * It tests the creation of a DateManagement object with valid dates, invalid dates and dates before the creation of TOYAUDI.
 */
abstract public class TestDateManagement {


    public static void main(String[] args) {
        /* Valid dates */

        try {
            DateManagement date1 = new DateManagement("11/04/2004");
            System.out.println(date1);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // Date is the creation date of TOYAUDI
        try {
            DateManagement date2 = new DateManagement("01/01/2000");
            System.out.println(date2);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // Last valid date
        try {
            DateManagement date3 = new DateManagement("31/12/2099");
            System.out.println(date3);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // With the way the DateManagement class is implemented, this date is considered valid
        try {
            DateManagement date4 = new DateManagement("01/35/2001");
            System.out.println(date4);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }

        /* Invalid dates */
        // Date is null
        try {
            DateManagement date5 = new DateManagement(null);
            System.out.println(date5);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // Format is not correct
        try {
            DateManagement date2 = new DateManagement("112004");
            System.out.println(date2);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // Date is before the creation date of TOYAUDI
        try {
            DateManagement date3 = new DateManagement("01/01/1999");
            System.out.println(date3);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
        // Date is after 2100
        try {
            DateManagement date4 = new DateManagement("01/01/2100");
            System.out.println(date4);
        } catch (AutomobileManagementDateException e) {
            System.out.println(e.getMessage());
        }
    }
}
