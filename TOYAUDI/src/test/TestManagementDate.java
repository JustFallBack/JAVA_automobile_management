package test;

import exceptions.AutomobileManagementCustomerException;
import management.DateManagement;

abstract public class TestManagementDate {


   public static void main(String[] args) {
       try {
           DateManagement date1 = new DateManagement("11/04/2004");
           System.out.println(date1);
           DateManagement date2 = new DateManagement("112004");
           System.out.println(date2);
       } catch (AutomobileManagementCustomerException e) {
           System.out.println(e.getMessage());
       }
       try {
           DateManagement date3 = new DateManagement("01/01/1999");
           System.out.println(date3);
       } catch (AutomobileManagementCustomerException e) {
           System.out.println(e.getMessage());
       }
    }
}
