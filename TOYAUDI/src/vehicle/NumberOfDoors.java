package vehicle;

import exceptions.AutomobileManagementVehicleException;

/**
 * Enum that represents the number of doors of a vehicle.
 */
public enum NumberOfDoors {

    TWO_DOORS(2, "small and sporty"),
    THREE_DOORS(3, "compact and practical"),
    FOUR_DOORS(4, "family car"),
    FIVE_DOORS(5, "large with high ground clearance");

    private final int nbDoors;
    private final String description;

    NumberOfDoors(int nbDoors, String description) {
        this.nbDoors = nbDoors;
        this.description = description;
    }

    public int getNumberOfDoors() {
        return nbDoors;
    }

    public String getDescription() {
        return description;
    }

    /** 
     * Return an NumberOfDoors object depending of the integer which represents the nb of doors of the car.
     * @param numberOfDoors the number of doors of the car
     * @return The NumberOfDoors object corresponding to the number of doors
     */
    public static NumberOfDoors getTypeFromNbDoors(int numberOfDoors) throws AutomobileManagementVehicleException {
        for (NumberOfDoors type : NumberOfDoors.values()) {
            if (type.getNumberOfDoors() == numberOfDoors) {
                return type;
            }
        }
        throw new AutomobileManagementVehicleException("Vehicles must have 2,3,4 or 5 doors : " + numberOfDoors);
    }

}
