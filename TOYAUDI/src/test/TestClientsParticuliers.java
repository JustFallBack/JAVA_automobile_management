package test;

import client.Clients;

public class TestClientsParticuliers {
    public static void main(String[] args) {
        Clients clients = Clients.getInstance();

        // Clients particuliers valides
        clients.addClientParticulier("Darmanin", "Gerald", "28 rue de la Vicieuse, Paris", 73, "01/01/2001",4);
        clients.addClientParticulier("Hollande", "François", "12 rue de la Liberté, Paris", 55, "01/01/2024", 1);
        clients.addClientParticulier("De Gaulle", "Charles", "34 boulevard de l'Égalité, Lyon", 78, "02/02/2002", 2);
        clients.addClientParticulier("Sarkozy", "Nicolas", "56 avenue de la Fraternité, Marseille", 63, "03/03/2001", 3);
        clients.addClientParticulier("Pecresse", "Valerie", "78 rue de la République, Toulouse", 48, "04/04/2003", 4);
        clients.addClientParticulier("Pouton", "Philippe", "90 boulevard de la Nation, Nice", 68, "05/05/2005", 5);
        clients.addClientParticulier("Giscard d'Estaing", "Valerie", "123 avenue de la Paix, Nantes", 80, "06/06/2023", 6);
        clients.addClientParticulier("Attal", "Gabriel", "456 rue de la Justice, Strasbourg", 38, "07/07/2002", 7);
        clients.addClientParticulier("Le Pen", "Marine", "789 boulevard de la Démocratie, Montpellier", 50, "08/08/2006", 8);
        clients.addClientParticulier("Bardella", "Jordan", "321 avenue de la Liberté, Bordeaux", 47, "09/09/2014", 9);
        clients.addClientParticulier("Mitterand", "François", "654 rue de l'Égalité, Lille", 53, "10/10/2008", 10);

        // Clients particuliers non valides
        // Nom trop court
        clients.addClientParticulier("A", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Nom trop long
        clients.addClientParticulier("NomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNomNom", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Prenom trop court
        clients.addClientParticulier("Nom", "A", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Prenom trop long
        clients.addClientParticulier("Nom", "PrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenomPrenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", 1);
        // Adresse trop courte
        clients.addClientParticulier("Nom", "Prenom", "123", 24, "01/01/2000", 1);
        // Adresse trop longue
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, ParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParisParis", 24, "01/01/2000", 1);
        // Age trop bas
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, Paris", 16, "01/01/2000", 1);
        // Age trop haut
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, Paris", 82, "01/01/2000", 1);
        // Date au mauvais format
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "01-01-2000", 1);
        // Date avant la date de création de TOYAUDI
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "31/12/1999", 1);
        // Nombre de locations < 0
        clients.addClientParticulier("Nom", "Prenom", "123 rue de la Liberté, Paris", 24, "01/01/2000", -1);

        clients.afficherClients();
    }
}
