/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application.form.other;

import Morsecode.CaeserCypherlogic;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCForm extends javax.swing.JPanel {
    private CaeserCypherlogic cc = new CaeserCypherlogic();

    public CCForm() {
        initComponents();

        sub1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Sub1Actionperformed(evt);
            }
        });

        sub2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Sub2Actionperformed(evt);
            }
        });
    }

    private void Sub1Actionperformed(ActionEvent evt) {
        try {
            String text = input1.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter text to encrypt.");
                return;
            }

            String keyStr = JOptionPane.showInputDialog("Enter integer key value:");
            if (keyStr == null || keyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid key.");
                return;
            }

            int key = Integer.parseInt(keyStr);
            String encryptedText = cc.encipher(text, key).toString();
            out1.setText(encryptedText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid key! Please enter a numeric value.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Sub2Actionperformed(ActionEvent evt) {
        try {
            String text = input2.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter text to decrypt.");
                return;
            }

            String keyStr = JOptionPane.showInputDialog("Enter integer key value:");
            if (keyStr == null || keyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid key.");
                return;
            }

            int key = Integer.parseInt(keyStr);
            String decryptedText = cc.decipher(text, key).toString();
            out2.setText(decryptedText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid key! Please enter a numeric value.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        background1 = new MiscItem.BACKGOUND.Background();
        enter1 = new javax.swing.JLabel();
        input1 = new javax.swing.JTextField();
        sub1 = new javax.swing.JButton();
        encrypt = new javax.swing.JLabel();
        out1 = new javax.swing.JTextField();
        enter2 = new javax.swing.JLabel();
        input2 = new javax.swing.JTextField();
        sub2 = new javax.swing.JButton();
        decrypt = new javax.swing.JLabel();
        out2 = new javax.swing.JTextField();

        enter1.setText("Enter Text");
        enter1.setOpaque(true);
        background1.add(enter1);
        enter1.setBounds(110, 40, 100, 20);
        background1.add(input1);
        input1.setBounds(40, 80, 240, 40);

        sub1.setText("Encrypt");
        background1.add(sub1);
        sub1.setBounds(120, 140, 100, 30);

        encrypt.setText("Encrypted Text");
        encrypt.setOpaque(true);
        background1.add(encrypt);
        encrypt.setBounds(100, 190, 110, 20);
        background1.add(out1);
        out1.setBounds(40, 240, 250, 40);

        enter2.setText("Enter Text");
        enter2.setOpaque(true);
        background1.add(enter2);
        enter2.setBounds(450, 380, 100, 20);
        background1.add(input2);
        input2.setBounds(390, 420, 230, 40);

        sub2.setText("Decrypt");
        background1.add(sub2);
        sub2.setBounds(470, 470, 100, 30);

        decrypt.setText("Decrypted Text");
        decrypt.setOpaque(true);
        background1.add(decrypt);
        decrypt.setBounds(450, 510, 120, 20);
        background1.add(out2);
        out2.setBounds(390, 560, 230, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JLabel decrypt;
    private javax.swing.JLabel encrypt;
    private javax.swing.JLabel enter1;
    private javax.swing.JLabel enter2;
    private javax.swing.JTextField input1;
    private javax.swing.JTextField input2;
    private javax.swing.JTextField out1;
    private javax.swing.JTextField out2;
    private javax.swing.JButton sub1;
    private javax.swing.JButton sub2;
}