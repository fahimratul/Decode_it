package application.form.other.AES_1;

import MiscItem.BACKGOUND.PanelCustom;
import Morsecode.AEScode;
import Morsecode.Morsetotext;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Insets;


public class CCdecode extends PanelCustom {
    private AEScode logic=new AEScode();
   
   
    public CCdecode() {
        initComponents();
        setAlpha(1);
        
        TxtInput.setLineWrap(true);
        TxtInput.setWrapStyleWord(true);
        TxtInput.setEditable(true);
        TxtInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Morse Code here");
        TxtInput.putClientProperty(FlatClientProperties.STYLE, ""+ "font: $h2.font;");
        
        TScroll.putClientProperty("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        TScroll.putClientProperty("ScrollBar.track", Color.DARK_GRAY);
        TScroll.putClientProperty("ScrollBar.trackArc", 999);
        TScroll.putClientProperty("ScrollBar.thumbArc", 999);
        TScroll.putClientProperty("ScrollBar.trackInsets", new Insets(2, 4, 2, 4) );

        TxtOut.setLineWrap(true);
        TxtOut.setWrapStyleWord(true);
        TxtOut.setEditable(false);
        TxtOut.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Txt will appear here");
        TxtOut.putClientProperty(FlatClientProperties.STYLE, ""+ "font: $h2.font;");

        OScroll.putClientProperty("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        OScroll.putClientProperty("ScrollBar.track", Color.DARK_GRAY);
        OScroll.putClientProperty("ScrollBar.trackArc", 999);
        OScroll.putClientProperty("ScrollBar.thumbArc", 999);
        OScroll.putClientProperty("ScrollBar.trackInsets", new Insets(2, 4, 2, 4) );

        Title.putClientProperty(FlatClientProperties.STYLE, ""+ "font: $h1.font;");
        Title.setForeground(Color.BLACK);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TScroll = new javax.swing.JScrollPane();
        TxtInput = new javax.swing.JTextArea();
        OScroll = new javax.swing.JScrollPane();
        TxtOut = new javax.swing.JTextArea();
        Convert = new javax.swing.JButton();
        Title = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 232, 214));

        TxtInput.setColumns(20);
        TxtInput.setRows(5);
        TScroll.setViewportView(TxtInput);

        TxtOut.setColumns(20);
        TxtOut.setRows(5);
        OScroll.setViewportView(TxtOut);

        Convert.setText("CONVERT");
        Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertActionPerformed(evt);
            }
        });

        Title.setText("AES DECODING");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OScroll)
                    .addComponent(TScroll)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
        try {
            logic.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");



            // Decrypt the message

            String decryptedMessage = logic.decrypt(TxtInput.getText());
            TxtOut.setText(decryptedMessage);


        } catch (Exception d) {
            d.printStackTrace(); // Handle exceptions properly
        }

        // TODO add your handling code here:
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
