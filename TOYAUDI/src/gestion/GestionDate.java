package gestion;
/*
 * Les dates de locations seront gérées par une classe GestionDates
 * contenant un attribut date (String), un attribut final format (‘’dd/MM/yyyy’’)
 * et une instance de la classe SimpleDateFormat.
 */
import exceptions.GestionAutomobileClientsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionDate {
    private String date;
    private final String dateFormat = "dd/MM/yyyy";
    // Date qui empêche les dates d'être avant la date spécifiée (date de création de TOYAUDI).
    private final String dateCreationTOYAUDI = "01/01/2000";
    private final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

    public String getDate() {
        return this.date;
    }

    public GestionDate(String date) throws GestionAutomobileClientsException {
        try {
            Date dateObj = sdf.parse(date);
            if (dateObj.after(sdf.parse(this.dateCreationTOYAUDI))) {
                this.date = date;
            }
            else {
                throw new GestionAutomobileClientsException("La date doit être après le 01/01/2000.");
            }
        } catch (ParseException e) {
            throw new GestionAutomobileClientsException("La date n'est pas au bon format : 'dd/mm/yyyy'.");
        }
    }

    @Override
    public String toString() {
        try {
            Date dateD = sdf.parse(date);
            return dateD.toString();

        } catch (ParseException e) {
            System.out.println("Erreur de parsing : " + e.getMessage());
        }
        return null;
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
        GestionDate dateObj = (GestionDate) obj;
        return this.date.equals(dateObj.date);
    }

}
