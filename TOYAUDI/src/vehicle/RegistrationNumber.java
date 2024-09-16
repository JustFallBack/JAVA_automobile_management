package vehicle;

public class RegistrationNumber {
    
    private String identification;

    RegistrationNumber(String identification) {
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
}
