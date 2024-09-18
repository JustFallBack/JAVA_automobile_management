package vehicle;

import exceptions.AutomobileManagementVehicleException;

import java.util.Vector;

/**
 * Class that represents a collection of vehicles.
 * @extends Vector<Vehicles>
 */
public class Vehicles extends Vector<Vehicles> {
    private static Vehicles instance;

    public static Vehicles getInstance() {
        if (instance == null) {
            instance = new Vehicles();
        }
        return instance;
    }

    public void displayVehicles() {
        for (Vehicles vehicle : this) {
            System.out.println(vehicle + "\n");
        }
    }

    /**
     * Check if a vehicle already exists in the collection.
     * @param vehicleObject The vehicle to compare.
     * @return True if the vehicle already exists in the collection, false otherwise.
     */
    public boolean existsVehicle(Vehicles vehicleObject) {
        for (Vehicles vehicle : this) {
            if (vehicle.equals(vehicleObject)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a vehicle to the collection.
     * @param id Registration number of the vehicle.
     * @param numberOfDoors Number of doors of the vehicle.
     * @param type Type of the vehicle.
     * @param manufacturer Manufacturer of the vehicle.
     * @param model Model of the vehicle.
     * @param mileage Mileage of the vehicle.
     * @param purchasingPrice Purchasing price of the vehicle.
     */
    public void addVehicle(String id,
                            int numberOfDoors, 
                            TypeVehicle type, 
                            Manufacturer manufacturer, 
                            String model, 
                            double mileage, 
                            double purchasingPrice) {
        try {
            switch (type) {
                case TypeVehicle.UTILITY:
                    UtilityVehicle utilityVehicle = new UtilityVehicle(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
                    if (!existsVehicle(utilityVehicle)) {
                        this.add(utilityVehicle);
                        break;
                    }
                    throw new AutomobileManagementVehicleException("This vehicle (utility) already exists : " + utilityVehicle.getId() + "\n");
                case TypeVehicle.SEDAN:
                    SedanVehicle sedanVehicle = new SedanVehicle(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
                    if (!existsVehicle(sedanVehicle)) {
                        this.add(sedanVehicle);
                        break;
                    }
                    throw new AutomobileManagementVehicleException("This vehicle (sedan) already exists : " + sedanVehicle.getId() + "\n");
                case TypeVehicle.BREAK:
                    BreakVehicle breakVehicle = new BreakVehicle(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
                    if (!existsVehicle(breakVehicle)) {
                        this.add(breakVehicle);
                        break;
                    }
                    throw new AutomobileManagementVehicleException("This vehicle (break) already exists : " + breakVehicle.getId() + "\n");
                default:
                    throw new AutomobileManagementVehicleException("This type of car do not exist.");
                    
            }
        } catch (AutomobileManagementVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
