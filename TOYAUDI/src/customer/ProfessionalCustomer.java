package customer;

import exceptions.AutomobileManagementProfessionalCustomerException;
import exceptions.AutomobileManagementCustomerException;
import exceptions.AutomobileManagementDateException;
import management.DateManagement;

/**
 * Class to define a professional customer.
 * @extends SpecificCustomer
 */
public class ProfessionalCustomer extends SpecificCustomer {
    /**
     * The type of the customer.
     * Always set to PROFESSIONAL.
     */
    private final CustomerType type;
    /**
     * The date the professional customer rented a vehicle.
     */
    private DateManagement rentalDate;
    /**
     * The discount rate of the professional customer.
     * Must be between 0.0 and 1.0.
     */
    private double discountRate;

    /**
     * Constructor of the class ProfessionalCustomer.
     * @param name The name of the professional customer.
     * @param rentalDate The date when the professional customer rented a vehicle.
     * @param discountRate The discount rate of the professional customer.
     * @throws AutomobileManagementProfessionalCustomerException
     */
    public ProfessionalCustomer(String name, 
                                String rentalDate, 
                                double discountRate
                                ) throws AutomobileManagementCustomerException {
        super(name);
        if (discountRate < 0.0 || discountRate > 1.0) {
            throw new AutomobileManagementProfessionalCustomerException("Discount rate must be between 0.0 and 1.0 : " + discountRate);
        }
        try {
            if (rentalDate == null) {
                throw new AutomobileManagementDateException("The date cannot be null.");
            }
            this.rentalDate = new DateManagement(rentalDate);
        } catch (AutomobileManagementDateException e) {
            throw new AutomobileManagementProfessionalCustomerException(e.getMessage());
        }
        this.type = CustomerType.PROFESSIONAL;
        this.discountRate = discountRate;
    }

    public String getName() {
        return super.getName();
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

    /**
     * Two professional customers are equal if they have the same name and type.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // Casting obj to ProfessionalCustomer to compare name and type.
        ProfessionalCustomer client = (ProfessionalCustomer) obj;
        return this.getName().equals(client.getName()) &&
                this.type.equals(client.type);
    }
}
