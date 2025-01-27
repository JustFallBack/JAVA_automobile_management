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
        customers.addCustomer("Darmanin", "Gerald", "28 rue de la Vicieuse, Paris", 73, 4);
        customers.addCustomer("Hollande", "François", "12 rue de la Liberté, Paris", 55, 1);
        customers.addCustomer("De Gaulle", "Charles", "34 boulevard de l'Égalité, Lyon", 78, 2);
        customers.addCustomer("Sarkozy", "Nicolas", "56 avenue de la Fraternité, Marseille", 63, 3);
        customers.addCustomer("Pecresse", "Valerie", "78 rue de la République, Toulouse", 48, 4);
        customers.addCustomer("Pouton", "Philippe", "90 boulevard de la Nation, Nice", 68, 5);
        customers.addCustomer("Giscard d'Estaing", "Valerie", "123 avenue de la Paix, Nantes", 80, 6);
        customers.addCustomer("Attal", "Gabriel", "456 rue de la Justice, Strasbourg", 38, 7);
        customers.addCustomer("Le Pen", "Marine", "789 boulevard de la Démocratie, Montpellier", 50, 8);
        customers.addCustomer("Bardella", "Jordan", "321 avenue de la Liberté, Bordeaux", 47, 9);
        customers.addCustomer("Mitterand", "François", "654 rue de l'Égalité, Lille", 53, 10);
        customers.addCustomer("Nom", "Prénom", "", 18, 0);

        /* Invalid private customers */
        // Client already exists
        customers.addCustomer("Nom", "Prénom", "28", 32, 6);

        /* Invalid name */
        // Name is null
        customers.addCustomer(null, "François", "654 rue de l'Égalité, Lille", 53, 10);
        // Name too short
        customers.addCustomer("A", "Prenom", "123 rue de la Liberté, Paris", 24, 1);
        // Name too long
        customers.addCustomer("NomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNom", "Prenom", "123 rue de la Liberté, Paris", 24, 1);

        /* Invalid first name */
        // First name is null
        customers.addCustomer("Mitterand", null, "654 rue de l'Égalité, Lille", 53, 10);
        // First name too short
        customers.addCustomer("Nom", "A", "123 rue de la Liberté, Paris", 24, 1);
        // First name too long
        customers.addCustomer("Nom", "PrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenom", "123 rue de la Liberté, Paris", 24, 1);

        /* Invalid address */
        // Address is null
        customers.addCustomer("Nom", "Prenom", null, 24, 1);
        // Address too long
        customers.addCustomer("Nom", "Prenom", "123 rue de la Liberté, ParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParis", 24, 1);

        /* Invalid age */
        // Age too low
        customers.addCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 16, 1);
        // Age too high
        customers.addCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 82, 1);
        
        /* Invalid number of rentals */
        // Negative number of rentals
        customers.addCustomer("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, -1);

        customers.displayCustomers();
    }
}
