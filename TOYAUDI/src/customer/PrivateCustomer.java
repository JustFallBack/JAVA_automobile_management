package customer;
import exceptions.AutomobileManagementPrivateCustomerException;
import exceptions.AutomobileManagementCustomerException;
import exceptions.AutomobileManagementDateException;
import management.DateManagement;

/**
 * Class to define a private customer.
 * @extends SpecificCustomer
 */
public class PrivateCustomer extends SpecificCustomer {
    /**
     * The first name of the private customer.
     * Must be between 2 and 20 characters long.
     */
    private String firstName;
    /**
     * The address of the private customer.
     * Must be between 5 and 100 characters long.
     */
    private String address;
    /**
     * The age of the private customer.
     * Must be between 18 and 81 years old.
     */
    private int age;
    /**
     * The type of the customer.
     * Always set to PRIVATE.
     */
    private final CustomerType type;
    /**
     * The date of birth of the private customer.
     */
    private DateManagement date;
    /**
     * The number of times the private customer has rented a car.
     * Must be positive.
     */
    private int nbRentals;

    /**
     * Constructor of the class PrivateCustomer.
     * @param name The name of the private customer.
     * @param firstName The first name of the private customer.
     * @param address The address of the private customer.
     * @param age The age of the private customer.
     * @param date The date of birth of the private customer.
     * @param nbRentals The number of times the private customer has rented a car.
     * @throws AutomobileManagementPrivateCustomerException
     */
    public PrivateCustomer(String name,
                             String firstName, 
                             String address, 
                             int age, 
                             String date, 
                             int nbRentals
                             ) throws AutomobileManagementCustomerException {
        super(name);
        if (age < 18 || age > 81) {
            throw new AutomobileManagementPrivateCustomerException("The client age must be between 18 and 81 years old : " + age);
        }
        if (firstName == null) {
            throw new AutomobileManagementPrivateCustomerException("The client first name can not be null.");
        }
        if (firstName.length() < 2 || firstName.length() > 20) {
            throw new AutomobileManagementPrivateCustomerException("The client first name must be between 2 and 20 characters long : " + name + " " + firstName);
        }
        if (address == null) {
            throw new AutomobileManagementPrivateCustomerException("The address can not be null.");
        }
        if (address.length() > 100) {
            throw new AutomobileManagementPrivateCustomerException("The address must not be more than 100 characters long : " + address);
        }
        if (nbRentals < 0) {
            throw new AutomobileManagementPrivateCustomerException("The number of rentals must be positive : " + nbRentals);
        }
        try {
            if (date == null) {
                throw new AutomobileManagementDateException("The date cannot be null.");
            }
            this.date = new DateManagement(date);
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementPrivateCustomerException(e.getMessage());
        }
        this.type = CustomerType.PRIVATE;
        this.age = age;
        this.firstName = firstName;
        this.address = address;
        this.nbRentals = nbRentals;
    }

    public String getName() {
        return super.getName();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getAddress() {
        return address;
    }
    public int getAge() {
        return age;
    }
    public int getNbRentals() {
        return nbRentals;
    }
    public String getDate() {
        return date.toString();
    }
    public CustomerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() +
                "\nFirst name : " + this.getFirstName() +
                "\nAddress : " +  this.getAddress() +
                "\nAge : " + this.getAge() +
                "\nRentals number : " + this.getNbRentals() +
                "\nDate : " + this.getDate() +
                "\nType : " + this.getType() + "\n";
    }

    /**
     * Two private customers are equal if they have the same name and first name.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        PrivateCustomer customer = (PrivateCustomer) obj;
        return this.getName().equals(customer.getName()) &&
                this.firstName.equals(customer.firstName);
    }
}
