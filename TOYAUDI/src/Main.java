import exceptions.AutomobileManagementCustomerException;
import management.DateManagement;
import vehicle.NumberOfDoors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        for (NumberOfDoors type : NumberOfDoors.values()) {
            System.out.println(type + ": " + type.getNumberOfDoors() + " doors vehicle, " + type.getDescription());
        }
    }
}