package theknife;
/**
 * Finestra di accesso  per utenti registrati.
 * Mostra una pagina semplice per l'accesso di clienti e ristoratori
 *
 * @author Afzal Mahrukh
 * @author Girardi Verdiana
 * @author Syed Zeryab Haider
 * @author Vigano' Luca
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Timer;
import org.mindrot.jbcrypt.BCrypt;

public class Accedi extends javax.swing.JFrame {

    /**
     * Costruttore della classe Accedi.
     * Inizializza i componenti grafici.
     */
    public Accedi() {
        initComponents();
    }

    /**
     * Metodo chiamato dal costruttore per inizializzare i componenti grafici.
     * Generato automaticamente dal Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inizializzazione componenti dell'interfaccia grafica
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("THE KNIFE");

        jLabel1.setText("E-mail:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password:");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Accedi");
        jButton1.setPreferredSize(new java.awt.Dimension(76, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        // Layout dell'interfaccia
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(jPasswordField1))
                                .addContainerGap(35, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null); // centra la finestra sullo schermo
    }

    /**
     * Evento attivato quando si preme il tasto "Invio" nel campo email.
     */
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Azioni opzionali per il campo email
    }

    /**
     * Evento attivato quando si preme il tasto "Invio" nel campo password.
     */
    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Azioni opzionali per il campo password
    }

    /**
     * Evento attivato quando l'utente preme il bottone "Accedi".
     * Gestisce l'autenticazione tramite query SQL al database.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Lettura input da interfaccia
        String email = jTextField1.getText();
        String psw = jPasswordField1.getText();
        String passwordCriptata = BCrypt.hashpw(psw, BCrypt.gensalt());

        // Parametri di connessione al database PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1";

        try {
            // Connessione al database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo!");
            Statement stmt = conn.createStatement();

            if(email.contains("@")){
                // Query SQL per autenticazione
                String sql = "SELECT * FROM registrazione WHERE email = '" + email + "' AND password = '" + passwordCriptata + "'";

                try {
                    ResultSet rs = stmt.executeQuery(sql);
                    TheKnifeHome.utente = email;

                    // Recupero ruolo dell'utente
                    sql = "SELECT ruolo FROM registrazione WHERE email='" + email + "'";
                    rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        // Utente esistente, apro la finestra operazioni
                        new Operazione().setVisible(true);

                        // Salvo ruolo e mostro i bottoni relativi
                        TheKnifeHome.ruolo = rs.getString("ruolo");
                        if (TheKnifeHome.ruolo.equals("cliente")) {
                            TheKnifeHome.MostraBottoneUtente();
                        } else {
                            TheKnifeHome.MostraBottoneRist();
                        }
                    } else {
                        // Nessun risultato = credenziali errate
                        new Errore("L'utente non esiste").setVisible(true);
                    }
                    Accedi.this.dispose(); // chiude la finestra di login
                } catch (SQLException e) {
                    new Errore("<html>Errore durante l'inserimento delle credenziali:<br>\"" + e.getMessage() + "\"</html>").setVisible(true);
                }
            }else{
                // Errore durante inserimento dell' email
                new Errore("<html>Errore la sintassi dell' email è errata:</html>").setVisible(true);
            }
            
            conn.close(); // chiude la connessione
        } catch (SQLException e) {
            new Errore("<html>Errore durante la connessione al database:<br>\"" + e.getMessage() + "\"</html>").setVisible(true);
        }
        // Timer che chiude la finestra dopo 1 secondo dall'invio
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Chiude questa finestra
            }
        });
        timer.setRepeats(false); // Si attiva una sola volta
        timer.start();
    }

    // Dichiarazione componenti dell'interfaccia grafica
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
