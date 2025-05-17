package controller;

import model.AppelloEsame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.*;

public class GestoreApp {

    // === DICHIARAZIONI LISTE ===
    private ArrayList<CorsoUni> elencoCorsi = new ArrayList<>();
    private ArrayList<Disciplina> elencoDiscipline = new ArrayList<>();
    private ArrayList<Docente> elencoDocenti = new ArrayList<>();
    private ArrayList<Studente> elencoStudenti = new ArrayList<>();
    private ArrayList<AppelloEsame> elencoAppelli = new ArrayList<>();
    private ArrayList<IscrizioneAppello> elencoIscrizioni = new ArrayList<>();

    // === METODI DI LETTURA ===

    public boolean letturaCorsi(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String codice = data[0];
                String nome = data[1];
                int durata = Integer.parseInt(data[2].substring(1, 2));
                elencoCorsi.add(new CorsoUni(codice, nome, durata));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Errore lettura corsi: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean letturaDiscipline(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String codice = data[0];
                String nome = data[1];
                int cfu = Integer.parseInt(data[2].substring(1, 2));
                String codiceCorso = data[3];
                elencoDiscipline.add(new Disciplina(codice, nome, cfu, codiceCorso));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura discipline: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean letturaDocenti(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String matricola = data[0];
                String nome = data[1];
                String cognome = data[2];
                String codiceDisciplina = data[3];
                elencoDocenti.add(new Docente(matricola, nome, cognome, codiceDisciplina));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura docenti: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean letturaStudenti(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String matricola = data[0];
                String nome = data[1];
                String cognome = data[2];
                String codiceCorso = data[3];
                elencoStudenti.add(new Studente(matricola, nome, cognome, codiceCorso));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura studenti: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean letturaAppelli(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String idAppello = data[0];
                String dataAppello = data[1];
                String codiceDisciplina = data[2];
                elencoAppelli.add(new AppelloEsame(idAppello, dataAppello, codiceDisciplina));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura appelli: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean letturaIscrizioni(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] data = linea.split(ch);
                String idAppello = data[0];
                String matricolaStudente = data[1];
                elencoIscrizioni.add(new IscrizioneAppello(idAppello, matricolaStudente));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura iscrizioni: " + e.getMessage());
            return false;
        }
        return true;
    }

    // === METODI GETTER ===

    public ArrayList<CorsoUni> getElencoCorsi() {
        return elencoCorsi;
    }

    public ArrayList<Disciplina> getElencoDiscipline() {
        return elencoDiscipline;
    }

    public ArrayList<Docente> getElencoDocenti() {
        return elencoDocenti;
    }

    public ArrayList<Studente> getElencoStudenti() {
        return elencoStudenti;
    }

    public ArrayList<AppelloEsame> getElencoAppelli() {
        return elencoAppelli;
    }

    public ArrayList<IscrizioneAppello> getElencoIscrizioni() {
        return elencoIscrizioni;
    }
}
