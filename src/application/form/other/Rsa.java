
package application.form.other;

import Logics.RSA;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rsa extends javax.swing.JPanel {
    private RSA rsaCipher;

    public Rsa() {
        try {
            rsaCipher = new RSA(); // Ensure RSA instance is properly initialized
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "RSA Initialization Failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            rsaCipher = null; // Set to null to prevent further errors
        }

        initComponents();

        sub1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                encryptText(evt);
            }
        });

        sub2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                decryptText(evt);
            }
        });
    }

    private void encryptText(ActionEvent evt) {
        if (rsaCipher == null) {
            JOptionPane.showMessageDialog(this, "RSA is not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String message = input1.getText().trim();
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter text to encrypt.");
                return;
            }

            // Encrypt message
            String encryptedMessage = rsaCipher.encrypt(message);
            output1.setText(encryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Encryption failed! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void decryptText(ActionEvent evt) {
        if (rsaCipher == null) {
            JOptionPane.showMessageDialog(this, "RSA is not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String encryptedMessage = input2.getText().trim();
            if (encryptedMessage.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter text to decrypt.");
                return;
            }

            // Decrypt message
            String decryptedMessage = rsaCipher.decrypt(encryptedMessage);
            output2.setText(decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Decryption failed! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        background1 = new MiscItem.BACKGOUND.Background();
        enter1 = new javax.swing.JLabel();
        input1 = new javax.swing.JTextField();
        sub1 = new javax.swing.JButton();
        encrypt = new javax.swing.JLabel();
        output1 = new javax.swing.JTextField();
        enter2 = new javax.swing.JLabel();
        input2 = new javax.swing.JTextField();
        sub2 = new javax.swing.JButton();
        decrypt = new javax.swing.JLabel();
        output2 = new javax.swing.JTextField();

        enter1.setText("Enter Text");
        background1.add(enter1);
        enter1.setBounds(230, 20, 90, 40);
        background1.add(input1);
        input1.setBounds(30, 70, 480, 60);

        sub1.setText("Encrypt");
        background1.add(sub1);
        sub1.setBounds(380, 160, 100, 40);

        encrypt.setText("Encrypted Text");
        background1.add(encrypt);
        encrypt.setBounds(220, 250, 130, 40);
        background1.add(output1);
        output1.setBounds(30, 300, 490, 60);

        enter2.setText("Enter Encrypted Text");
        background1.add(enter2);
        enter2.setBounds(680, 450, 150, 40);
        background1.add(input2);
        input2.setBounds(480, 500, 470, 60);

        sub2.setText("Decrypt");
        background1.add(sub2);
        sub2.setBounds(840, 580, 90, 40);

        decrypt.setText("Decrypted Text");
        background1.add(decrypt);
        decrypt.setBounds(670, 650, 120, 40);

        output2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                output2ActionPerformed(evt);
            }
        });
        background1.add(output2);
        output2.setBounds(480, 700, 470, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void output2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Empty event handler to prevent errors
    }

    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JLabel decrypt;
    private javax.swing.JLabel encrypt;
    private javax.swing.JLabel enter1;
    private javax.swing.JLabel enter2;
    private javax.swing.JTextField input1;
    private javax.swing.JTextField input2;
    private javax.swing.JTextField output1;
    private javax.swing.JTextField output2;
    private javax.swing.JButton sub1;
    private javax.swing.JButton sub2;
}