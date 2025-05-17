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
public class GestoreStudenti {

    private ArrayList<Studente> studenti;

    public GestoreStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }

    public void aggiungiStudente(Studente s, ArrayList<Studente> studenti) {
        studenti.add(s);
    }

    public void modificaStudente(Studente modificaStudente, ArrayList<Studente> studenti) {
        for (Studente s : studenti) {
            if (s.getMatricola().equals(modificaStudente.getMatricola())) {
                studenti.set(studenti.indexOf(s), modificaStudente);
                break;
            }
        }
    }

    public void eliminaStudente(Studente eliminaStudente, ArrayList<Studente> studenti) {
        for (Studente s : studenti) {
            if (s.getMatricola().equals(eliminaStudente.getMatricola())) {
                studenti.remove(eliminaStudente);
                break;
            }
        }
    }

    public void visualizzaStudenti() {
        for (Studente s : studenti) {
            s.toString();
        }
    }

   /* public Integer contaStudentiCorso(CorsoUni c) {
        int conta = 0;
        for (Studente s : studenti) {
           
        
            
        }
        return conta;
    }*/
}
