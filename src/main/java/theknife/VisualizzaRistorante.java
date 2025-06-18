/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;

/**
 * Classe VisualizzaRistorante - Estensione di JFrame che visualizza le informazioni
 * di un ristorante e le relative recensioni.
 * Permette a un cliente di lasciare commenti o aggiungere il ristorante ai preferiti.
 *
 * Autore: lucav
 */
public class VisualizzaRistorante extends javax.swing.JFrame {
    /** ID del ristorante visualizzato, utilizzato per operazioni future (es. preferiti, recensioni) */
    public static int id_rist;

    /**
     * Costruttore del frame VisualizzaRistorante.
     * Visualizza i dettagli di un ristorante, incluse coordinate e recensioni.
     *
     * @param id    Id del ristorante
     * @param nome  Nome del ristorante
     * @param lati  Latitudine
     * @param longi Longitudine
     */
    public VisualizzaRistorante(int id,String nome,String lati,String longi) {
        initComponents();
        if(TheKnifeHome.ruolo != null && TheKnifeHome.ruolo.equals("cliente")){
            MostraBottone();// Mostra le opzioni "preferiti" e "commento" solo ai clienti
        }else{
            NascondiBottone();// Nasconde i pulsanti se non è un cliente
        }
        id_rist=id;
        VisRist(nome,lati,longi);// Chiama metodo che carica i dati del ristorante
    }
    /**
     * Metodo che si occupa di interrogare il database e popolare l'interfaccia con
     * i dati del ristorante e delle sue recensioni.
     *
     * @param nome  Nome del ristorante
     * @param lati  Latitudine
     * @param longi Longitudine
     */
    public void VisRist(String nome,String lati,String longi){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM ristoranti WHERE id ="+id_rist+"";
            ResultSet rs=stmt.executeQuery(sql);

            // Popolamento etichette con i dati del ristorante
            if(rs.next()){
                jLabel12.setText(nome);
                jLabel13.setText(rs.getString("indirizzo"));
                jLabel14.setText(rs.getString("citta"));
                jLabel15.setText(rs.getString("stelle"));
                jLabel16.setText(lati);
                jLabel17.setText(longi);
                jLabel18.setText(rs.getString("n_tell"));
                jLabel19.setText(rs.getString("cucina"));
                if(rs.getBoolean("delivery")){
                    jLabel20.setText("Disponibile");
                }else{
                    jLabel20.setText("Non Disponibile");
                }
                if(rs.getBoolean("prenotazioni")){
                    jLabel21.setText("Disponibile");
                }else{
                    jLabel21.setText("Non Disponibile");
                }
                jLabel22.setText(rs.getString("fascia"));
                String email= rs.getString("email_u");
                id_rist=rs.getInt("id");

                // Recupera recensioni ordinate per stelle
                sql="SELECT * FROM recensioni WHERE id_ristorante='"+id_rist+"'ORDER BY stelle";
                rs=stmt.executeQuery(sql);
                while(rs.next()){
                    int id = rs.getInt("id");
                    System.out.println(rs.getString("testo"));

                    // Crea pulsante recensione per ogni riga
                    JButton button = new JButton();
                    button.setText(rs.getString("stelle")+":  "+rs.getString("testo"));
                    button.addActionListener((ActionEvent e) -> {
                        if(TheKnifeHome.utente!= null){
                            // Se l'autore è lo stesso, consente l'aggiunta di una risposta (Scrivi); altrimenti mostra la risposta (Risposta), se esiste
                            if(TheKnifeHome.utente.equals(email)){
                                new Scrivi(id).setVisible(true);
                            }else{
                                new Risposta(id).setVisible(true);
                            }
                        }
                        
                    });
                    jPanel1.add(button);
                }
                jPanel1.revalidate();// Aggiorna layout del pannello
            }
            jPanel1.revalidate();
        }catch(SQLException e) {
            new Errore("Errore durante la connessione: " + e.getMessage()).setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THE KNIFE");

        jLabel1.setText("Nome:");

        jLabel2.setText("Indirizzo:");

        jLabel3.setText("Città:");

        jLabel4.setText("Stelle:");

        jLabel5.setText("Latitudine:");

        jLabel6.setText("Longitudine:");

        jLabel7.setText("Numero di telefono:");

        jLabel8.setText("Tipo di cucina:");

        jLabel9.setText("Delivery:");

        jLabel10.setText("Prenotazioni:");

        jLabel11.setText("Fascia di prezzo:");

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel1);

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jMenu1.setText("Menù");

        jMenuItem1.setText("Aggiungi ai preferiti");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Lascia commento");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel22))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo invocato dal menu per scrivere una nuova recensione (ID 0 = nuova).
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int id=0;
        new Scrivi(id).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Metodo invocato dal menu per aggiungere il ristorante ai preferiti dell’utente.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            Statement stmt= conn.createStatement();

            // Controlla se il ristorante è già tra i preferiti
            String sql="SELECT * FROM preferiti WHERE email_utente ='"+ TheKnifeHome.utente +"' AND id_ristorante='"+id_rist+"'";
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                new Errore("Errore, il ristorante selezionato è già tra i preferiti").setVisible(true);
            }else{
                try{
                    // Inserisce nei preferiti
                    sql="INSERT INTO preferiti (email_utente, id_ristorante) VALUES ('"+ TheKnifeHome.utente +"','"+id_rist+"')";
                    int rowsInserted =stmt.executeUpdate(sql);
                    new Operazione().setVisible(true);
                }
                catch(SQLException e){
                    new Errore("<html>Errore durante l'operazione:<br>\"" + e.getMessage() + "\"</html>").setVisible(true);
                }
            }
        }catch(SQLException e) {
            new Errore("Errore durante la connessione: " + e.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Nasconde i bottoni per aggiungere ai preferiti e per lasciare un commento.
     * Visibile solo agli utenti con ruolo "cliente".
     */
    public static void NascondiBottone(){
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(false);
    }

    /**
     * Mostra i bottoni per aggiungere ai preferiti e per lasciare un commento.
     * Visibile solo agli utenti con ruolo "cliente".
     */
    public static void MostraBottone(){
        jMenuItem1.setVisible(true);
        jMenuItem2.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JMenuItem jMenuItem1;
    private static javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
