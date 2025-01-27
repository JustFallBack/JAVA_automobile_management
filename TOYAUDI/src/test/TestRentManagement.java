package test;

import customer.Customers;
import customer.SpecificCustomer;
import exceptions.AutomobileManagementVehiculesRentException;
import management.RentingManagement;
import vehicle.Manufacturer;
import vehicle.SpecificVehicle;
import vehicle.TypeVehicle;
import vehicle.Vehicles;

public class TestRentManagement extends RentingManagement {

    public void getReceipt(SpecificCustomer customer, SpecificVehicle vehicle) {
        System.out.println("Receipt for the rental of the vehicle " + vehicle.getId() + " by " + customer.getName());
    }

    /**
     * Test the rental of a vehicule.
     * Should be successful.
     */
    public static void testRentSuccess() {
        /* First we create a few clients and vehicules */
        Customers customers = Customers.getInstance();
        Vehicles vehicles = Vehicles.getInstance();
    
        customers.addCustomer("Doe", "John", "Blank", 28, 0);
        customers.addCustomer("Bayrou", "François", "Élysée, 125", 73, 17);
    
        customers.addCustomer("M&M's", 0.023);
        customers.addCustomer("Elysee", 0.01);
    
        vehicles.addVehicle("XX-XXX-XX", 3, TypeVehicle.SEDAN , Manufacturer.VOLSKA, "XR-3", 2400.356226, 25500);
        vehicles.addVehicle("2G-HK7-JJ", 5, TypeVehicle.BREAK, Manufacturer.FORDEON, "Raptor F-150", 120.412, 125000);
        vehicles.addVehicle("TT-228-FT", 2, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "TT-RS5", 127632.52, 1);
    
        /* Then we add the vehicules to the list of vehicules available for rent */
        // First we instantiate the list of vehicules available for rent
        RentingManagement rentingManagement = RentingManagement.getInstance();
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("XX-XXX-XX"));
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("2G-HK7-JJ"));
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("TT-228-FT"));
    
        rentingManagement.printRentAvailableVehicles();
        rentingManagement.printRentedVehicule(); // should be empty

        /* Then we rent a vehicule */
        try {
            rentingManagement.rentalRequest(vehicles.getVehicle("XX-XXX-XX"), customers.getCustomer("Bayrou", "François"), "01/01/2001");
        } catch (AutomobileManagementVehiculesRentException e) {
            System.out.println(e.getMessage());
        }
        rentingManagement.printRentedVehicule();
    
        /* Then we return the vehicule */
        try {
            rentingManagement.endRental(customers.getCustomer("Bayrou", "François"), vehicles.getVehicle("XX-XXX-XX"), "26/05/2004", 2536.24);
        } catch (AutomobileManagementVehiculesRentException e) {
            System.out.println(e.getMessage());
        }
    
        /* Now we check if the mileage was updated */
        System.out.println("\nMileage of the vehicle after the rental : " + vehicles.getVehicle("XX-XXX-XX").getMileage() + " km");

    }
    public static void main(String[] args) {
        testRentSuccess();
    }
}
