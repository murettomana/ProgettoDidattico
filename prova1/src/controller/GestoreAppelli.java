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
public class GestoreAppelli {

    private ArrayList<AppelloEsame> appelli;

    public GestoreAppelli(ArrayList<AppelloEsame> appelli) {
        this.appelli = appelli;
    }

    public ArrayList<AppelloEsame> getAppelli() {
        return appelli;
    }

    public void setAppelli(ArrayList<AppelloEsame> appelli) {
        this.appelli = appelli;
    }

    public void aggiungiAppello(AppelloEsame a, ArrayList<AppelloEsame> appelli) {
        appelli.add(a);
    }

    public void modificaAppello(AppelloEsame modificaAppello, ArrayList<AppelloEsame> appelli) {
        for (AppelloEsame a : appelli) {
            if (a.getIdAppello().equals(modificaAppello.getIdAppello())) {
                appelli.set(appelli.indexOf(a), modificaAppello);
                break;
            }
        }
    }

    public void eliminaAppello(AppelloEsame eliminaAppello, ArrayList<AppelloEsame> appelli) {
        for (AppelloEsame a : appelli) {
            if (a.getIdAppello().equals(eliminaAppello.getIdAppello())) {
                if (!a.getStudenti().isEmpty()) {
                    System.out.println("Non è possibile eliminare l'appello.");
                } else {
                    appelli.remove(a);
                    System.out.println("Appello eliminato.");
                }
                break;
            }
        }
    }

    public void visualizzaAppelli() {
        for (AppelloEsame a : appelli) {
            a.toString();
        }
    }

}
