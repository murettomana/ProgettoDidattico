package controller;

import model.*;
import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {

        GestoreApp g = new GestoreApp();
        System.out.println("\n================= TEST CORSI =================");

        CorsoUni corso = new CorsoUni("CINF", "Informatica", 3);
        g.aggiungiCorso(corso);
        CorsoUni corso1 = new CorsoUni("CGEO", "Geografia", 3);
        g.aggiungiCorso(corso1);
        System.out.print(g.visualizzaCorsi());
        System.out.println("Conteggio: " + g.contaCorsi());

        CorsoUni corsoMod = new CorsoUni("CINF", "Informatica e AI", 3);
        g.modificaCorso(corsoMod);
        System.out.print(g.visualizzaCorsi());

        g.eliminaCorso(corsoMod);          // dovrà fallire se collegamenti presenti

        System.out.println("\n================= TEST DISCIPLINE =================");

        Disciplina d = new Disciplina("INF01", "Programmazione", 9, corso.getCodice(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        g.aggiungiDisciplina(d);
        System.out.print(g.visualizzaDiscipline());
        System.out.println("Conteggio: " + g.contaDiscipline());

        Disciplina dMod = new Disciplina("INF01", "Programmazione 1", 9, corso.getCodice(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        g.modificaDisciplina(dMod);
        System.out.print(g.visualizzaDiscipline());

        System.out.println("\n================= TEST DOCENTI =================");

        Docente doc = new Docente("D001", "Mario", "Rossi", d.getCodice());
        g.aggiungiDocente(doc);
        System.out.print(g.visualizzaDocenti());
        System.out.println("Conteggio: " + g.contaDocenti());

        Docente docMod = new Docente("D001", "Mario", "Verdi", d.getCodice());
        g.modificaDocente(docMod);
        System.out.print(g.visualizzaDocenti());

        g.eliminaDocente(docMod);          // bloccato perché ha disciplina associata

        System.out.println("\n================= TEST STUDENTI =================");

        Studente s = new Studente("S001", "Anna", "Bianchi",
                corso.getCodice(), new ArrayList<>(), new ArrayList<>());
        g.aggiungiStudente(s.getMatricola(), s.getNome(), s.getCognome(), s.getCodiceCorso());
        System.out.print(g.visualizzaStudenti());
        System.out.println("Conteggio: " + g.contaStudenti());

        Studente sMod = new Studente("S001", "Anna", "Neri",
                corso.getCodice(), new ArrayList<>(), new ArrayList<>());
        g.modificaStudente(sMod);
        System.out.print(g.visualizzaStudenti());

        g.eliminaStudente(sMod);
        System.out.println("Conteggio dopo eliminazione: " + g.contaStudenti());

        System.out.println("\n================= TEST APPELLI =================");

        AppelloEsame a = new AppelloEsame("A001", "2025-06-10", d.getCodice());
        g.aggiungiAppello(a);
        System.out.print(g.visualizzaAppelli());
        System.out.println("Conteggio: " + g.contaAppelli());

        AppelloEsame aMod = new AppelloEsame("A001", "2025-07-15", d.getCodice());
        g.modificaAppello(aMod);
        System.out.print(g.visualizzaAppelli());

        g.eliminaAppello(aMod);            // dovrebbe riuscire: nessuno studente iscritto
        System.out.println("Conteggio dopo eliminazione: " + g.contaAppelli());

        System.out.println("\n================= TEST ISCRIZIONI =================");

        // ricreo appello e studente per l'iscrizione
        g.aggiungiAppello(a);
        g.aggiungiStudente(s.getMatricola(), s.getNome(), s.getCognome(), s.getCodiceCorso());
        Iscrizione iscr = new Iscrizione(a.getIdAppello(), s.getMatricola());
        g.aggiungiIscrizione(iscr);
        System.out.print(g.visualizzaIscrizioni());
        System.out.println("Conteggio: " + g.contaIscrizioni());

        Iscrizione iscrMod = new Iscrizione(a.getIdAppello(), "S002"); // cambio matricola
        g.modificaIscrizione(iscrMod);
        System.out.print(g.visualizzaIscrizioni());

        g.eliminaIscrizione(iscrMod);
        System.out.println("Conteggio dopo eliminazione: " + g.contaIscrizioni());

        System.out.println("\n================= SALVATAGGIO CSV =================");
        g.salvaCorsiFIle();
        g.salvaDisciplineFIle();
        g.salvaDocentiFIle();
        g.salvaStudentiFIle();
        g.salvaAppelliFIle();
        g.salvaIscrizioniFIle();
        System.out.println("Tutti i CSV aggiornati.");
    }
}
