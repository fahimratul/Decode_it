/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application.form.other.ROT13;

import Logics.RSA;
import raven.alerts.MessageAlerts;

/**
 *
 * @author RATUL
 */
public class ROT13Show extends javax.swing.JPanel {

    public static RSA logic;
    /**
     * Creates new form Morse
     */
    public ROT13Show() {
        initComponents();
        try{
            logic = new RSA();
        }catch (Exception e){
            MessageAlerts.getInstance().showMessage("DATA SERVER ERROR", e.getMessage(), MessageAlerts.MessageType.ERROR);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new MiscItem.BACKGOUND.Background();
        rOT13form1 = new application.form.other.ROT13.ROT13form();

        background1.setLayout(new java.awt.BorderLayout());

        rOT13form1.setOpaque(false);
        background1.add(rOT13form1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MiscItem.BACKGOUND.Background background1;
    private application.form.other.ROT13.ROT13form rOT13form1;
    // End of variables declaration//GEN-END:variables
}
