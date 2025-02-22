package application.form.other;

import Morsecode.ONE_TIME_PAD;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Onetime extends javax.swing.JPanel {

    private String encryptionKey; // Stores the key for decryption

    public Onetime() {
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
        String message = input1.getText().trim();

        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text to encrypt.");
            return;
        }

        // Generate key for encryption (same length as message)
        encryptionKey = generateKey(message.length());
        String encryptedMessage = xorCipher(message, encryptionKey);

        // Display results
        output1.setText(encryptedMessage);
        JOptionPane.showMessageDialog(this, "Encryption Key (Save this!): " + encryptionKey);
    }

    private void decryptText(ActionEvent evt) {
        String encryptedMessage = input2.getText().trim();

        if (encryptedMessage.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text to decrypt.");
            return;
        }

        if (encryptionKey == null || encryptionKey.length() != encryptedMessage.length()) {
            JOptionPane.showMessageDialog(this, "Invalid or missing encryption key! Decryption failed.");
            return;
        }

        // Decrypt the message using the stored key
        String decryptedMessage = xorCipher(encryptedMessage, encryptionKey);
        output2.setText(decryptedMessage);
    }

    // Generates a random key of the same length as the message
    private String generateKey(int length) {
        Random random = new Random();
        StringBuilder key = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            key.append((char) (random.nextInt(256))); // Generates a random ASCII character
        }
        return key.toString();
    }

    // XOR Cipher for encryption & decryption
    private String xorCipher(String text, String key) {
        StringBuilder result = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            result.append((char) (text.charAt(i) ^ key.charAt(i)));
        }
        return result.toString();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        background1 = new MiscItem.BACKGOUND.Background();
        buttonGroup1 = new javax.swing.ButtonGroup();
        background2 = new MiscItem.BACKGOUND.Background();
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

        enter1.setText("  Enter Text");
        enter1.setOpaque(true);
        background2.add(enter1);
        enter1.setBounds(170, 60, 80, 30);
        background2.add(input1);
        input1.setBounds(40, 120, 350, 50);

        sub1.setText("Encrypt");
        background2.add(sub1);
        sub1.setBounds(310, 190, 100, 30);

        encrypt.setText("  Encrypted Text");
        encrypt.setOpaque(true);
        background2.add(encrypt);
        encrypt.setBounds(150, 270, 110, 30);
        background2.add(output1);
        output1.setBounds(40, 330, 350, 50);

        enter2.setText("   Enter Encrypted Text");
        enter2.setOpaque(true);
        background2.add(enter2);
        enter2.setBounds(870, 420, 150, 30);
        background2.add(input2);
        input2.setBounds(720, 470, 370, 50);

        sub2.setText("Decrypt");
        background2.add(sub2);
        sub2.setBounds(1000, 540, 100, 30);

        decrypt.setText("  Decrypted Text");
        decrypt.setOpaque(true);
        background2.add(decrypt);
        decrypt.setBounds(860, 620, 110, 30);
        background2.add(output2);
        output2.setBounds(720, 680, 370, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(background2, javax.swing.GroupLayout.PREFERRED_SIZE, 1687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(background2, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    // Variables declaration
    private MiscItem.BACKGOUND.Background background1;
    private MiscItem.BACKGOUND.Background background2;
    private javax.swing.ButtonGroup buttonGroup1;
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