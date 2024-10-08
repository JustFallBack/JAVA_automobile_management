package vehicle;

import exceptions.AutomobileManagementVehicleException;

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

    public static NumberOfDoors getTypeFromNbDoors(int numberOfDoors) throws AutomobileManagementVehicleException {
        for (NumberOfDoors type : NumberOfDoors.values()) {
            if (type.getNumberOfDoors() == numberOfDoors) {
                return type;
            }
        }
        throw new AutomobileManagementVehicleException("No vehicle with this number of doors" + numberOfDoors);
    }

}
