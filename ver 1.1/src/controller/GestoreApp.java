package controller;

import model.AppelloEsame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.*;

public class GestoreApp {

    private ArrayList<CorsoUni> elencoCorsi = new ArrayList<>();
    private ArrayList<Disciplina> elencoDiscipline = new ArrayList<>();
    private ArrayList<Docente> elencoDocenti = new ArrayList<>();
    private ArrayList<Studente> elencoStudenti = new ArrayList<>();
    private ArrayList<AppelloEsame> elencoAppelli = new ArrayList<>();
    private ArrayList<Iscrizione> elencoIscrizioni = new ArrayList<>();

    public boolean letturaCorsi(String fn) {
        String linea;
        String ch = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fn)))) {
            br.readLine(); // Salta intestazione
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] data = linea.split(ch);
                String codice = data[0];
                String nome = data[1];
                int durata = Integer.parseInt(data[2]);
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
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] data = linea.split(ch);
                String codice = data[0];
                String nome = data[1];
                int cfu = Integer.parseInt(data[2].substring(1, 2));
                String codiceCorso = data[3];
                elencoDiscipline.add(new Disciplina(codice, nome, cfu, codiceCorso, elencoDocenti, elencoAppelli, elencoStudenti));
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
                if (linea.trim().isEmpty()) {
                    continue;
                }
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
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] data = linea.split(ch);
                String matricola = data[0];
                String nome = data[1];
                String cognome = data[2];
                String codiceCorso = data[3];
                elencoStudenti.add(new Studente(matricola, nome, cognome, codiceCorso, elencoAppelli, elencoDiscipline));
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
                if (linea.trim().isEmpty()) {
                    continue;
                }
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
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] data = linea.split(ch);
                String idAppello = data[0];
                String matricolaStudente = data[1];
                elencoIscrizioni.add(new Iscrizione(idAppello, matricolaStudente));
            }
        } catch (Exception e) {
            System.err.println("Errore lettura iscrizioni: " + e.getMessage());
            return false;
        }
        return true;
    }

    public void salvaCorsiFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("corsi.csv"))) {
            for (CorsoUni corso : elencoCorsi) {
                writer.write(corso.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }
    
    public void salvaAppelliFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appelli.csv"))) {
            for (AppelloEsame a : elencoAppelli) {
                writer.write(a.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }
    
    public void salvaDisciplineFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("discipline.csv"))) {
            for (Disciplina d : elencoDiscipline) {
                writer.write(d.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }
    
    public void salvaDocentiFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("docenti.csv"))) {
            for (Docente d : elencoDocenti) {
                writer.write(d.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }
    
    public void salvaStudentiFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("studenti.csv"))) {
            for (Studente s : elencoStudenti) {
                writer.write(s.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }
    
    public void salvaIscrizioniFIle() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("iscrizioni.csv"))) {
            for (Iscrizione i : elencoIscrizioni) {
                writer.write(i.toString());
                writer.newLine();

            }
        } catch (IOException e) {
        }
    }

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

    public ArrayList<Iscrizione> getElencoIscrizioni() {
        return elencoIscrizioni;
    }

    public void aggiungiCorso(CorsoUni c) {
        elencoCorsi.add(c);
        System.out.println("Corso " + c.getCodice() + " aggiunto con successo.");

    }

    public void modificaCorso(CorsoUni modificaCorso) {
        for (CorsoUni c : elencoCorsi) {
            if (c.getCodice().equals(modificaCorso.getCodice())) {
                elencoCorsi.set(elencoCorsi.indexOf(c), modificaCorso);
                break;
            }
        }
    }

    public void eliminaCorso(CorsoUni corso) {
        boolean canRemove = true;

        if (corso.contaStudenti() > 0) {
            System.out.println("Non puoi eliminare il corso!(studenti iscritti)");
            canRemove = false;
        }

        for (Disciplina disciplina : corso.getDiscipline()) {
            if (!disciplina.getDocenti().isEmpty()) {
                System.out.println("Non puoi eliminare il corso!(docenti associati)");
                canRemove = false;
                break;
            }
        }
        for (Disciplina disciplina : corso.getDiscipline()) {
            if (!disciplina.getAppelli().isEmpty()) {
                System.out.println("Non puoi eliminare il corso!(appelli associati)");
                canRemove = false;
                break;
            }
        }

        if (canRemove) {
            elencoCorsi.remove(corso);
            System.out.println("Corso " + corso.getCodice() + " eliminato con successo.");
        }
    }

    public String visualizzaCorsi() {
        String v = "";

        if (elencoCorsi.isEmpty()) {
            System.out.println("Nessun corso disponibile.");
            return "";
        } else {

        }
        for (CorsoUni c : elencoCorsi) {
            v += c.toString();
        }
        return v;

    }

    public Integer contaCorsi() {
        return elencoCorsi.size();
    }

    public void aggiungiAppello(AppelloEsame a) {
        elencoAppelli.add(a);
    }

    public void modificaAppello(AppelloEsame modificaAppello) {
        for (AppelloEsame a : elencoAppelli) {
            if (a.getIdAppello().equals(modificaAppello.getIdAppello())) {
                elencoAppelli.set(elencoAppelli.indexOf(a), modificaAppello);
                break;
            }
        }
    }

    public void eliminaAppello(AppelloEsame eliminaAppello) {
        for (AppelloEsame a : elencoAppelli) {
            if (a.getIdAppello().equals(eliminaAppello.getIdAppello())) {
                if (!a.getStudenti().isEmpty()) {
                    System.out.println("Non è possibile eliminare l'appello.");
                } else {
                    elencoAppelli.remove(a);
                    System.out.println("Appello eliminato.");
                }
                break;
            }
        }
    }

    public String visualizzaAppelli() {
        String v = "";

        if (elencoAppelli.isEmpty()) {
            System.out.println("Nessun Appello disponibile.");
            return "";
        } else {

        }
        for (AppelloEsame c : elencoAppelli) {
            v += c.toString();
        }
        return v;

    }

    public Integer contaAppelli() {
        return elencoAppelli.size();
    }

    public void aggiungiDocente(Docente d) {
        elencoDocenti.add(d);
    }

    public void modificaDocente(Docente modificaDocente) {
        for (Docente d : elencoDocenti) {
            if (d.getMatricola().equals(modificaDocente.getMatricola())) {
                elencoDocenti.set(elencoDocenti.indexOf(d), modificaDocente);
                break;
            }
        }
    }

    public void eliminaDocente(Docente eliminaDocente) {

        boolean haDisciplinaAssociata = false;

        for (Disciplina disciplina : elencoDiscipline) {
            if (disciplina.getCodice().equals(eliminaDocente.getCodiceDisciplina())) {
                haDisciplinaAssociata = true;
                break;
            }
        }

        if (haDisciplinaAssociata) {
            System.out.println("Impossibile eliminare il docente!");
        } else {
            for (int i = 0; i < elencoDocenti.size(); i++) {
                Docente d = elencoDocenti.get(i);
                if (d.getMatricola().equals(eliminaDocente.getMatricola())) {
                    elencoDocenti.remove(i);
                    System.out.println("Docente eliminato con successo.");
                    break;
                }
            }
        }

    }

    public String visualizzaDocenti() {
        String v = "";

        if (elencoDocenti.isEmpty()) {
            System.out.println("Nessun Docente disponibile.");
            return "";
        } else {

        }
        for (Docente c : elencoDocenti) {
            v += c.toString();
        }
        return v;

    }

    public Integer contaDocenti() {
        return elencoDocenti.size();
    }

    public void aggiungiStudente(String matricola, String nome, String cognome, String codiceCorso) {
        Studente s = new Studente(matricola, nome, cognome, codiceCorso, elencoAppelli, elencoDiscipline);
        elencoStudenti.add(s);
    }

    public void modificaStudente(Studente modificaStudente) {
        for (Studente s : elencoStudenti) {
            if (s.getMatricola().equals(modificaStudente.getMatricola())) {
                elencoStudenti.set(elencoStudenti.indexOf(s), modificaStudente);
                break;
            }
        }
    }

    public void eliminaStudente(Studente eliminaStudente) {
        for (Studente s : elencoStudenti) {
            if (s.getMatricola().equals(eliminaStudente.getMatricola())) {
                elencoStudenti.remove(eliminaStudente);
                break;
            }
        }
    }

    public String visualizzaStudenti() {
        String v = "";

        if (elencoStudenti.isEmpty()) {
            System.out.println("Nessun Studente disponibile.");
            return "";
        } else {

        }
        for (Studente c : elencoStudenti) {
            v += c.toString();
        }
        return v;
    }

    public Integer contaStudenti() {
        return elencoStudenti.size();
    }

    public void aggiungiIscrizione(Iscrizione a) {
        elencoIscrizioni.add(a);
    }

    public void modificaIscrizione(Iscrizione modificaIscrizione) {
        for (Iscrizione a : elencoIscrizioni) {
            if (a.getIdAppello().equals(modificaIscrizione.getIdAppello())) {
                elencoIscrizioni.set(elencoIscrizioni.indexOf(a), modificaIscrizione);
                break;
            }
        }
    }

    public void eliminaIscrizione(Iscrizione eliminaIscrizione) {
        for (Iscrizione a : elencoIscrizioni) {
            elencoIscrizioni.set(elencoIscrizioni.indexOf(a), eliminaIscrizione);
            elencoIscrizioni.remove(eliminaIscrizione);
            break;
        }
    }

    public String visualizzaIscrizioni() {
        String v = "";

        if (elencoIscrizioni.isEmpty()) {
            System.out.println("Nessun Iscrizione disponibile.");
            return "";
        } else {

        }
        for (Iscrizione c : elencoIscrizioni) {
            v += c.toString();
        }
        return v;

    }

    public Integer contaIscrizioni() {
        return elencoIscrizioni.size();
    }

    //Gestione Discipline
    public void aggiungiDisciplina(Disciplina d) {
        elencoDiscipline.add(d);
    }

    public void modificaDisciplina(Disciplina modificaDisciplina) {
        for (Disciplina d : elencoDiscipline) {
            if (d.getCodice().equals(modificaDisciplina.getCodice())) {
                elencoDiscipline.set(elencoDiscipline.indexOf(d), modificaDisciplina);
                break;
            }
        }
    }

    public void eliminaDisciplina(Disciplina eliminaDisciplina) {
        for (Disciplina d : elencoDiscipline) {
            if (d.getCodice().equals(eliminaDisciplina.getCodice())) {
                elencoDiscipline.remove(eliminaDisciplina);
                break;
            }
        }
    }

    public String visualizzaDiscipline() {
        String v = "";

        if (elencoDiscipline.isEmpty()) {
            System.out.println("Nessun Iscrizione disponibile.");
            return "";
        } else {

        }
        for (Disciplina c : elencoDiscipline) {
            v += c.toString();
        }
        return v;

    }

    public Integer contaDiscipline() {
        return elencoDiscipline.size();
    }

}
