package test;

import customer.Customers;
import customer.SpecificCustomer;
import management.RentingManagement;
import vehicle.Manufacturer;
import vehicle.SpecificVehicle;
import vehicle.TypeVehicle;
import vehicle.Vehicles;

public class TestRentManagement extends RentingManagement {

    public void getReceipt(SpecificCustomer customer, SpecificVehicle vehicle) {
        System.out.println("Receipt for the rental of the vehicle " + vehicle.getId() + " by " + customer.getName());
    }
    public static void main(String[] args) {
        /* First we create a few clients and vehicules */
        Customers customers = Customers.getInstance();
        Vehicles vehicles = Vehicles.getInstance();

        try {
            customers.addPrivateCustomer("Doe", "John", "Blank", 28, 0);
            customers.addPrivateCustomer("Bayrou", "François", "Élysée, 125", 73, 17);

            customers.addProfessionalCustomer("M&M's", 0.023);
            customers.addProfessionalCustomer("Elysee", 0.01);

            vehicles.addVehicle("XX-XXX-XX", 3, TypeVehicle.SEDAN , Manufacturer.VOLSKA, "XR-3", 2400.356226, 25500);
            vehicles.addVehicle("2G-HK7-JJ", 5, TypeVehicle.BREAK, Manufacturer.FORDEON, "Raptor F-150", 120.412, 125000);
            vehicles.addVehicle("TT-228-FT", 2, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "TT-RS5", 127632.52, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Then we add the vehicules to the list of vehicules available for sale and rent */
        // First we instantiate the list of vehicules available for sale
        RentingManagement rentingManagement = RentingManagement.getInstance();
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("XX-XXX-XX"));
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("2G-HK7-JJ"));
        rentingManagement.addToRentAvailableVehicles(vehicles.getVehicle("TT-228-FT"));

        rentingManagement.printRentAvailableVehicles();
        rentingManagement.printRentedVehicule(); // should be empty
        /* Then we rent a few vehicules */
        try {
            rentingManagement.rentalRequest(vehicles.getVehicle("XX-XXX-XX"), customers.getCustomer("Bayrou", "François"), "01/01/2001");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        rentingManagement.printRentedVehicule();

    }
}
