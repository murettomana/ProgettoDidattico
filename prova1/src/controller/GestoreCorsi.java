/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import java.util.ArrayList;

/**
 *
 * @author massi
 */
public class GestoreCorsi {

    private ArrayList<CorsoUni> corsi;

    public GestoreCorsi(ArrayList<CorsoUni> corsi) {
        this.corsi = corsi;
    }

    public ArrayList<CorsoUni> getCorsi() {
        return corsi;
    }

    public void setCorsi(ArrayList<CorsoUni> corsi) {
        this.corsi = corsi;
    }

    // Metodo per aggiungere un nuovo corso
    public void aggiungiCorso(CorsoUni c) {
        corsi.add(c);
        System.out.println("Corso " + c.getCodice() + " aggiunto con successo.");

    }

    // Metodo per modificare un corso esistente
    public void modificaCorso(CorsoUni modificaCorso) {
        for (CorsoUni c : corsi) {
            if (c.getCodice().equals(modificaCorso.getCodice())) {
                corsi.set(corsi.indexOf(c), modificaCorso);
                break;
            }
        }
    }

    // Metodo per eliminare un corso
    public void eliminaCorso(CorsoUni corso) {
        boolean canRemove = true;

        if (corso.contaStudenti() > 0) {
            System.out.println("Non puoi eliminare il corso!(studenti iscritti)");
            canRemove = false;
        }

        for (Disciplina disciplina : corso.getDiscipline()) {
            if (disciplina.getDocenti().size() > 0) {
                System.out.println("Non puoi eliminare il corso!(docenti associati)");
                canRemove = false;
                break;
            }
        }
        for (Disciplina disciplina : corso.getDiscipline()) {
            if (disciplina.getAppelli().size() > 0) {
                System.out.println("Non puoi eliminare il corso!(appelli associati)");
                canRemove = false;
                break;
            }
        }

        if (canRemove) {
            corsi.remove(corso);
            System.out.println("Corso " + corso.getCodice() + " eliminato con successo.");
        }
    }

    public void visualizzaCorsi() {
        if (corsi.isEmpty()) {
            System.out.println("Nessun corso disponibile.");
        } else {
            for (CorsoUni c : corsi) {
                c.toString();
            }
        }

    }
}
