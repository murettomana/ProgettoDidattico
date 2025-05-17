/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.IscrizioneAppello;
import java.util.ArrayList;

/**
 *
 * @author berrettis
 */
public class AppelloEsame {

    private String idAppello;
    private String data;
    private String codiceDisciplina;
    private ArrayList<Studente> studenti;
    private ArrayList<IscrizioneAppello> iscrizioni;

    public AppelloEsame(String idAppello, String data, String codiceDisciplina) {
        this.idAppello = idAppello;
        this.data = data;
        this.codiceDisciplina = codiceDisciplina;
        this.studenti = new ArrayList<>();
        this.iscrizioni = new ArrayList<>();
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }

    public String getIdAppello() {
        return idAppello;
    }

    public void setIdAppello(String idAppello) {
        this.idAppello = idAppello;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCodiceDisciplina() {
        return codiceDisciplina;
    }

    public void setCodiceDisciplina(String codiceDisciplina) {
        this.codiceDisciplina = codiceDisciplina;
    }

    public void addIscrizione(IscrizioneAppello iscrizione) {
        if (iscrizione != null) {
            // Find the Studente by matricola and add to studenti list
            Studente studente = CercaStudenteMatricola(iscrizione.getMatricolaStudente());
            if (studente != null && !studenti.contains(studente)) {
                studenti.add(studente);
                iscrizioni.add(iscrizione);
            }
        }
    }

    public void addStudente(Studente studente) {
        if (!studenti.contains(studente)) {
            studenti.add(studente);
            studente.addAppello(this); // Aggiungi l'appello alla lista dello studente
        }
    }

    public void removeStudente(Studente studente) {
        studenti.remove(studente);
        studente.rimuoviAppello(this); // Rimuovi l'appello dalla lista dello studente
    }

    private Studente CercaStudenteMatricola(String matricola) {
        for (Studente s : studenti) {
            if (s.getMatricola().equals(matricola)) {
                return s;
            }
        }
        return null;
    }
}
