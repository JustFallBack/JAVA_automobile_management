package vehicle;

import exceptions.AutomobileManagementVehicleException;

public class BreakVehicle extends SpecificVehicle {
    private final TypeVehicle type;

    public BreakVehicle(String id,  
                        int numberOfDoors, 
                        Manufacturer manufacturer,
                        String model,
                        double mileage,
                        double purchasingPrice
                        ) throws AutomobileManagementVehicleException {
        super(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
        this.type = TypeVehicle.BREAK;
    }

    public TypeVehicle getType() {
        return type;
    }
}