
package model;

import java.util.ArrayList;

public class Studente extends Persona {

    private String codiceCorso;
    private ArrayList<AppelloEsame> appelli;
    private ArrayList<Disciplina> discipline;

    public Studente( String matricola, String nome, String cognome,String codiceCorso, ArrayList<AppelloEsame> appelli, ArrayList<Disciplina> discipline) {
        super(matricola, nome, cognome);
        this.codiceCorso = codiceCorso;
        this.appelli = appelli;
        this.discipline = discipline;
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

    public ArrayList<Disciplina> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(ArrayList<Disciplina> discipline) {
        this.discipline = discipline;
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

    public void setAppelli(ArrayList<AppelloEsame> appelli) {
        this.appelli = appelli;
    }
    
    @Override
    public String toString(){
        return super.toString()+":"+codiceCorso+"\n";
    }

}
