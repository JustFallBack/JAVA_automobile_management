package client;

/*
 * Ajoutez une classe Clients de type ArrayList (et non pas une classe contenant une ArrayList ...) permettant de sauvegarder des
 * clients particuliers ou professionnels avec une méthode affiche permettant l’affichage des clients.
 * On ne pourra crée qu’une seule instance de Clients.
 * Modifez le ou les constructeur(s) de manière à ajouter une nouvelle instance de client particulier ou professionnel à la liste de clients de Clients.
 */
import exceptions.GestionAutombileClientsProfessionnelsException;
import exceptions.GestionAutomobileClientsException;
import exceptions.GestionAutomobileClientsParticuliersException;

import java.util.ArrayList;

public class Clients extends ArrayList<Clients> {
    private static Clients instance;

    public static Clients getInstance() {
        if(instance == null){
            instance = new Clients();
        }
        return instance;
    }

    public void afficherClients() {
        for (Clients client : this) {
            System.out.println(client);
        }
    }

    // Cherche dans l'ArrayList de client si le clientObj passé un argument existe.
    public boolean clientExiste(Clients clientObj) {
        for (Clients client : this) {
            if (client.equals(clientObj)) {
                return true;
            }
        }
        return false;
    }

    public void addClientParticulier(String nom, String prenom, String adresse, int age, String date, int nbLocations) {
        try {
            ClientParticulier client = new ClientParticulier(nom, prenom, adresse, age, date, nbLocations);
            if(!clientExiste(client)) {
                this.add(client);
            }
            else {
                throw new GestionAutomobileClientsException("Ce client existe déjà :\n" + client);
            }
        } catch(GestionAutomobileClientsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addClientProfessionnel(String nom, String date, double tauxRemise) {
        try {
            ClientProfessionnel client = new ClientProfessionnel(nom, date, tauxRemise);
            if (!clientExiste(client)) {
                this.add(client);
            }
            else {
                throw new GestionAutomobileClientsException("Ce client existe déjà :\n" + client);
            }
        } catch(GestionAutomobileClientsException e) {
            System.out.println(e.getMessage());
        }
    }
}
