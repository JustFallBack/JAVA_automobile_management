package vehicle;

import exceptions.AutomobileManagementVehicleException;
import management.DateManagement;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class that represents a specific vehicle.
 * @extends Vehicles
 */
public abstract class SpecificVehicle extends Vehicles {
    /**
     * The registration number of the vehicle.
     * Must respect RegistrationNumber.REGISTRATION_PATTERN.
     */
    private final RegistrationNumber id;
    /**
     * The number of doors of the vehicle.
     * Must be between 2 and 5.
     */
    private final NumberOfDoors nbDoors;
    /**
     * The manufacturer of the vehicle.
     * Must be a manufacturer from the enumeration Manufacturer.
     */
    private final Manufacturer manufacturer;
    /**
     * The model of the vehicle.
     * Must be between 2 and 24 characters long.
     */
    private String model;
    /**
     * The mileage of the vehicle.
     * Must be positive and under 1,000,000 km.
     */
    private double mileage;
    /**
     * The purchasing price of the vehicle.
     * Must be positive, not zero and under 1,000,000€.
     */
    private double purchasingPrice;
    /** 
     * The date the rental of the vehicle ended.
     * Used to calculate the price of the rental.
     * Initially, the date is set to null.
     */
    private DateManagement endRentalDate;
    /**
     * The mileage of the vehicle when the rental ends.
     * Must be positive and under 1,000,000 km.
     */
    private double endRentalMileage;

    /**
     * Constructor of the class SpecificVehicle.
     * @param id The registration number of the vehicle.
     * @param numberOfDoors The number of doors of the vehicle.
     * @param manufacturer The manufacturer of the vehicle.
     * @param model The model of the vehicle.
     * @param mileage The mileage of the vehicle.
     * @param purchasingPrice The purchasing price of the vehicle.
     * @throws AutomobileManagementVehicleException
     */
    public SpecificVehicle(String id,  
                        int numberOfDoors, 
                        Manufacturer manufacturer,
                        String model,
                        double mileage,
                        double purchasingPrice
                        ) throws AutomobileManagementVehicleException {

        try {
            if (model == null || manufacturer == null) { // verification on ID is done in RegistrationNumber
                throw new AutomobileManagementVehicleException("Cannot create a vehicle with null values.");
            }
            if (model.length() < 2 || model.length() > 24) {
                throw new AutomobileManagementVehicleException("Model name must be between 2 and 24 characters long : " + model);
            }
            if (mileage < 0 || mileage > 1000000) {
                throw new AutomobileManagementVehicleException("Mileage must be positive and under 1,000,000 km : " + mileage);
            }
            if (purchasingPrice <= 0 || purchasingPrice > 1000000) {
                throw new AutomobileManagementVehicleException("Purchasing price must be positive, not zero and under $1,000,000 : " + purchasingPrice);
            }
            this.id = new RegistrationNumber(id);
            this.nbDoors = NumberOfDoors.getTypeFromNbDoors(numberOfDoors);
        } catch (AutomobileManagementVehicleException e) {
            throw e;
        }
        this.manufacturer = manufacturer;
        this.model = model;
        this.mileage = new BigDecimal(mileage).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.purchasingPrice = new BigDecimal(purchasingPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.endRentalDate = null;
        this.endRentalMileage = mileage;
    }

    public String getId() {
        return id.getID();
    }
    public int getNumberOfDoors() {
        return nbDoors.getNumberOfDoors();
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
    public String getEndRentalDate() {
        return endRentalDate.toString();
    }
    public double getEndRentalMileage() {
        return endRentalMileage;
    }

    public void setEndRentalDate(DateManagement endRentalDate) {
        this.endRentalDate = endRentalDate;
    }
    public void setEndRentalMileage(double endRentalMileage) {
        this.endRentalMileage = endRentalMileage;
    }
    public void setNewMileage(double newMileage) {
        this.mileage = newMileage;
    }

    public abstract TypeVehicle getType();

    @Override
    public String toString() {
        return 
            "\nRegistration number : " + this.getId() +
            "\nVehicle type : " + this.getType() +
            "\nNumber of doors : " + this.getNumberOfDoors() +
            "\nManufacturer : " + this.getManufacturer() +
            "\nModel : " + this.getModel() +
            "\nMileage : " + this.getMileage() + " km" +
            "\nPurchasing price : " + this.getPurchasingPrice() + " €";
    }

    /**
     * Two vehicles are equals if they have the same registration number.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        SpecificVehicle vehicle = (SpecificVehicle) obj;
        return this.id != null && this.id.getID().equals(vehicle.id.getID());
    }
}
