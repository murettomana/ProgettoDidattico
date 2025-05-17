package controller;

import model.*;


public class NewMain {
    public static void main(String[] args) {

        GestoreApp gestore = new GestoreApp();

        // Lettura dei CSV
        boolean ok1 = gestore.letturaCorsi("corsi.csv");
        boolean ok2 = gestore.letturaDiscipline("discipline.csv");
        boolean ok3 = gestore.letturaDocenti("docenti.csv");
        boolean ok4 = gestore.letturaStudenti("studenti.csv");
        boolean ok5 = gestore.letturaAppelli("appelli.csv");
        boolean ok6 = gestore.letturaIscrizioni("iscrizioni_appelli.csv");

        if (ok1 && ok2 && ok3 && ok4 && ok5 && ok6) {
            System.out.println("Tutti i file sono stati letti correttamente.");
        } else {
            System.err.println("Errore nella lettura di uno o più file.");
        }

        // Stampa di controllo dei corsi letti
        System.out.println("Corsi caricati:");
        for (CorsoUni c : gestore.getElencoCorsi()) {
            System.out.println(" - " + c.getCodice() + " " + c.getNome() + " (" + c.getDurata() + " anni)");
        }

        
    }
}
