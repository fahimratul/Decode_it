package application.form.other.MorseCode;

import MiscItem.BACKGOUND.PanelCustom;
import Logics.MorsecodeLogic;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Insets;
import javax.sound.sampled.LineUnavailableException;
import raven.toast.Notifications;


public class TextToMorse extends PanelCustom {

   
    private  MorsecodeLogic logic;
    
    
    public TextToMorse() {
        initComponents();
        setBackground(new Color(60, 180, 221, 170));

        logic = new MorsecodeLogic();
       
        
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
        PlaySound = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 58, 58));
        setMaximumSize(new java.awt.Dimension(700, 700));

        TxtInput.setColumns(20);
        TxtInput.setRows(5);
        TxtInput.setMaximumSize(new java.awt.Dimension(350, 400));
        TScroll.setViewportView(TxtInput);

        TxtOut.setColumns(20);
        TxtOut.setRows(5);
        TxtOut.setMaximumSize(new java.awt.Dimension(350, 400));
        OScroll.setViewportView(TxtOut);

        Title.setText("TEXT TO MORSECODE");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Convert.setText("CONVERT");
        Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertActionPerformed(evt);
            }
        });

        PlaySound.setText("Play Sound");
        PlaySound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaySoundActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(PlaySound, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(TScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PlaySound, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
        if (TxtInput.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Enter Your Text Here");
            return;
        }
        TxtOut.setText(logic.getMorseCode(TxtInput.getText()));
    }//GEN-LAST:event_ConvertActionPerformed

    private void PlaySoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaySoundActionPerformed
        if(TxtOut.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "No Morse Code Found");
            return;
        }
        Convert.setEnabled(false);
        PlaySound.setEnabled(false);
        new Thread(() -> {
            try {
                logic.playSound(new String[]{TxtOut.getText()});
            } catch (LineUnavailableException | InterruptedException ex) {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Error playing sound: " + ex.getMessage());
            } finally {
                Convert.setEnabled(true);
                PlaySound.setEnabled(true);
            }
        }).start();
            Notifications.getInstance().show(Notifications.Type.INFO, "Sound is loading please wait");
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaySoundActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Convert;
    private javax.swing.JScrollPane OScroll;
    private javax.swing.JButton PlaySound;
    private javax.swing.JScrollPane TScroll;
    private javax.swing.JLabel Title;
    private javax.swing.JTextArea TxtInput;
    private javax.swing.JTextArea TxtOut;
    // End of variables declaration//GEN-END:variables
}
