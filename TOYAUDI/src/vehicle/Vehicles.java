package vehicle;

import exceptions.AutomobileManagementVehicleException;

import java.util.Vector;

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

    // Two vehicle are equal if their id is the same
    public boolean existsVehicle(Vehicles vehicleObject) {
        for (Vehicles vehicle : this) {
            if (vehicle.equals(vehicleObject)) {
                return true;
            }
        }
        return false;
    }

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
