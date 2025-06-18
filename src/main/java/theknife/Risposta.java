/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import theknife.Errore;
import theknife.Operazione;
import theknife.TheKnifeHome;
import theknife.VisualizzaRistorante;

/**
 * Classe Risposta che rappresenta una finestra GUI che mostra la risposta
 * ad una recensione presa dal database in base all'id fornito.
 *
 * @author lucav
 */
public class Risposta extends javax.swing.JFrame {

    /**
     * Costruttore della classe Risposta.
     * Inizializza la GUI e recupera dal database la risposta associata
     * all'id passato come parametro, mostrando il risultato nella JLabel.
     *
     * @param id id della recensione di cui mostrare la risposta
     */
    public Risposta(int id) {
        initComponents(); // inizializza i componenti grafici

        // Dati per la connessione al database PostgreSQL locale
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";

        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");

            Statement stmt = conn.createStatement();

            // Query per selezionare la risposta dalla tabella recensioni in base all'id
            String sql = "SELECT risposta FROM recensioni WHERE id='" + id + "'";

            try {
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    // Se esiste una risposta la mostra, altrimenti mostra messaggio di assenza risposta
                    if (rs.getString("risposta") != null) {
                        jLabel1.setText(rs.getString("risposta"));
                    } else {
                        jLabel1.setText("non esiste ancora una risposta per questo commento");
                    }
                }
            } catch (SQLException e) {
                // Gestione errore in caso di problemi con la query
                new Errore("<html>Errore durante la ricerca della risposta:<br>\"" + e.getMessage() + "\"</html>").setVisible(true);
            }

            // Chiusura della connessione al database
            conn.close();
        } catch (SQLException e) {
            // Gestione errore in caso di problemi con la connessione al database
            new Errore("<html>Errore durante la connessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }
    }

    /**
     * Metodo generato automaticamente per inizializzare i componenti grafici della finestra.
     * Non modificare questo codice manualmente in quanto rigenerato dal Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THE KNIFE");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Dichiarazione variabili di classe generate automaticamente
    // Variabili declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
