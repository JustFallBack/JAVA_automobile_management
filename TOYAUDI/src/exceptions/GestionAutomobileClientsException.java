package exceptions;

/*
 * exception qui sera levée si l’on essaie d’ajouter deux fois un même client dans la classe Clients (même nom, etc.).
 * Ajoutez à cette classe un constructeur avec une chaîne de caractères. Réécrire la méthode permettant l’ajout d’un client
 * (particulier ou professionnel) de façon à ce qu’elle lève GestionAutomobileClientsException : l’exception se construit en
 * faisant passer une chaîne indiquant l’identité du client particulier ou professionnel et un message soulignant que ce
 * client existe déjà dans la classe Clients.
 */

import client.Clients;

public class GestionAutomobileClientsException extends GestionAutomobileException {
    public GestionAutomobileClientsException(String s) {
        super(s);
    }
    public GestionAutomobileClientsException(String message, Clients client) {
        super(message + " Client : " + client.toString());
    }
}

