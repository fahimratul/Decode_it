package application.form.other.about;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.LoggingFacade;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class About extends JPanel {

    public About() {
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx,wrap,insets 5 30 5 30,width 400", "[fill,330::]", ""));

        JTextPane title = createText("DECODE IT");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +5");

        JTextPane description = createText("");
        description.setContentType("text/html");
        description.setText(getDescriptionText());
        description.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                showUrl(e.getURL());
            }
        });

        add(title);
        add(description);
        add(createDevloperInformation());
        add(createSystemInformation());
    }

    private JTextPane createText(String text) {
        JTextPane textPane = new JTextPane();
        textPane.setBorder(BorderFactory.createEmptyBorder());
        textPane.setText(text);
        textPane.setEditable(false);
        textPane.setCaret(new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
            }
        });
        return textPane;
    }

    private String getDescriptionText() {
        String text = "This project is a Java-based application designed to perform encoding and decoding operations on input data."+
                " The application allows users to securely encode text or messages and later decode them back to their original form."+
                " The primary objective of this project is to demonstrate data security techniques through simple yet effective algorithms. " +
                "For source code, visit the <a href=\"https://github.com/fahimratul/Decode_it\">Decode it.</a>";                
        return text;
    }

    private String getSystemInformationText() {
        String text = "<b>Demo Version: </b>%s<br/>" +
                "<b>Java: </b>%s<br/>" +
                "<b>System: </b>%s<br/>";

        return text;
    }
    private String getDevloperInformationText() {
        String text = "<b>Name: </b>%s<br/>" +
                "<b>Name: </b>%s<br/>" +
                "<b>Name: </b>%s<br/>";

        return text;
    }
    
    private JComponent createDevloperInformation() {
        JPanel panel = new JPanel(new MigLayout("wrap"));
        panel.setBorder(new TitledBorder("Developer Information"));
        JTextPane textPane = createText("");
        textPane.setContentType("text/html");
        String name1 = "Md Fahim Morshed Ratul";
        String name2 ="Md Tanveer Jakaria"; 
        String name3 = "Tanzid Morshed Shahed";
        String text = String.format(getDevloperInformationText(),
                name1,
                name2,
                name3);
        textPane.setText(text);
        panel.add(textPane);
        return panel;
    }

    
    
    
    
    
    private JComponent createSystemInformation() {
        JPanel panel = new JPanel(new MigLayout("wrap"));
        panel.setBorder(new TitledBorder("System Information"));
        JTextPane textPane = createText("");
        textPane.setContentType("text/html");
        String version = "2.4.0-SNAPSHOT";
        String java = System.getProperty("java.vendor") + " - v" + System.getProperty("java.version");
        String system = System.getProperty("os.name") + " " + System.getProperty("os.arch") + " - v" + System.getProperty("os.version");
        String text = String.format(getSystemInformationText(),
                version,
                java,
                system);
        textPane.setText(text);
        panel.add(textPane);
        return panel;
    }

    private void showUrl(URL url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(url.toURI());
                } catch (IOException | URISyntaxException e) {
                    LoggingFacade.INSTANCE.logSevere("Error browse url", e);
                }
            }
        }
    }
}