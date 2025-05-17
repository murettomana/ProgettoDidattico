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
public class Disciplina {

    private String codice;
    private String nome;
    private int CFU;
    private String codiceCorso;

    private ArrayList<Docente> docenti;
    private ArrayList<AppelloEsame> appelli;

    public Disciplina(String codice, String nome, int CFU,  String codiceCorso) {
        this.codice = codice;
        this.nome = nome;
        this.CFU = CFU;
        this.codiceCorso = codiceCorso;
        this.docenti = new ArrayList<>();
        this.appelli = new ArrayList<>();

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

    @Override
    public String toString() {
        return codice + ";" + nome + ";" + CFU; //stile csv
    }

    void addDocente(Docente d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void addAppello(AppelloEsame a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
