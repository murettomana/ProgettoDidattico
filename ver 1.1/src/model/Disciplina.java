
package model;

import java.util.ArrayList;

public class Disciplina {

    private String codice;
    private String nome;
    private int CFU;
    private String codiceCorso;

    private ArrayList<Docente> docenti;
    private ArrayList<AppelloEsame> appelli;
    private ArrayList<Studente> studenti;

    public Disciplina(String codice, String nome, int CFU, String codiceCorso, ArrayList<Docente> docenti, ArrayList<AppelloEsame> appelli, ArrayList<Studente> studenti) {
        this.codice = codice;
        this.nome = nome;
        this.CFU = CFU;
        this.codiceCorso = codiceCorso;
        this.docenti = docenti;
        this.appelli = appelli;
        this.studenti = studenti;
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studenti = studenti;
    }

    public ArrayList<Docente> getDocenti() {
        return docenti;
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

    public void setAppelli(ArrayList<AppelloEsame> appelli) {
        this.appelli = appelli;
    }

    public void setDocenti(ArrayList<Docente> docenti) {
        this.docenti = docenti;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCFU() {
        return CFU;
    }

    public void setCFU(int CFU) {
        this.CFU = CFU;
    }

    void addDocente(Docente d) {
        docenti.add(d);
    }

    void addAppello(AppelloEsame a) {
        appelli.add(a);
    }

    public void addStudente(Studente s) {
        studenti.add(s);
    }

     @Override
    public String toString() {
        return codice + ";" + nome + ";" + CFU+"\n"; //stile csv
    }

}
