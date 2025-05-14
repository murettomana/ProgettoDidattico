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
public class CorsoUni {

    private String codice, nome;
    private int durata;
    private ArrayList<Studente> studenti;  // Lista degli studenti iscritti al corso
    private ArrayList<Disciplina> discipline;  // Lista degli studenti iscritti al corso

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

    // Aggiunge uno studente al corso
    public void addStudente(Studente s) {
        if (s != null && !studenti.contains(s)) {
            studenti.add(s);
        }
    }
       // Aggiunge una disciplina al corso
    public void addDisciplina(Disciplina d) {
        if (d != null && !discipline.contains(d)) {
            discipline.add(d);
        }
    }


    // Getter per la lista degli studenti
    public ArrayList<Studente> getStudenti() {
        return studenti;
    }
    // Getter per la lista delle discipline

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
        return codice + ";" + nome + ";" + durata; //stile csv
    }

}
