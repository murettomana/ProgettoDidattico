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
public class GestoreDiscipline {

    private GestoreApp gestore;
    private ArrayList<Disciplina> discipline;

    public GestoreDiscipline(ArrayList<Disciplina> discipline) {
        this.discipline = discipline;
    }

    public ArrayList<Disciplina> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(ArrayList<Disciplina> discipline) {
        this.discipline = discipline;
    }

    public void aggiungiDisciplina(Disciplina d, ArrayList<Disciplina> discipline) {
        discipline.add(d);
    }

    public void modificaDisciplina(Disciplina modificaDisciplina, ArrayList<Disciplina> discipline) {
        for (Disciplina d : discipline) {
            if (d.getCodice().equals(modificaDisciplina.getCodice())) {
                discipline.set(discipline.indexOf(d), modificaDisciplina);
                break;
            }
        }
    }

    public void eliminaDisciplina(Disciplina eliminaDisciplina, ArrayList<Disciplina> discipline) {
        for (Disciplina d : discipline) {
            if (d.getCodice().equals(eliminaDisciplina.getCodice())) {
                discipline.remove(eliminaDisciplina);
                break;
            }
        }
    }

    public void visualizzaDiscipline() {
        for (Disciplina d : discipline) {
            d.toString();
        }
    }
}
