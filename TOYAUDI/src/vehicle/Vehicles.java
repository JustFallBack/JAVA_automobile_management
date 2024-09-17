package vehicle;

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
            System.out.println(vehicle);
        }
    }

    public boolean existsVehicle(Vehicles vehicleObject) {
        for (Vehicles vehicle : this) {
            if (vehicle.equals(vehicleObject)) {
                return true;
            }
        }
        return false;
    }

    public void addBreakVehicle() {
        
    }
    
}
