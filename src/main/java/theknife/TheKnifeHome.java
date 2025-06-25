/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package theknife;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Classe principale della finestra home di THE KNIFE.
 * Permette la ricerca di ristoranti con diversi filtri e opzioni.
 *
 * @author Afzal Mahrukh
 * @author Girardi Verdiana
 * @author Syed Zeryab Haider
 * @author Vigano' Luca
 */
public class TheKnifeHome extends javax.swing.JFrame {

    /**
     * Costruttore che inizializza i componenti grafici
     * e nasconde eventuali bottoni iniziali.
     */
    public TheKnifeHome() {
        initComponents();
        NascondiBottone();  // Metodo personalizzato per nascondere bottoni (non mostrato nel codice)
    }

    /**
     * Metodo generato automaticamente per inizializzare i componenti della GUI.
     * Non modificare manualmente, poiché rigenerato dal Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THE KNIFE");

        jLabel1.setText("Inserisci per cercare");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Distanza :");

        jSlider1.setForeground(new java.awt.Color(0, 153, 0));
        jSlider1.setMaximum(20);
        jSlider1.setValue(10);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel3.setText("Fascia di prezzo :");

        jCheckBox1.setText("Delivery");

        jCheckBox2.setText("Prenotazioni");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutte", "✦ Selected Restaurants", "✪ Bib Gourmand", "✭", "✭✭", "✭✭✭", "✭✭✭✭", "✭✭✭✭✭" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(80, 22));
        jComboBox1.setPreferredSize(new java.awt.Dimension(80, 22));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutte", "€", "€€", "€€€", "€€€€" }));
        jComboBox2.setMinimumSize(new java.awt.Dimension(80, 22));
        jComboBox2.setPreferredSize(new java.awt.Dimension(80, 22));

        jMenu1.setText("Menù");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Accedi");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Registrati");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Preferiti");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Aggiungi Ristorante");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("I Miei Ristoranti");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Esci");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       new Accedi().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel2.setText("Distanza : "+String.valueOf(jSlider1.getValue())+" Km");
    }//GEN-LAST:event_jSlider1StateChanged

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Registrati().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Gestisce l'azione del menu per visualizzare i ristoranti preferiti dell'utente.
     * Si connette al database, esegue la query per ottenere i ristoranti preferiti
     * e crea dinamicamente dei bottoni per ognuno, che aprono una nuova finestra con i dettagli.
     *
     * @param evt Evento generato dalla selezione del menu item.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        
        try {
            // Rimuove tutti i componenti da jPanel1 per aggiornarlo con i risultati nuovi
            jPanel1.removeAll();
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            Statement stmt= conn.createStatement();
            // Query per ottenere i ristoranti preferiti dall'utente
            String sql="SELECT DISTINCT id,nome,lati,longi FROM ristoranti JOIN preferiti ON id= id_ristorante WHERE id_ristorante IN(SELECT id_ristorante FROM preferiti WHERE email_utente='"+utente+"')";
            ResultSet rs=stmt.executeQuery(sql);
            jPanel1.removeAll();
            JLabel j1=new JLabel();
            j1.setText("I Miei Preferiti:");
            j1.setHorizontalAlignment(SwingConstants.CENTER);
            jPanel1.add(j1);
            // Ciclo sui risultati per creare bottoni dinamici per ogni ristorante
            while (rs.next()) {
                String dataLat=rs.getString("lati");
                String dataLongi=rs.getString("longi");
                String nome=rs.getString("nome");
                int dataid=rs.getInt("id");
                JButton bottone = new JButton();
                bottone.setText(nome);
                // Al click apre la finestra di dettaglio del ristorante
                bottone.addActionListener((ActionEvent e) -> {
                    new VisualizzaRistorante(dataid,nome,dataLat,dataLongi).setVisible(true);
                });
                jPanel1.add(bottone);
            }jPanel1.revalidate();
            
            conn.close();
        } catch (SQLException e) {
            // Mostra un errore in una finestra popup in caso di problemi con la connessione o query
            new Errore("<html>Errore durante laconnessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Apre la finestra per aggiungere un nuovo ristorante.
     * @param evt Evento generato dalla selezione del menu item.
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new AggRist().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * Visualizza i ristoranti gestiti dall'utente loggato.
     * Si connette al database, recupera i ristoranti associati all'email utente e li mostra come bottoni.
     * @param evt Evento generato dalla selezione del menu item.
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        
        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            Statement stmt= conn.createStatement();
            // Query per ottenere i ristoranti dell'utente
            String sql="SELECT  id,nome,lati,longi FROM ristoranti WHERE email_u='"+utente+"'";
            ResultSet rs=stmt.executeQuery(sql);
            jPanel1.removeAll();
            JLabel j1=new JLabel();
            j1.setText("I Miei Ristoranti:");
            j1.setHorizontalAlignment(SwingConstants.CENTER);
            jPanel1.add(j1);
            // Ciclo sui risultati e crea bottoni per ogni ristorante
            while (rs.next()) {
                String dataLat=rs.getString("lati");
                String dataLongi=rs.getString("longi");
                String nome=rs.getString("nome");
                int dataid=rs.getInt("id");
                JButton bottone = new JButton();
                bottone.setText(nome);
                bottone.addActionListener((ActionEvent e) -> {
                    new VisualizzaRistorante(dataid,nome,dataLat,dataLongi).setVisible(true);
                });
                jPanel1.add(bottone);
            }jPanel1.revalidate();
            
            conn.close();
        } catch (SQLException e) {
            new Errore("<html>Errore durante laconnessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * Effettua il logout dell'utente cancellando le informazioni di sessione
     * e nascondendo i bottoni appropriati.
     * @param evt Evento generato dalla selezione del menu item.
     */
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TheKnifeHome.utente=null;
        TheKnifeHome.ruolo=null;
        NascondiBottone();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * Invoca la ricerca dei ristoranti in base ai criteri inseriti.
     * @param evt Evento generato dal click sul bottone.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cercaRistoranti();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    /**
     * Variabile statica che memorizza l'email o username dell'utente loggato.
     */
    public static String utente= null;
    /**
     * Variabile statica che memorizza il ruolo dell'utente loggato (es. utente o ristoratore).
     */
    public static String ruolo=null;
    /**
     * Nasconde i bottoni destinati agli utenti loggati e mostra quelli per utenti non loggati.
     */
    public static void NascondiBottone(){
        jMenuItem1.setVisible(true);
        jMenuItem2.setVisible(true);
        jMenuItem3.setVisible(false);
        jMenuItem4.setVisible(false);
        jMenuItem5.setVisible(false);
        jMenuItem6.setVisible(false);
    }
    /**
     * Mostra i bottoni disponibili per gli utenti (non ristoratori).
     */
    public static void MostraBottoneUtente(){
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(false);
        jMenuItem3.setVisible(true);
        jMenuItem6.setVisible(true);
    }
    /**
     * Mostra i bottoni disponibili per i ristoratori.
     */
    public static void MostraBottoneRist(){
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(false);
        jMenuItem4.setVisible(true);
        jMenuItem5.setVisible(true);
        jMenuItem6.setVisible(true);
    }
    
