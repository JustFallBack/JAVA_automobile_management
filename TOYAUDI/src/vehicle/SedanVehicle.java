package vehicle;

import exceptions.AutomobileManagementVehicleException;

public class SedanVehicle extends SpecificVehicle {
    private final TypeVehicle type;

    public SedanVehicle(String id,  
                        int numberOfDoors, 
                        Manufacturer manufacturer,
                        String model,
                        double mileage,
                        double purchasingPrice
                        ) throws AutomobileManagementVehicleException {
        super(id, numberOfDoors, manufacturer, model, mileage, purchasingPrice);
        this.type = TypeVehicle.SEDAN;
    }

    public TypeVehicle getType() {
        return type;
    }
}