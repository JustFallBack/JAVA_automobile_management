package vehicle;

public enum NumberOfDoors {

    COUPE(2, "small and sporty"),
    HATCHBACK(3, "compact and practical"),
    SEDAN(4, "family car"),
    SUV(5, "large with high ground clearance"),;

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

}
