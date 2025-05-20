/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author berrettis
 */
public class Docente extends Persona {

    private String codiceDisciplina;
    private Disciplina d;

    public Docente(String matricola, String nome, String cognome, String codiceDisciplina) {
        super(matricola, nome, cognome);
        this.codiceDisciplina = codiceDisciplina;

    }

    public String getCodiceDisciplina() {
        return codiceDisciplina;
    }
    

    public void setCodiceDisciplina(String codiceDisciplina) {
        this.codiceDisciplina = codiceDisciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.d = disciplina;
    }
    
    @Override
    public String toString() {
        return super.toString()+":"+codiceDisciplina+"\n"; //stile csv
    }

}
