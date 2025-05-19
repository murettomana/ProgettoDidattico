
package model;

import java.util.ArrayList;

public class CorsoUni {

    private String codice, nome;
    private int durata;
    private ArrayList<Studente> studenti;
    private ArrayList<Disciplina> discipline;

    public CorsoUni(String codice, String nome, int durata) {
        this.codice = codice;
        this.nome = nome;
        this.durata = durata;
        this.studenti = new ArrayList<>();
        this.discipline = new ArrayList<>();
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

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    
    public void addStudente(Studente s) {
        if (s != null && !studenti.contains(s)) {
            studenti.add(s);
        }
    }
    
    public void addDisciplina(Disciplina d) {
        if (d != null && !discipline.contains(d)) {
            discipline.add(d);
        }
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }

    public ArrayList<Disciplina> getDiscipline() {
        return discipline;
    }

    public Integer contaStudenti() {
        return studenti.size();
    }

    public Integer contaDiscipline() {
        return discipline.size();
    }

    @Override
    public String toString() {
        return codice + ";" + nome + ";" + durata+"\n"; //stile csv
    }

}
