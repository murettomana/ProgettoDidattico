/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author massi
 */
import java.util.ArrayList;
import model.*;

/**
 *
 * @author berrettis
 */
public class Iscrizione {

    private String idAppello;
    private String matricolaStudente;

    public Iscrizione(String idAppello, String matricolaStudente) {
        this.idAppello = idAppello;
        this.matricolaStudente = matricolaStudente;
    }

    public String getIdAppello() {
        return idAppello;
    }

    public void setIdAppello(String idAppello) {
        this.idAppello = idAppello;
    }

    public String getMatricolaStudente() {
        return matricolaStudente;
    }

    public void setMatricolaStudente(String matricolaStudente) {
        this.matricolaStudente = matricolaStudente;
    }


    @Override
    public String toString() {
        return idAppello + ";" + matricolaStudente+"\n";
    }
}
