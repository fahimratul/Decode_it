package application.form.other.CC;

import MiscItem.BACKGOUND.PanelCustom;
import Morsecode.CaeserCypherlogic;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Insets;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;


public class CCdecode extends PanelCustom {
    private CaeserCypherlogic logic = new CaeserCypherlogic();
   
   
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

        setBackground(new java.awt.Color(224, 251, 252));
        setToolTipText("");
        setAutoscrolls(true);

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

        Title.setText("CAESERCYPHER  DECODING");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(TScroll))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Convert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertActionPerformed
         if(TxtInput.getText().equals("")){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_LEFT, "Please enter your text");
        }
        else {
            String str = "Enter the key for decoding. If you don't know the key then you are requested to contect with the Admin.";
            CCmsgbox cCmsgbox = new CCmsgbox(str);
            try {
                DefaultOption defaultOption = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Decode"};
                GlassPanePopup.showPopup(new SimplePopupBorder(cCmsgbox, "Enter your Key", actions, (popupController, i) -> {
                    if (i == 1) {
                        try {
                            int key = cCmsgbox.getKey();
                            StringBuilder output = logic.decipher(TxtInput.getText(), key);
                            TxtOut.setText(output.toString());
                            popupController.closePopup();
                        }
                        catch (NumberFormatException e){
                            cCmsgbox.changemsg(" \t Invalid key!\r Because of "+ e + ". Please enter correct numeric value.\rEnter the key for encoding. If you don't know the key then you are requested to contect with the Admin.");
                            cCmsgbox.Txtclear();
                        }
                    } else {
                        popupController.closePopup();
                    }
                }), defaultOption);
            } catch (Exception e) {
                
            }
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
