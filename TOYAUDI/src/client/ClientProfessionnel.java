package client;
/*
 * ou professionnel (ClientProfessionnel, attributs : nom, type, date de location et le taux de remise appliqué aux clients professionnels).
 * Ajoutez les constructeurs, etc. et autres méthodes vous paraissant nécessaires maintenant ou durant le projet.
 */

import exceptions.GestionAutombileClientsProfessionnelsException;
import exceptions.GestionAutomobileClientsException;
import gestion.GestionDate;

public class ClientProfessionnel extends Clients{
    private String nom;
    private TypeClient type;
    private GestionDate dateLocation;
    private double tauxRemise;

    public ClientProfessionnel(String nom, String dateLocation, double tauxRemise) throws GestionAutombileClientsProfessionnelsException {
        if (nom.length() < 2 || nom.length() > 20) {
            throw new GestionAutombileClientsProfessionnelsException("Le nom du client professionel doit être compris entre 2 et 20 caractères.");
        }
        if (dateLocation == null) {
            throw new GestionAutombileClientsProfessionnelsException("La date ne peut pas être null");
        }
        if (tauxRemise < 0.0 || tauxRemise > 1.0) {
            throw new GestionAutombileClientsProfessionnelsException("Le taux de remise doit être compris entre 0.0 et 1.0.");
        }
        try {
            this.dateLocation = new GestionDate(dateLocation);
        } catch (GestionAutomobileClientsException e) {
            throw new GestionAutombileClientsProfessionnelsException(e.getMessage());
        }
        this.nom = nom;
        this.type = TypeClient.PROFESSIONEL;
        this.tauxRemise = tauxRemise;
    }

    public String getNom() {
        return this.nom;
    }
    public TypeClient getType() {
        return this.type;
    }
    public String getDateLocation() {
        return this.dateLocation.toString();
    }
    public double getTauxRemise() {
        return this.tauxRemise;
    }

    @Override
    public String toString() {
        return "Nom : " + this.getNom() +
                "\nType : " + this.getType() +
                "\nDate de location : " + this.getDateLocation() +
                "\nTaux de remise : " + this.getTauxRemise() + "\n";
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
        // On caste obj en ClientProfessionnel pour pouvoir comparer tous les attributs entre eux
        ClientProfessionnel client = (ClientProfessionnel) obj;
        return this.nom.equals(client.nom) &&
                this.type.equals(client.type) &&
                this.dateLocation.equals(client.dateLocation) &&
                Double.compare(this.tauxRemise, client.tauxRemise) == 0;
    }
}
