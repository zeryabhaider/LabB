package theknife;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class TheKnife {
    public static void main(String[] args) {
        try {
            FlatDarkLaf.setup();
        } catch (Exception e) {
            System.err.println("Impossibile caricare FlatLaf Dark");
        }

        // ✅ Button
        UIManager.put("Button.background", new Color(45, 45, 45));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.arc", 10);

        // ✅ TextField/PasswordField
        UIManager.put("TextField.background", new Color(60, 60, 60));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.caretForeground", Color.WHITE);
        UIManager.put("TextField.border", BorderFactory.createLineBorder(Color.DARK_GRAY));
        UIManager.put("TextField.arc", 10);
        UIManager.put("PasswordField.background", new Color(60, 60, 60));
        UIManager.put("PasswordField.foreground", Color.WHITE);
        UIManager.put("PasswordField.caretForeground", Color.WHITE);
        UIManager.put("PasswordField.border", BorderFactory.createLineBorder(Color.DARK_GRAY));
        UIManager.put("PasswordField.arc", 10);

        // ✅ ComboBox
        UIManager.put("ComboBox.background", new Color(60, 60, 60));
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("ComboBox.buttonBackground", new Color(60, 60, 60));
        UIManager.put("ComboBox.selectionBackground", new Color(0, 153, 0));
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        UIManager.put("ComboBox.borderColor", new Color(0, 153, 0));
        UIManager.put("ComboBox.arc", 10);

        // ✅ CheckBox
        Color verde = new Color(0, 153, 0); // oppure il verde che preferisci
        UIManager.put("CheckBox.background", new Color(45, 45, 45));
        UIManager.put("CheckBox.foreground", Color.WHITE);
        UIManager.put("Component.focusColor", verde);
        UIManager.put("CheckBox.icon.selectedBorderColor", verde);
        UIManager.put("CheckBox.icon.selectedBackground", verde);
        UIManager.put("CheckBox.icon.selectedCheckmarkColor", Color.WHITE); // colore del ✓
        UIManager.put("CheckBox.icon.borderColor", Color.GRAY); // bordo normale
        UIManager.put("CheckBox.icon.background", new Color(45, 45, 45)); // sfondo normale

        // ✅ Menu
        UIManager.put("MenuItem.selectionBackground", verde);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);

        UIManager.put("Menu.selectionBackground", verde);
        UIManager.put("Menu.selectionForeground", Color.WHITE);

        // ✅ Slider
        UIManager.put("Slider.thumbColor", new Color(0, 153, 0));
        UIManager.put("Slider.trackColor", Color.DARK_GRAY);
        UIManager.put("Slider.trackWidth", 6);
        UIManager.put("Slider.thumbSize", new Dimension(14, 14));
        UIManager.put("Slider.focusWidth", 0);

        // ✅ Generale
        UIManager.put("Panel.background", new Color(45, 45, 45));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("ScrollPane.background", new Color(45, 45, 45));
        UIManager.put("Component.focusColor", new Color(0, 153, 0));

    
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TheKnifeHome().setVisible(true);
        });
    }
}
