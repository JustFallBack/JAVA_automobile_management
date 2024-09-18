package test;

import customer.Customers;

public class TestPrivateCustomer {
    public static void main(String[] args) {
        Customers customers = Customers.getInstance();

        /* Valid private customers */
        customers.addPrivateCustomer("Darmanin", "Gerald", "28 rue de la Vicieuse, Paris", 73, "01/01/2001", 4);
        customers.addPrivateCustomer("Hollande", "François", "12 rue de la Liberté, Paris", 55, "01/01/2024", 1);
        customers.addPrivateCustomer("De Gaulle", "Charles", "34 boulevard de l'Égalité, Lyon", 78, "02/02/2002", 2);
        customers.addPrivateCustomer("Sarkozy", "Nicolas", "56 avenue de la Fraternité, Marseille", 63, "03/03/2001", 3);
        customers.addPrivateCustomer("Pecresse", "Valerie", "78 rue de la République, Toulouse", 48, "04/04/2003", 4);
        customers.addPrivateCustomer("Pouton", "Philippe", "90 boulevard de la Nation, Nice", 68, "05/05/2005", 5);
        customers.addPrivateCustomer("Giscard d'Estaing", "Valerie", "123 avenue de la Paix, Nantes", 80, "06/06/2023", 6);
        customers.addPrivateCustomer("Attal", "Gabriel", "456 rue de la Justice, Strasbourg", 38, "07/07/2002", 7);
        customers.addPrivateCustomer("Le Pen", "Marine", "789 boulevard de la Démocratie, Montpellier", 50, "08/08/2006", 8);
        customers.addPrivateCustomer("Bardella", "Jordan", "321 avenue de la Liberté, Bordeaux", 47, "09/09/2014", 9);
        customers.addPrivateCustomer("Mitterand", "François", "654 rue de l'Égalité, Lille", 53, "10/10/2008", 10);

        /* Invalid private customers */
        // Name too short
        customers.addPrivateCustomer("A", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Name too long
        customers.addPrivateCustomer("NomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNom", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // First name too short
        customers.addPrivateCustomer("Nom", "A", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // First name too long
        customers.addPrivateCustomer("Nom", "PrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Address too short
        customers.addPrivateCustomer("Nom", "Prenom", "123", 24, "01/01/2000", 1);
        // Address too long
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, ParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParis", 24, "01/01/2000", 1);
        // Age too low
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 16, "01/01/2000", 1);
        // Age too high
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 82, "01/01/2000", 1);
        // Incorrect date format
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "01-01-2000", 1);
        // Date before TOYAUDI creation date
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "31/12/1999", 1);
        // Negative number of rentals
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", -1);

        customers.displayCustomers();
    }
}
