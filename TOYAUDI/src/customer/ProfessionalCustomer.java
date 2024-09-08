package customer;
/*
 * or professional (ProfessionalCustomer, attributes: name, type, rental date, and discount rate applied to professional customers).
 * Add the constructors, etc. and any other methods you deem necessary now or during the project.
 */

import exceptions.AutomobileManagementProfessionalCustomerException;
import exceptions.AutomobileManagementCustomerException;
import management.DateManagement;

public class ProfessionalCustomer extends Customers{
    private String name;
    private CustomerType type;
    private DateManagement rentalDate;
    private double discountRate;

    public ProfessionalCustomer(String name, String rentalDate, double discountRate) throws AutomobileManagementProfessionalCustomerException {
        if (name.length() < 2 || name.length() > 20) {
            throw new AutomobileManagementProfessionalCustomerException("The professional customer's name must be between 2 and 20 characters.");
        }
        if (rentalDate == null) {
            throw new AutomobileManagementProfessionalCustomerException("The date cannot be null.");
        }
        if (discountRate < 0.0 || discountRate > 1.0) {
            throw new AutomobileManagementProfessionalCustomerException("The discount rate must be between 0.0 and 1.0.");
        }
        try {
            this.rentalDate = new DateManagement(rentalDate);
        } catch (AutomobileManagementCustomerException e) {
            throw new AutomobileManagementProfessionalCustomerException(e.getMessage());
        }
        this.name = name;
        this.type = CustomerType.PROFESSIONAL;
        this.discountRate = discountRate;
    }

    public String getName() {
        return this.name;
    }
    public CustomerType getType() {
        return this.type;
    }
    public String getRentalDate() {
        return this.rentalDate.toString();
    }
    public double getDiscountRate() {
        return this.discountRate;
    }

    @Override
    public String toString() {
        return "Name : " + this.getName() +
                "\nType : " + this.getType() +
                "\nRental date : " + this.getRentalDate() +
                "\nDiscount rate : " + this.getDiscountRate() + "\n";
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
        // Casting obj to ProfessionalCustomer to compare all attributes
        ProfessionalCustomer client = (ProfessionalCustomer) obj;
        return this.name.equals(client.name) &&
                this.type.equals(client.type) &&
                this.rentalDate.equals(client.rentalDate) &&
                Double.compare(this.discountRate, client.discountRate) == 0;
    }
}
