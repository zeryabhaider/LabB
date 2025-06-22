/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Finestra di conferma per operazioni completate con successo.
 * Mostra un messaggio per 3 secondi e si chiude automaticamente.
 *
 * Usata per notificare rapidamente l'utente senza richiedere interazione.
 *
 * @author lucav
 */
public class Operazione extends javax.swing.JFrame {

    /**
     * Costruttore della finestra Operazione.
     * Inizializza i componenti e imposta un timer che chiude automaticamente
     * la finestra dopo 3 secondi.
     */
    public Operazione() {
        initComponents();

        // Crea un timer che attende 2000 ms (3 secondi)
        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Chiude la finestra
            }
        });

        timer.setRepeats(false); // Imposta il timer per attivarsi solo una volta
        timer.start(); // Avvia il timer
    }

    /**
     * Metodo auto-generato dal Form Editor per inizializzare i componenti grafici.
     * NON modificare manualmente questo codice.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        // Configura la finestra principale
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THE KNIFE");

        // Imposta testo e stile dell'etichetta
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Operazione avvenuta con successo");

        // Layout della finestra
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        // Adatta le dimensioni e centra la finestra sullo schermo
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Dichiarazione delle variabili grafiche (non modificare manualmente)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
