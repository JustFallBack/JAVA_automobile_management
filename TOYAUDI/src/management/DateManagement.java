package management;
/*
 * Rental dates will be managed by a DateManagement class
 * containing a date attribute (String), a final format attribute (''dd/MM/yyyy'')
 * and an instance of the SimpleDateFormat class.
 */
import exceptions.AutomobileManagementCustomerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManagement {
    private String date;
    private final String dateFormat = "dd/MM/yyyy";
    // Date that prevents dates from being before the specified date (TOYAUDI creation date).
    private final String creationDateTOYAUDI = "01/01/2000";
    private final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public String getDate() {
        return this.date;
    }

    public DateManagement(String date) throws AutomobileManagementCustomerException {
        try {
            Date dateObject = sdf.parse(date);
            if (dateObject.after(sdf.parse(this.creationDateTOYAUDI))) {
                this.date = date;
            }
            else {
                throw new AutomobileManagementCustomerException("The date must be after 01/01/2000.");
            }
        } catch (ParseException e) {
            throw new AutomobileManagementCustomerException("The date is not in the correct format: 'dd/mm/yyyy'.");
        }
    }

    @Override
    public String toString() {
        try {
            Date dateD = sdf.parse(date);
            return dateD.toString();

        } catch (ParseException e) {
            System.out.println("Parsing error : " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        // Comparing memory addresses
        if (this == obj) {
            return true;
        }
        // If the comparison object is null, return false
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        DateManagement dateObj = (DateManagement) obj;
        return this.date.equals(dateObj.date);
    }

}
