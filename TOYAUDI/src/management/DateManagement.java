package management;

import exceptions.AutomobileManagementDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Rental dates will be managed by a DateManagement class
 * containing a date attribute (String), a final format attribute (''dd/MM/yyyy'')
 * and an instance of the SimpleDateFormat class.
 */
public class DateManagement {
    /**
     * The formatted date.
     */
    private String date;
    /**
     * The format of the date.
     */
    private final String DATE_FORMAT = "dd/MM/yyyy";
    /**
     * Date that prevents dates from being before the specified date (TOYAUDI creation date).
     */
    private final String CREATION_DATE_TOYAUDI = "01/01/2000";
    /**
     * Instance of the SimpleDateFormat class.
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public String getDate() {
        return this.date;
    }

    /**
     * Constructor of the class DateManagement.
     * @param date The date to implement.
     * @throws AutomobileManagementDateException
     */
    public DateManagement(String date) throws AutomobileManagementDateException {
        try {
            Date dateObject = sdf.parse(date);
            if (dateObject.after(sdf.parse(this.CREATION_DATE_TOYAUDI))) {
                this.date = date;
            }
            else {
                throw new AutomobileManagementDateException("The date must be after 01/01/2000 : " + date);
            }
        } catch (ParseException e) {
            throw new AutomobileManagementDateException("The date is not in the correct format: 'dd/mm/yyyy' : " + date);
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

    /**
     * Two DateManagement objects are equal if their dates are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        DateManagement dateObj = (DateManagement) obj;
        return this.date.equals(dateObj.date);
    }
}