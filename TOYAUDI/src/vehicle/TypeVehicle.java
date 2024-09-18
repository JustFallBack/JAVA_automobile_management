package vehicle;

/**
 * Enum that represents the type of vehicle.
 */
public enum TypeVehicle {
    UTILITY(5000, "Built for work and transporting goods"), 
    BREAK(5000, "extended cargo space, ideal for families"), 
    SEDAN(5000, "practical and comfortable");

    private final double dailyRentPrice;
    private final String description;

    TypeVehicle(double dailyRentPrice, String description) {
        this.dailyRentPrice = dailyRentPrice;
        this.description = description;
    }

    public double getRentPrice() {
        return this.dailyRentPrice;
    }

    public String getDescription() {
        return this.description;
    }
}
