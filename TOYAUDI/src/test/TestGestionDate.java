package test;

import exceptions.GestionAutomobileClientsException;
import gestion.GestionDate;

abstract public class TestGestionDate {


   public static void main(String[] args) {
       try {
           GestionDate date1 = new GestionDate("11/04/2004");
           System.out.println(date1);
           GestionDate date2 = new GestionDate("112004");
           System.out.println(date2);
       } catch (GestionAutomobileClientsException e) {
           System.out.println(e.getMessage());
       }
       try {
           GestionDate date3 = new GestionDate("01/01/1999");
           System.out.println(date3);
       } catch (GestionAutomobileClientsException e) {
           System.out.println(e.getMessage());
       }
    }
}
