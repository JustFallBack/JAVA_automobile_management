package vehicle;

import java.util.regex.Pattern;

import exceptions.AutomobileManagementVehicleException;

public class RegistrationNumber {
    
    // Identification number pattern
    private final Pattern REGISTRATION_PATTERN = Pattern.compile("^[A-Z0-9]{2}-[A-Z0-9]{3}-[A-Z0-9]{2}$");
    private String identification;

    RegistrationNumber(String identification) throws AutomobileManagementVehicleException {
        if (!checkID(identification)) {
            throw new AutomobileManagementVehicleException("ID must be in the format [XX-XXX-XX] where 'X' can be integer or capital letter.");
        }
        this.identification = identification;
    }

    public String getID() {
        return this.identification;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else {
            RegistrationNumber mock = (RegistrationNumber) obj;
            return identification != null && this.identification.equals(mock.identification);
        }
    }

    public boolean checkID(String id) {
        if (id == null) {
            return false;
        }
        return REGISTRATION_PATTERN.matcher(id).matches();
    }
}