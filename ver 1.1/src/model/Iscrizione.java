
package model;

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
