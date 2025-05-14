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
public class GestoreDocenti {

    private ArrayList<Docente> docenti;

    public GestoreDocenti(ArrayList<Docente> docenti) {
        this.docenti = docenti;
    }

    public ArrayList<Docente> getDocenti() {
        return docenti;
    }

    public void setDocenti(ArrayList<Docente> docenti) {
        this.docenti = docenti;
    }

    public void aggiungiDocente(Docente d, ArrayList<Docente> docenti) {
        docenti.add(d);
    }

    public void modificaDocente(Docente modificaDocente, ArrayList<Docente> docenti) {
        for (Docente d : docenti) {
            if (d.getMatricola().equals(modificaDocente.getMatricola())) {
                docenti.set(docenti.indexOf(d), modificaDocente);
                break;
            }
        }
    }

    public void eliminaDocente(Docente eliminaDocente, ArrayList<Docente> docenti, ArrayList<Disciplina> discipline) {

        boolean haDisciplinaAssociata = false;

        for (Disciplina disciplina : discipline) {
            if (disciplina.getCodice().equals(eliminaDocente.getCodiceDisciplina())) {
                haDisciplinaAssociata = true;
                break;
            }
        }

        if (haDisciplinaAssociata) {
            System.out.println("Impossibile eliminare il docente!");
        } else {
            for (int i = 0; i < docenti.size(); i++) {
                Docente d = docenti.get(i);
                if (d.getMatricola().equals(eliminaDocente.getMatricola())) {
                    docenti.remove(i);
                    System.out.println("Docente eliminato con successo.");
                    break;
                }
            }
        }

    }

    public void visualizzaDocenti() {
        for (Docente d : docenti) {
            d.toString();
        }
    }

    public Integer contaDocentiCorso(CorsoUni c) {
        int conta = 0;
        for (Docente d : docenti) {

        }
        return conta;
    }
}
