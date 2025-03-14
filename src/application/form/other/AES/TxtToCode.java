package application.form.other.AES;

import MiscItem.BACKGOUND.PanelCustom;
import Logics.AEScode;
import Logics.MorsecodeLogic;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Insets;
import javax.sound.sampled.LineUnavailableException;
import raven.toast.Notifications;


public class TxtToCode extends PanelCustom {
     private AEScode logic=new AEScode();
    
    public TxtToCode() {
        initComponents();
        setBackground(new Color(34,34,59, 200));
        
        
        TxtInput.setLineWrap(true);
        TxtInput.setWrapStyleWord(true);
        TxtInput.setEditable(true);
        TxtInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Morse Code here");
        TxtInput.putClientProperty(FlatClientProperties.STYLE, ""+ "font: $h2.font;");
        
        TScroll.putClientProperty("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        TScroll.putClientProperty("ScrollBar.track", Color.white);
        TScroll.putClientProperty("ScrollBar.trackArc", 999);
        TScroll.putClientProperty("ScrollBar.thumbArc", 999);
        TScroll.putClientProperty("ScrollBar.trackInsets", new Insets(2, 4, 2, 4) );
        
        TxtOut.setLineWrap(true);
        TxtOut.setWrapStyleWord(true);
        TxtOut.setEditable(false);
        TxtOut.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Txt will appear here");
        TxtOut.putClientProperty(FlatClientProperties.STYLE, ""+ "font: 130% $h2.font;");

        
        OScroll.putClientProperty("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        OScroll.putClientProperty("ScrollBar.track", Color.WHITE);
        OScroll.putClientProperty("ScrollBar.trackArc", 999);
        OScroll.putClientProperty("ScrollBar.thumbArc", 999);
        OScroll.putClientProperty("ScrollBar.trackInsets", new Insets(2, 4, 2, 4) );

        Title.putClientProperty(FlatClientProperties.STYLE, ""+ "font: $h1.font;");
        Title.setForeground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TScroll = new javax.swing.JScrollPane();
        TxtInput = new javax.swing.JTextArea();
        OScroll = new javax.swing.JScrollPane();
        TxtOut = new javax.swing.JTextArea();
        Title = new javax.swing.JLabel();
        Convert = new javax.swing.JButton();

        setBackground(new java.awt.Color(34, 34, 59));
        setMaximumSize(new java.awt.Dimension(700, 700));

        TxtInput.setColumns(20);
        TxtInput.setRows(5);
        TxtInput.setMaximumSize(new java.awt.Dimension(350, 400));
        TScroll.setViewportView(TxtInput);

        TxtOut.setColumns(20);
        TxtOut.setRows(5);
        TxtOut.setMaximumSize(new java.awt.Dimension(350, 400));
        OScroll.setViewportView(TxtOut);

        Title.setText("AES ENCODING");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Convert.setText("CONVERT");
        Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OScroll, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(Convert, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TScroll))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
        
        try {
            // Initialize with a predefined key and IV (Base64-encoded)
            logic.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");

            String encryptedMessage = logic.encrypt(TxtInput.getText());

            TxtOut.setText(encryptedMessage);

            // Decrypt the message



        } catch (Exception d) {
            d.printStackTrace(); // Handle exceptions properly
        }
        
        
    }//GEN-LAST:event_ConvertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Convert;
    private javax.swing.JScrollPane OScroll;
    private javax.swing.JScrollPane TScroll;
    private javax.swing.JLabel Title;
    private javax.swing.JTextArea TxtInput;
    private javax.swing.JTextArea TxtOut;
    // End of variables declaration//GEN-END:variables
}
