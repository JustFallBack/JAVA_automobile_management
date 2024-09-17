package vehicle;

import exceptions.AutomobileManagementVehicleException;

/*
 * Propose three classes corresponding to each type of vehicle 
 * (Sedan, Break, and Utility) containing the fields: the type of vehicle,
 * the number of doors of the vehicle, the registration number, 
 * the manufacturer (Manufacturer: Peugeot, etc.), the model (String), 
 * the mileage, and the purchasing price (double). 
 * Add a constructor to initialize these attributes.
 */
public class BreakVehicle extends Vehicles {
    private final RegistrationNumber id;
    private final NumberOfDoors nbDoors;
    private final TypeVehicle type;
    private final Manufacturer manufacturer;
    private String model;
    private double mileage;
    private double purchasingPrice;

    public BreakVehicle(String id,  
                        int numberOfDoors, 
                        Manufacturer manufacturer,
                        String model,
                        double mileage,
                        double purchasingPrice
                        ) throws AutomobileManagementVehicleException {

        try {
            if (model.length() < 2 || model.length() > 24) {
                throw new AutomobileManagementVehicleException("Model name must be between 2 and 24 characters long : " + model);
            }
            if (mileage < 0 || mileage > 1000000) {
                throw new AutomobileManagementVehicleException("Mileage must be positive and under 1,000,000 km : " + mileage);
            }
            if (purchasingPrice < 0 || purchasingPrice > 1000000) {
                throw new AutomobileManagementVehicleException("Purchasing price must be positive and under 1,000,000 : " + purchasingPrice);
            }
            this.id = new RegistrationNumber(id);
            this.nbDoors = NumberOfDoors.getTypeFromNbDoors(numberOfDoors);
        } catch (AutomobileManagementVehicleException e) {
            throw e;
        }
        this.type = TypeVehicle.BREAK;
        this.manufacturer = manufacturer;
        this.model = model;
        this.mileage = mileage;
        this.purchasingPrice = purchasingPrice;
    }

    public RegistrationNumber getId() {
        return id;
    }
    public NumberOfDoors getNumberOfDoors() {
        return nbDoors;
    }
    public TypeVehicle getType() {
        return type;
    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public double getMileage() {
        return mileage;
    }
    public double getPurchasingPrice() {
        return purchasingPrice;
    }

    @Override
    public String toString() {
        return "Vehicle type : " + this.getType() +
                "\nRegistration number : " + this.getId().getID() +
                "\nNumber of doors : " + this.getNumberOfDoors().getNumberOfDoors() +
                "\nManufacturer : " + this.getManufacturer() +
                "\nModel : " + this.getModel() +
                "\nMileage : " + this.getMileage() + " km" +
                "\nPurchasing price : " + this.getPurchasingPrice() + " €";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else {
            BreakVehicle mock = (BreakVehicle) obj;
            return id != null && this.id.equals(mock.id);
        }
    }

}
