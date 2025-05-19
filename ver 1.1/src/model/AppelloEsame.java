
package model;

import java.util.ArrayList;

public class AppelloEsame {

    private String idAppello;
    private String data;
    private String codiceDisciplina;
    private ArrayList<Studente> studenti;
    private ArrayList<Iscrizione> iscrizioni;

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

    public void addIscrizione(Iscrizione iscrizione) {
        if (iscrizione != null) {
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
            studente.addAppello(this);
        }
    }

    public void removeStudente(Studente studente) {
        studenti.remove(studente);
        studente.rimuoviAppello(this);
    }

    private Studente CercaStudenteMatricola(String matricola) {
        for (Studente s : studenti) {
            if (s.getMatricola().equals(matricola)) {
                return s;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return idAppello + ";" + data + ";" + codiceDisciplina+"\n";
    }

}
