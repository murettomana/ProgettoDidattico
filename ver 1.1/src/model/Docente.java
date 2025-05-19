
package model;

public class Docente extends Persona {

    private String codiceDisciplina;

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
    }
    
    @Override
    public String toString() {
        return super.toString()+":"+codiceDisciplina+"\n";
    }

}
