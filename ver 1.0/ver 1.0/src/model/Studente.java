/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author berrettis
 */
public class Studente extends Persona {

    private String codiceCorso;
    private ArrayList<AppelloEsame> appelli;

    public Studente(String matricola, String nome, String cognome, String codiceCorso) {
        super(matricola, nome, cognome);
        this.codiceCorso = codiceCorso;
        this.appelli = new ArrayList<>();  // Inizializzo la lista di appelli

    }

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public void setCodiceCorso(String codiceCorso) {
        this.codiceCorso = codiceCorso;
    }

    public ArrayList<AppelloEsame> getAppelli() {
        return appelli;
    }

    public boolean isIscrittoAppello(AppelloEsame appello) {
        return appelli.contains(appello);
    }

    public void rimuoviAppello(AppelloEsame appello) {
        appelli.remove(appello);
    }

    public void addAppello(AppelloEsame appello) {
        if (!appelli.contains(appello)) {
            appelli.add(appello);
        }
    }

}
