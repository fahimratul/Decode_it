/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application.form.other.MorseCode;

import Morsecode.MorsecodeLogic;
import raven.toast.Notifications;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author RATUL
 */
public class Morse2text extends javax.swing.JPanel{
    private MorsecodeLogic logic=new MorsecodeLogic();

    /**
     * Creates new form Morse2text
     */
    public Morse2text() {
        initComponents();
        ChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeButtonActionPerformed(evt);
            }
        });
        Playsound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaysoundActionPerformed(evt);
            }
        });
        setBackground(new java.awt.Color(0, 102, 102, 225)); // Set background color with some transparency
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Outputbox = new MiscItem.swing.TextField_Round();
        ChangeButton = new MiscItem.swing.Button_Round();
        Playsound = new MiscItem.swing.Button_Round();
        TextBox = new MiscItem.swing.TextField_Round();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));

        Outputbox.setEditable(false);
        Outputbox.setHint("Your text will be here");

        ChangeButton.setText("Convert");

        Playsound.setText("Play Sound");

        TextBox.setHint("Text");

        jLabel1.setText("Text To Morse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(TextBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Outputbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Playsound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Outputbox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Playsound, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
    }// </editor-fold>//GEN-END:initComponents


    private  void ChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (TextBox.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Enter Your Text Here");
            return;
        }
        Outputbox.setText(logic.getMorseCode(TextBox.getText()));
    }

    private void PlaysoundActionPerformed(java.awt.event.ActionEvent evt) {
        if(Outputbox.getText().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "No Morse Code Found");
            return;
        }
        ChangeButton.setEnabled(false);
        Playsound.setEnabled(false);
        new Thread(() -> {
            try {
                logic.playSound(new String[]{Outputbox.getText()});
            } catch (LineUnavailableException | InterruptedException ex) {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Error playing sound: " + ex.getMessage());
            } finally {
                ChangeButton.setEnabled(true);
                Playsound.setEnabled(true);
            }
        }).start();
        Notifications.getInstance().show(Notifications.Type.INFO, "Sound is loading please wait");
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MiscItem.swing.Button_Round ChangeButton;
    private MiscItem.swing.TextField_Round Outputbox;
    private MiscItem.swing.Button_Round Playsound;
    private MiscItem.swing.TextField_Round TextBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
