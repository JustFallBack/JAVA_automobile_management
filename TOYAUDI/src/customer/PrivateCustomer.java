package customer;
import exceptions.AutomobileManagementCustomerException;
import exceptions.AutomobileManagementPrivateCustomerException;
import management.DateManagement;

/*
 * Cutomers will be either individuals (PrivateCustomer class, attributes: name, first name, age, address,
 * a type (CustomerClient), a date, and a number of rentals).
 */
public class PrivateCustomer extends Customers {
    private String name;
    private String firstName;
    private String address;
    private int age;
    private CustomerType type;
    private DateManagement date;
    private int nbRentals;

    public PrivateCustomer(String name, String firstName, String address, int age, String date, int nbRentals) throws AutomobileManagementPrivateCustomerException {
        if (age < 18 || age > 81) {
            throw new AutomobileManagementPrivateCustomerException("The age must be between 18 and 81 years old.");
        }
        if (name.length() < 2 || name.length() > 20 || firstName.length() < 2 || firstName.length() > 20) {
            throw new AutomobileManagementPrivateCustomerException("The name and first name can be between 2 and 20 characters long.");
        }
        if (address.length() < 5 || address.length() > 100) {
            throw new AutomobileManagementPrivateCustomerException("The address must be between 5 and 100 characters long.");
        }
        if (nbRentals < 0) {
            throw new AutomobileManagementPrivateCustomerException("The number of rentals cannot be negative.");
        }
        if (date == null) {
            throw new AutomobileManagementPrivateCustomerException("The date cannot be null");
        }
        try {
            this.date = new DateManagement(date);
        } catch (AutomobileManagementCustomerException e) {
            throw new AutomobileManagementPrivateCustomerException(e.getMessage());
        }
        this.type = CustomerType.PRIVATE;
        this.age = age;
        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.nbRentals = nbRentals;
    }

    public String getName() {
        return name;
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
        // Casting obj to PrivateCustomer to compare all attributes
        PrivateCustomer customer = (PrivateCustomer) obj;
        return this.name.equals(customer.name) &&
                this.firstName.equals(customer.firstName) &&
                this.address.equals(customer.address) &&
                this.age == customer.age &&
                this.type == customer.type &&
                this.date.equals(customer.date) &&
                this.nbRentals == customer.nbRentals;
    }
}
