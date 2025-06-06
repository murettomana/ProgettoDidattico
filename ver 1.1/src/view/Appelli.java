/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
import java.util.ArrayList;
import model.*;
import static view.Corsi.G;

/**
 *
 * @author berrettis
 */
public class Appelli extends javax.swing.JFrame {

    public static GestoreApp G = new GestoreApp();
    private ArrayList<AppelloEsame> appelli;

    /**
     * Creates new form Appelli
     */
    public Appelli(GestoreApp G) {
        this.G = G;
        this.appelli = G.getElencoAppelli();
        initComponents();
    }

    private void scriviFileCSV() {
        G.salvaCorsiFIle();
    }

    private void mostraNumeroAppelli() {
        int numeroAppelli = G.contaAppelli();
        jTextArea1.setText("Numero di Appelli: " + numeroAppelli);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aggiungi", "Modifica", "Elimina", "ContaAppelli" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Salva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel1.setText("Modifica Appelli");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 46));
        jLabel1.setMinimumSize(new java.awt.Dimension(47, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String ch = ";";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String input = jTextArea1.getText();

        if (jComboBox1.getSelectedItem().equals("Aggiungi")) {
            if (input.equals("")) {
                jTextArea1.setText("Parametro/i mancante/i");

                throw new IllegalArgumentException();
            } else {
                String[] data = input.split(ch);
                String idAppello = data[0];
                String dataAppello = data[1];
                String codiceDisciplina = data[2];

                String newLine = idAppello + "," + dataAppello + "," + codiceDisciplina;
                AppelloEsame nuovoAppello = new AppelloEsame(idAppello, dataAppello, codiceDisciplina);

                appelli.add(nuovoAppello);
                scriviFileCSV();

            }
        }
        if (jComboBox1.getSelectedItem().equals("Modifica")) {
            if (input.equals("")) {
                jTextArea1.setText("Parametro/i mancante/i");

                throw new IllegalArgumentException();
            } else {
                String[] data = input.split(",");

                if (data.length < 3) {
                    throw new IllegalArgumentException("I dati inseriti non sono validi.");
                }

                String idAppelloDaCercare = data[0];
                String nuovodataAppello = data[1];
                String nuovocodiceDisciplina = data[2];

                boolean trovato = false;

                // Cerca la appelli e modifica i suoi dati
                for (int i = 0; i < appelli.size(); i++) {
                    AppelloEsame appello = appelli.get(i);
                    if (appello.getIdAppello().equals(idAppelloDaCercare)) {
                        appello.setData(nuovodataAppello);
                        appello.setCodiceDisciplina(nuovocodiceDisciplina);
                        trovato = true;
                        break;
                    }
                }

                if (trovato) {
                    scriviFileCSV();
                } else {
                    throw new IllegalArgumentException("Discilina non trovato con id: " + idAppelloDaCercare);
                }
            }
        }

        if (jComboBox1.getSelectedItem().equals("Elimina")) {
            if (input.equals("")) {
                jTextArea1.setText("Parametro/i mancante/i");

                throw new IllegalArgumentException();
            } else {
                String codiceDaEliminare = input.trim();

                boolean trovato = false;

                // Usa il ciclo for per trovare e rimuovere il corso
                for (int i = 0; i < appelli.size(); i++) {
                    AppelloEsame appello = appelli.get(i);
                    if (appello.getIdAppello().equals(codiceDaEliminare)) {
                        appelli.remove(i);  // Rimuovi il corso
                        trovato = true;
                        break;  // Esci dal ciclo una volta che il corso è stato rimosso
                    }
                }

                if (trovato) {
                    scriviFileCSV();
                } else {
                    throw new IllegalArgumentException("Appello non trovato con id: " + codiceDaEliminare);
                }
            }
        }

        if ((jComboBox1.getSelectedItem().equals("ContaAppelli"))) {
            mostraNumeroAppelli();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Appelli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appelli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appelli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appelli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appelli(G).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
