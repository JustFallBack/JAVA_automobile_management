package vehicle;

/**
 * Enum that represents the type of vehicle.
 */
public enum TypeVehicle {
    UTILITY(59, 0.30, "Built for work and transporting goods"), 
    BREAK(41, 0.25, "extended cargo space, ideal for families"), 
    SEDAN(55, 0.20, "practical and comfortable");

    private final double dailyRentPrice;
    private final double pricePerKilometer;
    private final String description;

    TypeVehicle(double dailyRentPrice, double pricePerKilometer ,String description) {
        this.dailyRentPrice = dailyRentPrice;
        this.pricePerKilometer = pricePerKilometer;
        this.description = description;
    }

    public double getDailyRentPrice() {
        return this.dailyRentPrice;
    }
    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }
    public String getDescription() {
        return this.description;
    }

}
