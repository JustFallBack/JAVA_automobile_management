package client;
import client.TypeClient;
import exceptions.GestionAutomobileClientsException;
import exceptions.GestionAutomobileClientsParticuliersException;
import gestion.GestionDate;

/*
 * Les clients seront soit des particuliers (classe ClientPartiuculier, attributs : nom, prénom, age, adresse,
 * un type (TypeClient), une date et un nombre de locations).
 */
public class ClientParticulier extends Clients {
    private String nom;
    private String prenom;
    private String adresse;
    private int age;
    private TypeClient type;
    private GestionDate date;
    private int nbLocations;

    public ClientParticulier(String nom, String prenom, String adresse, int age, String date, int nbLocations) throws GestionAutomobileClientsParticuliersException {
        if (age < 18 || age > 81) {
            throw new GestionAutomobileClientsParticuliersException("L'âge doit être compris entre 0 et 81 ans.");
        }
        if (nom.length() < 2 || nom.length() > 20 || prenom.length() < 2 || prenom.length() > 20) {
            throw new GestionAutomobileClientsParticuliersException("Le nom et prénom peuvent faire entre 2 et 20 caractères.");
        }
        if (adresse.length() < 5 || adresse.length() > 100) {
            throw new GestionAutomobileClientsParticuliersException("L'adresse doit faire entre 5 et 100 caractères.");
        }
        if (nbLocations < 0) {
            throw new GestionAutomobileClientsParticuliersException("Le nombre de locations ne peut pas être négatif.");
        }
        if (date == null) {
            throw new GestionAutomobileClientsParticuliersException("La date ne peut pas être null");
        }
        try {
            this.date = new GestionDate(date);
        } catch (GestionAutomobileClientsException e) {
            throw new GestionAutomobileClientsParticuliersException(e.getMessage());
        }
        this.type = TypeClient.PARTICULIER;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.nbLocations = nbLocations;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public int getAge() {
        return age;
    }
    public int getNbLocations() {
        return nbLocations;
    }
    public String getDate() {
        return date.toString();
    }
    public TypeClient getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Nom : " + this.getNom() +
                "\nPrenom : " + this.getPrenom() +
                "\nAdresse : " +  this.getAdresse() +
                "\nAge : " + this.getAge() +
                "\nNombre de locations : " + this.getNbLocations() +
                "\nDate : " + this.getDate() +
                "\nType : " + this.getType() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        // Comparaison des adresses mémoires
        if (this == obj) {
            return true;
        }
        // Si l'objet de la comparaison est null, renvoie false
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // On caste obj en ClientParticulier pour pouvoir comparer tous les attributs entre eux
        ClientParticulier client = (ClientParticulier) obj;
        return this.nom.equals(client.nom) &&
                this.prenom.equals(client.prenom) &&
                this.adresse.equals(client.adresse) &&
                this.age == client.age &&
                this.type == client.type &&
                this.date.equals(client.date) &&
                this.nbLocations == client.nbLocations;
    }
}
