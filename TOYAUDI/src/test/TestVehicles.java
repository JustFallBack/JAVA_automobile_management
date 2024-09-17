package test;

import vehicle.Vehicles;
import vehicle.TypeVehicle;
import vehicle.Manufacturer;

public class TestVehicles {

    public static void main(String[] args) {
        Vehicles vehicles = Vehicles.getInstance();

        // Valid vehicles
        vehicles.addVehicle("XX-XXX-XX", 3, TypeVehicle.SEDAN , Manufacturer.VOLSKA, "XR-3", 2400.356226, 25500);
        vehicles.addVehicle("2G-HK7-JJ", 5, TypeVehicle.BREAK, Manufacturer.FORDEON, "Raptor F-150", 120.412, 125000);
        vehicles.addVehicle("TT-228-FT", 2, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "TT-RS5", 1, 1);
        
        // Invalid vehicles
        // Already exists (same id)
        vehicles.addVehicle("TT-228-FT", 3, TypeVehicle.BREAK, Manufacturer.PEUGOT, "234", 28007.33, 800000.95511);
        vehicles.displayVehicles();
    }
    
}
