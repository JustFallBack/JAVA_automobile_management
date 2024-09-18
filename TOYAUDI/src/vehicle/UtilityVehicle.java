package vehicle;

import exceptions.AutomobileManagementVehicleException;

public class UtilityVehicle extends SpecificVehicle {
    private final TypeVehicle type;

    public UtilityVehicle(String id,  
                        int numberOfDoors, 
                        Manufacturer manufacturer,
                        String model,
                        double mileage,
                        double purchasingPrice
                        ) throws AutomobileManagementVehicleException {
        super(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
        this.type = TypeVehicle.UTILITY;
    }

    public TypeVehicle getType() {
        return type;
    }
}