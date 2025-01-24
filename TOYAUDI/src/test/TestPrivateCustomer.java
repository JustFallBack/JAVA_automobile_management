package test;

import customer.Customers;

/**
 * Class to test the PrivateCustomer class.
 * It tests different cases of valid and invalid creation of private customers.
 */
public class TestPrivateCustomer {
    public static void main(String[] args) {
        Customers customers = Customers.getInstance();

        /* Valid private customers */
        customers.addPrivateCustomer("Darmanin", "Gerald", "28 rue de la Vicieuse, Paris", 73, 4);
        customers.addPrivateCustomer("Hollande", "François", "12 rue de la Liberté, Paris", 55, 1);
        customers.addPrivateCustomer("De Gaulle", "Charles", "34 boulevard de l'Égalité, Lyon", 78, 2);
        customers.addPrivateCustomer("Sarkozy", "Nicolas", "56 avenue de la Fraternité, Marseille", 63, 3);
        customers.addPrivateCustomer("Pecresse", "Valerie", "78 rue de la République, Toulouse", 48, 4);
        customers.addPrivateCustomer("Pouton", "Philippe", "90 boulevard de la Nation, Nice", 68, 5);
        customers.addPrivateCustomer("Giscard d'Estaing", "Valerie", "123 avenue de la Paix, Nantes", 80, 6);
        customers.addPrivateCustomer("Attal", "Gabriel", "456 rue de la Justice, Strasbourg", 38, 7);
        customers.addPrivateCustomer("Le Pen", "Marine", "789 boulevard de la Démocratie, Montpellier", 50, 8);
        customers.addPrivateCustomer("Bardella", "Jordan", "321 avenue de la Liberté, Bordeaux", 47, 9);
        customers.addPrivateCustomer("Mitterand", "François", "654 rue de l'Égalité, Lille", 53, 10);
        customers.addPrivateCustomer("Nom", "Prénom", "", 18, 0);

        /* Invalid private customers */
        // Client already exists
        customers.addPrivateCustomer("Nom", "Prénom", "28", 32, 6);

        /* Invalid name */
        // Name is null
        customers.addPrivateCustomer(null, "François", "654 rue de l'Égalité, Lille", 53, 10);
        // Name too short
        customers.addPrivateCustomer("A", "Prenom", "123 rue de la Liberté, Paris", 24, 1);
        // Name too long
        customers.addPrivateCustomer("NomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNom", "Prenom", "123 rue de la Liberté, Paris", 24, 1);

        /* Invalid first name */
        // First name is null
        customers.addPrivateCustomer("Mitterand", null, "654 rue de l'Égalité, Lille", 53, 10);
        // First name too short
        customers.addPrivateCustomer("Nom", "A", "123 rue de la Liberté, Paris", 24, 1);
        // First name too long
        customers.addPrivateCustomer("Nom", "PrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenom", "123 rue de la Liberté, Paris", 24, 1);

        /* Invalid address */
        // Address is null
        customers.addPrivateCustomer("Nom", "Prenom", null, 24, 1);
        // Address too long
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, ParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParis", 24, 1);

        /* Invalid age */
        // Age too low
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 16, 1);
        // Age too high
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 82, 1);
        
        /* Invalid number of rentals */
        // Negative number of rentals
        customers.addPrivateCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, -1);

        customers.displayCustomers();
    }
}
