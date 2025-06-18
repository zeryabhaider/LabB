/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

/**
 * Classe Scrivi che rappresenta una finestra GUI per scrivere un commento
 * o una risposta ad una recensione.
 * Se id = 0 si inserisce un nuovo commento con valutazione stelle,
 * altrimenti si risponde ad una recensione esistente con l'id fornito.
 *
 * @author lucav
 */
public class Scrivi extends javax.swing.JFrame {

    int id; // id della recensione, 0 indica nuovo commento

    /**
     * Costruttore della finestra Scrivi.
     * Imposta la visibilità della JComboBox per la selezione stelle
     * in base al valore di id.
     *
     * @param id id della recensione a cui rispondere, 0 per nuovo commento
     */
    public Scrivi(int id) {
        initComponents();
        this.id = id;
        if(id == 0){
            jComboBox1.setVisible(true); // Mostra selettore stelle per nuovo commento
        } else {
            jComboBox1.setVisible(false); // Nasconde selettore stelle per risposta
        }
    }

    /**
     * Metodo generato automaticamente per inizializzare i componenti grafici della finestra.
     * Non modificare questo codice manualmente in quanto rigenerato dal Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THE KNIFE");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Invia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "✭", "✭✭", "✭✭✭", "✭✭✭✭", "✭✭✭✭✭" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento associato al click del bottone "Invia".
     * Se id = 0 inserisce un nuovo commento con stelle, testo e data nel database.
     * Altrimenti verifica se esiste una risposta, se no la inserisce.
     * Mostra messaggi di conferma o errore e chiude la finestra dopo 1 secondo.
     *
     * @param evt evento click bottone
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        String testo = jTextArea1.getText();

        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            ResultSet rs = null;
            Statement stmt = conn.createStatement();

            if(id == 0){
                // Inserimento nuovo commento
                LocalDate oggi = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataFormattata = oggi.format(formatter);

                String sql = "INSERT INTO recensioni (email_utente,id_ristorante,stelle,testo,data) VALUES ('"
                        + TheKnifeHome.utente + "','" + VisualizzaRistorante.id_rist + "','" + jComboBox1.getSelectedItem() + "','"
                        + testo + "','" + dataFormattata + "')";
                try {
                    int rowsInserted = stmt.executeUpdate(sql);
                    new Operazione().setVisible(true);
                } catch (SQLException e) {
                    new Errore("Errore durante la creazione del commento:").setVisible(true);
                }

            } else {
                // Inserimento risposta ad una recensione esistente
                String sql = "SELECT risposta FROM recensioni WHERE id='" + id + "'";
                try {
                    rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        if (rs.getString("risposta") == null) {
                            sql = "UPDATE recensioni SET risposta = '" + testo + "' WHERE id ='" + id + "'";
                            try {
                                int rowsInserted = stmt.executeUpdate(sql);
                                new Operazione().setVisible(true);
                            } catch (SQLException e) {
                                new Errore("Errore durante la creazione della risposta:").setVisible(true);
                            }
                        } else {
                            new Errore("Esiste già una risposta a questo commento:").setVisible(true);
                        }
                    }
                } catch (SQLException e) {
                    new Errore("<html>Errore durante la ricerca del commento:<br>\"" + e.getMessage() + "\"</html>").setVisible(true);
                }
            }
            conn.close();

        } catch (SQLException e) {
            new Errore("<html>Errore durante la connessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }

        // Timer che chiude la finestra dopo 1 secondo dall'invio
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Chiude questa finestra
            }
        });
        timer.setRepeats(false); // Si attiva una sola volta
        timer.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Evento vuoto associato alla selezione della JComboBox (valutazione stelle).
     * @param evt evento selezione combo box
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Dichiarazione variabili di classe generate automaticamente
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