    /**
    * Calcola la distanza in chilometri tra due coordinate geografiche.
    *
    * @param lat1 la latitudine della prima coordinata.
    * @param lon1 la longitudine della prima coordinata.
    * @param lat2 la latitudine della seconda coordinata.
    * @param lon2 la longitudine della seconda coordinata.
    * @return la distanza in chilometri tra le due coordinate.
    */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int asd = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return asd * b;
    }
    /**
     * Effettua la ricerca dei ristoranti in base ai criteri selezionati dall'utente,
     * come nome, fascia, stelle, disponibilità di delivery o prenotazioni, e distanza massima.
     * I risultati vengono mostrati come bottoni dinamici in jPanel1.
     */
    public void cercaRistoranti() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";
        Statement stmt =null;
        ResultSet rs=null;
        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            stmt= conn.createStatement();

            // Se il campo nome è vuoto si applicano i filtri selezionati
            if (jTextField1.getText().length() == 0) {
                jPanel1.removeAll();
                try{
                    String sql;
                    // Costruzione dinamica della query in base alle selezioni comboBox e checkbox
                    //jComboBox2 => fascia
                    //jComboBox1 => stelle
                    //jCheckBox1 => Delivery
                    //jCheckBox2 => Prenotazioni
                    if(jComboBox2.getSelectedItem().equals("Tutte")){
                        if(jComboBox1.getSelectedItem().equals("Tutte")){
                            if(jCheckBox1.isSelected()){
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE delivery = true AND prenotazioni = true";
                                    System.out.println("1.1");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE delivery = true";
                                    System.out.println("1.2");
                                }
                            }else{
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE prenotazioni = true";
                                    System.out.println("1.3");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti";
                                    System.out.println("1.4");
                                }
                            } 
                        }else{
                            if(jCheckBox1.isSelected()){
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE stelle='"+jComboBox1.getSelectedItem()+"' AND delivery = true AND prenotazioni = true";
                                    System.out.println("2.1");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE stelle='"+jComboBox1.getSelectedItem()+"' AND delivery = true";
                                    System.out.println("2.2");
                                }
                            }else{
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE stelle='"+jComboBox1.getSelectedItem()+"' AND prenotazioni = true";
                                    System.out.println("2.3");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE stelle='"+jComboBox1.getSelectedItem()+"'";
                                    System.out.println("2.4");
                                }
                            }
                        }
                    }else{
                        if(jComboBox1.getSelectedItem().equals("Tutte")){
                            if(jCheckBox1.isSelected()){
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia = '"+jComboBox2.getSelectedItem()+"' AND delivery = true AND prenotazioni = true";
                                    System.out.println("3.1");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia = '"+jComboBox2.getSelectedItem()+"' AND delivery = true";
                                    System.out.println("3.2");
                                }
                            }else{
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia = '"+jComboBox2.getSelectedItem()+"' AND prenotazioni = true";
                                    System.out.println("3.3");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia = '"+jComboBox2.getSelectedItem()+"'";
                                    System.out.println("3.4");
                                }
                            } 
                        }else{
                            if(jCheckBox1.isSelected()){
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia = '"+jComboBox2.getSelectedItem()+"' AND stelle='"+jComboBox1.getSelectedItem()+"' AND delivery = true AND prenotazioni = true";
                                    System.out.println("4.1");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia='"+jComboBox2.getSelectedItem()+"' AND stelle='"+jComboBox1.getSelectedItem()+"' AND delivery = true";
                                    System.out.println("4,2");
                                }
                            }else{
                                if(jCheckBox2.isSelected()){
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia='"+jComboBox2.getSelectedItem()+"' AND stelle='"+jComboBox1.getSelectedItem()+"' AND prenotazioni = true";
                                    System.out.println("4,3");
                                }else{
                                    sql="SELECT id,nome,lati,longi FROM ristoranti WHERE fascia='"+jComboBox2.getSelectedItem()+"' AND stelle='"+jComboBox1.getSelectedItem()+"'";
                                    System.out.println("4,4");
                                }
                            }
                        }
                    }
                    rs=stmt.executeQuery(sql);
                    // Legge i risultati e crea bottoni
                    while (rs.next()) {
                        String dataLat=rs.getString("lati");
                        String dataLongi=rs.getString("longi");
                        String datanome=rs.getString("nome");
                        int dataid=rs.getInt("id");
                        JButton bottone = new JButton();
                        bottone.setText(datanome);
                        bottone.addActionListener((ActionEvent e) -> {
                            new VisualizzaRistorante(dataid,datanome,dataLat,dataLongi).setVisible(true);
                        });
                        jPanel1.add(bottone);
                    }jPanel1.revalidate();
                } catch (SQLException e) {
                    new Errore("<html>Errore durante laconnessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
                }
            } else {
                // Se è stato inserito un nome, cerca solo per nome
                jPanel1.removeAll();
                try {
                    //gestione dei nomi con apostrofo
                    String nome=jTextField1.getText();
                    String nomemod=nome.replace("'", "''");
                    String sql="SELECT lati,longi FROM ristoranti WHERE nome='"+nomemod+"'";
                    rs=stmt.executeQuery(sql);
                    if (rs.next()) {
                        String inputLati=rs.getString("lati");
                        String inputLongi=rs.getString("longi");
                        double inputLat = Double.parseDouble(inputLati);
                        double inputLon = Double.parseDouble(inputLongi);
                        sql="SELECT id,nome,lati,longi FROM ristoranti ORDER BY nome";
                        try{
                            ResultSet rs1=stmt.executeQuery(sql);
                            // Legge i risultati e crea bottoni
                            while(rs1.next()){
                                String dataLat=rs1.getString("lati");
                                String dataLongi=rs1.getString("longi");
                                String nome1=rs1.getString("nome");
                                int dataid=rs1.getInt("id");
                                double lat = Double.parseDouble(dataLat);
                                double lon = Double.parseDouble(dataLongi);
                                double distance = calculateDistance(inputLat, inputLon, lat, lon);
                                if((int)distance <= jSlider1.getValue()){
                                    JButton bottone = new JButton();
                                    bottone.setText(nome1);
                                    bottone.addActionListener((ActionEvent e) -> {
                                        new VisualizzaRistorante(dataid,nome1,dataLat,dataLongi).setVisible(true);
                                    });
                                    jPanel1.add(bottone);
                                }
                            }jPanel1.revalidate();
                        }catch(SQLException e){
                            System.out.println(e);
                            new Errore("<html>Errore durante la ricerca: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
                        }
                    }else{
                        new Errore("Il ristorante non esiste").setVisible(true);
                    }
                    jPanel1.revalidate();
                } catch (SQLException e) {
                    new Errore("Errore durante la ricerca: " + e.getMessage()).setVisible(true);
                }
            }
        jPanel1.repaint();
        conn.close();
        } catch (SQLException e) {
            new Errore("<html>Errore durante la connessione al database: <br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JMenuItem jMenuItem1;
    private static javax.swing.JMenuItem jMenuItem2;
    private static javax.swing.JMenuItem jMenuItem3;
    private static javax.swing.JMenuItem jMenuItem4;
    private static javax.swing.JMenuItem jMenuItem5;
    private static javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
