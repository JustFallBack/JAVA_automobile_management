package test;

import client.Clients;

public class TestClientsProfessionnels {
    public static void main(String[] args) {
        Clients clients = Clients.getInstance();

        // Clients valides
        clients.addClientProfessionnel("M&M's","05/04/2013",0.023);
        clients.addClientProfessionnel("Elysee", "01/01/2001", 0.01);
        clients.addClientProfessionnel("Big du BigDeal", "04/01/2000", 0.8);

        System.out.println();

        // Clients non valides
        // Nom trop court
        clients.addClientProfessionnel("","05/04/2013",0.1);
        // Le client existe déjà
        clients.addClientProfessionnel("M&M's","05/04/2013",0.023);
        // Le taux n'est pas dans la plage
        clients.addClientProfessionnel("M&M's","05/04/2013",28);
        // La date n'est pas au bon format
        clients.addClientProfessionnel("M&M's","05/04/",0.023);
        // La date est antérieure à la date de création de TOYAUDI.
        clients.addClientProfessionnel("Mmmmmmm", "05/04/1999", 0.8);
        // Le nom du client est trop grand
        clients.addClientProfessionnel("UnNomTrèsLongQuiNeVaPasEtreAccepté:p", "05/05/2005", 0.002);

        clients.afficherClients();
    }
}
