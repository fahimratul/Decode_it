package application.form.other.ROT13;

import static Logics.ROT13Example.rot13;
import MiscItem.BACKGOUND.PanelCustom;
import MiscItem.swing.FileLoader;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Insets;
import raven.toast.Notifications;



public class ROT13encoding extends PanelCustom {


    public ROT13encoding() {
        initComponents();
        setBackground(new Color(240, 93, 94, 180));
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
        Save = new javax.swing.JButton();

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

        Title.setText("ROT13 ENCRYPTION");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Convert.setText("CONVERT");
        Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertActionPerformed(evt);
            }
        });

        Save.setText("SAVE");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
        if(TxtInput.getText().equals("")){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Please enter your text");
        }
        else {
            

        // Get the string to encode or decode from the user
        
        String input = TxtInput.getText();

        // Apply ROT13 encoding/decoding
        String result = rot13(input);

        // Output the result
        TxtOut.setText(result);
        

        
        }
    }//GEN-LAST:event_ConvertActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
            if(TxtOut.getText().equals("")){
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Please encrypt your text first");
                return;
            }
            FileLoader.saved(TxtOut.getText(),this);
    }//GEN-LAST:event_SaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Convert;
    private javax.swing.JScrollPane OScroll;
    private javax.swing.JButton Save;
    private javax.swing.JScrollPane TScroll;
    private javax.swing.JLabel Title;
    private javax.swing.JTextArea TxtInput;
    private javax.swing.JTextArea TxtOut;
    // End of variables declaration//GEN-END:variables
}
