/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application.form.other;

import Morsecode.AEScode;
/**
 *
 * @author TANVIR JAKARIA LITU
 */
public class Aes extends javax.swing.JPanel {
    private AEScode q=new AEScode();

    /**
     * Creates new form AEScode
     */
    public Aes() {
        
        initComponents();
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                PlaysoundActionPerformed(evt);
            }
        });
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
        jTitile = new javax.swing.JLabel();
        msg = new javax.swing.JTextField();
        entertext = new javax.swing.JLabel();
        encoded = new javax.swing.JTextField();
        enmsg = new javax.swing.JLabel();
        SUBMIT = new javax.swing.JButton();

        jTitile.setText("jLabel1");
        background1.add(jTitile);
        jTitile.setBounds(90, 20, 37, 16);

        msg.setBackground(new java.awt.Color(0, 0, 0));
        msg.setText("jTextField1");
        background1.add(msg);
        msg.setBounds(100, 40, 180, 40);

        entertext.setBackground(new java.awt.Color(0, 255, 255));
        entertext.setText("Enter Message");
        entertext.setOpaque(true);
        background1.add(entertext);
        entertext.setBounds(150, 20, 80, 16);

        encoded.setText("jTextField2");
        background1.add(encoded);
        encoded.setBounds(100, 150, 180, 40);

        enmsg.setBackground(new java.awt.Color(0, 255, 255));
        enmsg.setText("Encoded Message");
        enmsg.setOpaque(true);
        background1.add(enmsg);
        enmsg.setBounds(140, 130, 100, 16);

        SUBMIT.setBackground(new java.awt.Color(51, 51, 255));
        SUBMIT.setForeground(new java.awt.Color(255, 255, 255));
        SUBMIT.setText("SUBMIT");
        SUBMIT.setOpaque(true);
        background1.add(SUBMIT);
        SUBMIT.setBounds(150, 90, 72, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SUBMIT;
    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JTextField encoded;
    private javax.swing.JLabel enmsg;
    private javax.swing.JLabel entertext;
    private javax.swing.JLabel jTitile;
    private javax.swing.JTextField msg;
    // End of variables declaration//GEN-END:variables
}
