package test;

import vehicle.Vehicles;
import vehicle.TypeVehicle;
import vehicle.Manufacturer;

/**
 * This class tests the Vehicles class.
 * It tests the limits of the number of doors, the model name, the mileage, and the price.
 * It also tests the validity of the ID.
 */
public class TestVehicles {

    public static void main(String[] args) {
        Vehicles vehicles = Vehicles.getInstance();

        /* Valid vehicles */
        vehicles.addVehicle("XX-XXX-XX", 3, TypeVehicle.SEDAN , Manufacturer.VOLSKA, "XR-3", 2400.356226, 25500);
        vehicles.addVehicle("2G-HK7-JJ", 5, TypeVehicle.BREAK, Manufacturer.FORDEON, "Raptor F-150", 120.412, 125000);
        vehicles.addVehicle("TT-228-FT", 2, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "TT-RS5", 1, 1);
        vehicles.addVehicle("AA-123-AA", 4, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "308 Allure", 125000.45, 18000);
        vehicles.addVehicle("BB-456-BB", 5, TypeVehicle.BREAK, Manufacturer.VOLSKA, "Golf Variant", 45000.12, 22000);
        vehicles.addVehicle("CC-789-CC", 2, TypeVehicle.UTILITY, Manufacturer.FORDEON, "F-150 Raptor", 340000.89, 60000);
        vehicles.addVehicle("DD-321-DD", 3, TypeVehicle.SEDAN, Manufacturer.CHEVROVER, "Malibu", 98000.34, 15000);
        vehicles.addVehicle("EE-654-EE", 5, TypeVehicle.BREAK, Manufacturer.TOYAUDI, "A4 Avant", 220000.99, 27000);
        vehicles.addVehicle("FF-987-FF", 4, TypeVehicle.UTILITY, Manufacturer.HYENDA, "Santa Cruz", 190000.78, 29000);
        vehicles.addVehicle("GG-111-GG", 4, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "508 GT", 75000.65, 32000);
        vehicles.addVehicle("HH-222-HH", 5, TypeVehicle.BREAK, Manufacturer.VOLSKA, "Passat Estate", 155000.40, 35000);
        vehicles.addVehicle("II-333-II", 2, TypeVehicle.UTILITY, Manufacturer.FORDEON, "Bronco", 12000.56, 45000);
        vehicles.addVehicle("JJ-444-JJ", 4, TypeVehicle.SEDAN, Manufacturer.CHEVROVER, "Cruze", 85000.77, 16000);
        vehicles.addVehicle("KK-555-KK", 3, TypeVehicle.BREAK, Manufacturer.TOYAUDI, "Corolla Touring", 60000.12, 21000);
        vehicles.addVehicle("LL-666-LL", 5, TypeVehicle.UTILITY, Manufacturer.HYENDA, "Tucson", 450000.98, 37000);
        vehicles.addVehicle("MM-777-MM", 4, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "208 Active", 67000.89, 14000);
        vehicles.addVehicle("NN-888-NN", 2, TypeVehicle.BREAK, Manufacturer.VOLSKA, "Jetta SW", 105000.45, 25000);
        vehicles.addVehicle("OO-999-OO", 5, TypeVehicle.UTILITY, Manufacturer.FORDEON, "Explorer", 49000.55, 55000);
        vehicles.addVehicle("PP-111-PP", 3, TypeVehicle.SEDAN, Manufacturer.CHEVROVER, "Impala", 75000.23, 17000);
        vehicles.addVehicle("QQ-222-QQ", 4, TypeVehicle.BREAK, Manufacturer.TOYAUDI, "Prius v", 112000.34, 18000);
        vehicles.addVehicle("RR-333-RR", 5, TypeVehicle.UTILITY, Manufacturer.HYENDA, "Palisade", 88000.12, 40000);
        vehicles.addVehicle("SS-444-SS", 3, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "3008", 35000.99, 27000);
        vehicles.addVehicle("TT-555-TT", 4, TypeVehicle.BREAK, Manufacturer.VOLSKA, "Tiguan Allspace", 129000.87, 33000);
    
        // Lower boundary for doors, model name, mileage, and price
        vehicles.addVehicle("AB-123-CD", 2, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "C4", 0, 0.1);
        // Upper boundary for doors, mileage, and price
        vehicles.addVehicle("EF-456-GH", 5, TypeVehicle.BREAK, Manufacturer.FORDEON, "Focus Estate", 1000000, 1000000);
        
        /* Invalid vehicles */

        /* Invalid ID */
        // Invalid ID : a vehicle with the same ID already exists
        vehicles.addVehicle("TT-228-FT", 3, TypeVehicle.BREAK, Manufacturer.CHEVROVER, "CAMARAT", 284.45, 900);
        // Invalid ID: missing dash
        vehicles.addVehicle("AB123CD", 4, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "208", 10000.5, 20000);
        // Invalid ID: wrong format
        vehicles.addVehicle("123-ABC-12", 3, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "Rav4", 50000.5, 15000);
        // Invalid ID : null
        vehicles.addVehicle(null, 3, TypeVehicle.UTILITY, Manufacturer.TOYAUDI, "Rav4", 50000.5, 15000);
        // Invalid ID : letters must be capital
        vehicles.addVehicle("FF-FFF-Ff", 4, TypeVehicle.SEDAN, Manufacturer.HYENDA, "clio 2", 50.5, 27500);

        /* Invalid number of doors */
        // Too few doors
        vehicles.addVehicle("UV-223-WX", 1, TypeVehicle.BREAK, Manufacturer.VOLSKA, "Golf SW", 20000.0, 10000);
        // Too many doors
        vehicles.addVehicle("YZ-334-AB", 6, TypeVehicle.UTILITY, Manufacturer.HYENDA, "Palisade", 30000.0, 50000);
        // Negative number of doors
        vehicles.addVehicle("ZY-UBU-CC", -6, TypeVehicle.UTILITY, Manufacturer.HYENDA, "Palisade", 30000.0, 50000);

        /* Invalid mileage */
        // Negative mileage
        vehicles.addVehicle("CD-445-EF", 4, TypeVehicle.SEDAN, Manufacturer.FORDEON, "Mondeo", -500.0, 20000);
        // Exceeds upper limit for mileage
        vehicles.addVehicle("GH-556-IJ", 3, TypeVehicle.BREAK, Manufacturer.TOYAUDI, "Avensis", 1000000.001, 15000);

        /* Invalid price */
        // Negative price
        vehicles.addVehicle("KL-667-MN", 4, TypeVehicle.UTILITY, Manufacturer.CHEVROVER, "Blazer", 10000.0, -100);
        // Exceeds upper limit for price
        vehicles.addVehicle("OP-778-QR", 5, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "508", 250000.0, 1000000.001);
        // Price is zero
        vehicles.addVehicle("28-TTT-RQ", 2, TypeVehicle.SEDAN, Manufacturer.PEUGOT, "306", 25000.599, 0);

        /* Invalid model name */
        // Model name too short (less than 2 characters)
        vehicles.addVehicle("ST-889-UV", 3, TypeVehicle.BREAK, Manufacturer.FORDEON, "F", 50000.0, 30000);
        // Model name too long (more than 24 characters)
        vehicles.addVehicle("WX-990-YZ", 4, TypeVehicle.UTILITY, Manufacturer.HYENDA, "VeryLongModelNameBeyondLimit", 80000.0, 45000);
        // Model name is null
        vehicles.addVehicle("AB-123-CD", 3, TypeVehicle.SEDAN, Manufacturer.HYENDA, null, 756.8, 15700);
        
        /* Invalid type */
        // Type is null
        vehicles.addVehicle("AB-123-CD", 3, null, Manufacturer.PEUGOT, "2008", 10000.5, 20000);

        /* Invalid manufacturer */
        // Manufacturer is null
        vehicles.addVehicle("AB-123-CD", 5, TypeVehicle.SEDAN, null, "85", 107.25, 14625);
        
        vehicles.displayVehicles();
    }
    
}
