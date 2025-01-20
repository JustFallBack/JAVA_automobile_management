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
     * The date must be between 01/01/2000 and 01/01/2100.
     * @param date The date to implement.
     * @throws AutomobileManagementDateException
     */
    public DateManagement(String date) throws AutomobileManagementDateException {
        try {
            if (date == null) {
                throw new AutomobileManagementDateException("The date cannot be null.");
            }
            if (isBefore(this.CREATION_DATE_TOYAUDI, date)) {
                if (isBefore(date, "01/01/2100")) {
                    this.date = date;
                } else {
                    throw new AutomobileManagementDateException("The date must be before 01/01/2100 : " + date);
                }
            } else {
                throw new AutomobileManagementDateException("The date must be after 01/01/2000 : " + date);
            }
        } catch (ParseException e) {
            throw new AutomobileManagementDateException("The date is not in the correct format: 'dd/mm/yyyy' : " + date);
        }
    }

    public DateManagement() {
        this.date = sdf.format(new Date());
    }
    
    /**
     * Check if the first date (String) argument is stricly before the second date (String) argument.
     * @param date1 The first date to compare.
     * @param date2 The second date to compare.
     * @return true if first date is before the second date, false otherwise.
     */
    public boolean isBefore(String date1, String date2) throws ParseException {
        Date dateObject1 = sdf.parse(date1);
        Date dateObject2 = sdf.parse(date2);
        return dateObject1.before(dateObject2);
    }

    /**
     * Check if the first date (String) argument is before the second date (String) argument.
     * The strictness of the comparison depends on the 'strict' flag (true = strict).
     * @param date1 The first date to compare.
     * @param date2 The second date to compare.
     * @param stric If true, the first date must be strictly before the second date.
     * @return true if first date is before the second date, false otherwise.
     */
    public boolean isBefore(String date1, String date2, boolean strict) throws ParseException {
        if (strict) {
            return isBefore(date1, date2);
        }
        Date dateObject1 = sdf.parse(date1);
        Date dateObject2 = sdf.parse(date2);
        if (dateObject1.equals(dateObject2)) {
            return true;
        }
        return dateObject1.before(dateObject2);
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