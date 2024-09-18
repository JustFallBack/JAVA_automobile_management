import vehicle.NumberOfDoors;

public class Main {
    public static void main(String[] args) {
        for (NumberOfDoors type : NumberOfDoors.values()) {
            System.out.println(type + ": " + type.getNumberOfDoors() + " doors vehicle, " + type.getDescription());
        }
    }
}