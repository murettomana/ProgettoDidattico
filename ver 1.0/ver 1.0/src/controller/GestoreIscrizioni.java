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
public class GestoreIscrizioni {

    private ArrayList<IscrizioneAppello> iscrizioni;

    public GestoreIscrizioni(ArrayList<IscrizioneAppello> iscrizioni) {
        this.iscrizioni = iscrizioni;
    }

    public ArrayList<IscrizioneAppello> getIscrizioni() {
        return iscrizioni;
    }

    public void setIscrizioni(ArrayList<IscrizioneAppello> iscrizioni) {
        this.iscrizioni = iscrizioni;
    }

    public void aggiungiIscrizione(IscrizioneAppello a, ArrayList<IscrizioneAppello> iscrizioni) {
        iscrizioni.add(a);
    }

    public void modificaIscrizione(IscrizioneAppello modificaIscrizione, ArrayList<IscrizioneAppello> iscrizioni) {
        for (IscrizioneAppello a : iscrizioni) {
            if (a.getIdAppello().equals(modificaIscrizione.getIdAppello())) {
                iscrizioni.set(iscrizioni.indexOf(a), modificaIscrizione);
                break;
            }
        }
    }

    public void eliminaIscrizione(IscrizioneAppello eliminaIscrizione, ArrayList<IscrizioneAppello> iscrizioni) {
        for (IscrizioneAppello a : iscrizioni) {
            iscrizioni.set(iscrizioni.indexOf(a), eliminaIscrizione);
            iscrizioni.remove(eliminaIscrizione);
            break;
        }
    }

    public void visualizzaIscrizioni() {
        for (IscrizioneAppello a : iscrizioni) {
            a.toString();
        }
    }
}
