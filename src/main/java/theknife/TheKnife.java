// Pacchetto principale dell'applicazione
package theknife;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

/**
 * Classe principale dell'applicazione TheKnife.
 * Inizializza il look and feel personalizzato con FlatLaf e avvia l'interfaccia utente principale.
 * Tutti i componenti Swing vengono personalizzati tramite UIManager per applicare uno stile coerente.
 */
public class TheKnife {

    /**
     * Metodo principale dell'applicazione.
     * Applica lo stile scuro FlatLaf e personalizza l'aspetto dei componenti UI.
     * Successivamente, avvia l'interfaccia grafica principale (TheKnifeHome).
     *
     * @param args argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        try {
            // Inizializza il tema FlatDarkLaf
            FlatDarkLaf.setup();
        } catch (Exception e) {
            System.err.println("Impossibile caricare FlatLaf Dark");
        }

        // ✅ Personalizzazione dei pulsanti
        UIManager.put("Button.background", new Color(45, 45, 45));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.arc", 10);

        // ✅ Personalizzazione dei campi di testo
        UIManager.put("TextField.background", new Color(60, 60, 60));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.caretForeground", Color.WHITE);
        UIManager.put("TextField.border", BorderFactory.createLineBorder(Color.DARK_GRAY));
        UIManager.put("TextField.arc", 10);

        // ✅ Personalizzazione dei campi password
        UIManager.put("PasswordField.background", new Color(60, 60, 60));
        UIManager.put("PasswordField.foreground", Color.WHITE);
        UIManager.put("PasswordField.caretForeground", Color.WHITE);
        UIManager.put("PasswordField.border", BorderFactory.createLineBorder(Color.DARK_GRAY));
        UIManager.put("PasswordField.arc", 10);

        // ✅ Personalizzazione delle combo box
        UIManager.put("ComboBox.background", new Color(60, 60, 60));
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("ComboBox.buttonBackground", new Color(60, 60, 60));
        UIManager.put("ComboBox.selectionBackground", new Color(0, 153, 0));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        UIManager.put("ComboBox.borderColor", new Color(0, 153, 0));
        UIManager.put("ComboBox.arc", 10);

        // ✅ Personalizzazione delle checkbox
        Color verde = new Color(0, 153, 0);
        UIManager.put("CheckBox.background", new Color(45, 45, 45));
        UIManager.put("CheckBox.foreground", Color.WHITE);
        UIManager.put("Component.focusColor", verde);
        UIManager.put("CheckBox.icon.selectedBorderColor", verde);
        UIManager.put("CheckBox.icon.selectedBackground", verde);
        UIManager.put("CheckBox.icon.selectedCheckmarkColor", Color.WHITE);
        UIManager.put("CheckBox.icon.borderColor", Color.GRAY);
        UIManager.put("CheckBox.icon.background", new Color(45, 45, 45));

        // ✅ Personalizzazione dei menu
        UIManager.put("MenuItem.selectionBackground", verde);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("Menu.selectionBackground", verde);
        UIManager.put("Menu.selectionForeground", Color.WHITE);

        // ✅ Personalizzazione dello slider
        UIManager.put("Slider.thumbColor", verde);
        UIManager.put("Slider.trackColor", Color.DARK_GRAY);
        UIManager.put("Slider.trackWidth", 6);
        UIManager.put("Slider.thumbSize", new Dimension(14, 14));
        UIManager.put("Slider.focusWidth", 0);

        // ✅ Personalizzazione generale dell'interfaccia
        UIManager.put("Panel.background", new Color(20, 20, 20));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("ScrollPane.background", new Color(45, 45, 45));
        UIManager.put("Component.focusColor", verde);

        // Avvio dell'interfaccia utente principale su thread grafico Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TheKnifeHome().setVisible(true); // Crea e mostra la finestra principale
        });
    }
}
