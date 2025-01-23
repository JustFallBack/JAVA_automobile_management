package management;

import customer.SpecificCustomer;
import exceptions.AutomobileManagementVehicleSaleException;
import vehicle.SpecificVehicle;

/**
 * Manages the sale of vehicles.
 * @extends Management
 */
public class SaleManagement extends Management {
    /**
     * Method to request a sale. When sold, a vehicle is removed from the list of available vehicles for sale and for rent.
     * @param customer The customer buying the vehicle.
     * @param vehicle The vehicle to sell.
     * @return true if the sale request is successful, exception raised otherwise.
     * @throws AutomobileManagementVehicleSaleException
     */
    public boolean saleRequest(SpecificCustomer customer, SpecificVehicle vehicle) throws AutomobileManagementVehicleSaleException {
        if (!super.removeFromSaleAvailableVehicles(vehicle)) {
            throw new AutomobileManagementVehicleSaleException("The vehicle is not available for sale : " + vehicle.toString());
        }
        super.removeFromRentAvailableVehicles(vehicle);
        getReceipt(customer, vehicle);
        return true;
    }

    /**
     * Print the receipt for the sale.
     * @param customer The customer buying the vehicle.
     * @param vehicle The vehicle to sell.
     */
    public void getReceipt(SpecificCustomer customer, SpecificVehicle vehicle) throws AutomobileManagementVehicleSaleException{
        System.out.println("Receipt for the sale :\n" + vehicle.toString() + "\nBought by :\n" + customer.toString());
        System.out.println("Price : $" + super.getSalePrice(vehicle));
    }
}
