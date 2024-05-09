/*
* Les dates de locations seront gérées par une classe GestionDates contenant 
* un attribut date (String), un attribut final format (‘’dd/MM/yyyy’’) et 
* une instance de la classe SimpleDateFormat.
*/

package main.java.gestionnaire.models;
import java.text.SimpleDateFormat;

public class GestionDate {
    private String date;
    private final String format = "dd/MM/yyyy";
    private SimpleDateFormat simpleDate;

    public GestionDate(String date) {
        this.date = date;
        this.simpleDate = new SimpleDateFormat(format);
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GestionDate [date=" + date + "] simpleDate=" + simpleDate;
    }
}
