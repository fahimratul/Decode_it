package application.form;

import Model.User;
import application.Application;
import com.formdev.flatlaf.FlatClientProperties;
import connection.Connuser;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ratul
 */
public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
       setLayout(new MigLayout("al center center"));

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new MiscItem.BACKGOUND.Background();
        panelLogin1 = new application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        emptymsgbox = new javax.swing.JLabel();

        background1.setBlur(panelLogin1);

        panelLogin1.setOpaque(false);

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login");
        panelLogin1.add(lbTitle);

        lbUser.setText("User Name");
        panelLogin1.add(lbUser);

        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        panelLogin1.add(txtUser);

        lbPass.setText("Password");
        panelLogin1.add(lbPass);

        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        panelLogin1.add(txtPass);

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        emptymsgbox.setForeground(new java.awt.Color(255, 51, 51));
        emptymsgbox.setText(" ");
        panelLogin1.add(emptymsgbox);

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private  boolean checkadmin(){
        return (txtUser.getText().equals("admin") && txtPass.getText().equals("<PASSWORD>"));
    }
    private boolean checkuser(){
        return (!txtUser.getText().isEmpty() && !txtPass.getText().isEmpty());
    }
    
    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        if(checkadmin()){
            Application.adminLoginshow();
        }else{
            if(checkuser()){
                if(checkuser_password(txtUser.getText(),txtPass.getPassword())) {
                    Application.user= new User(txtUser.getText());
                    Application.login();
                }
                else{
                    Notifications.getInstance().show(Notifications.Type.WARNING,Notifications.Location.TOP_CENTER,"Wrong Password or Username");
                }
            }
            else{
                if(txtUser.getText().isEmpty()){
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Enter User Name");
                }
                if(txtPass.getText().isEmpty()){
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Enter Password ");
                }
            }
        }
    }

    private boolean checkuser_password(String name, char[] password) {
        Connuser c = new Connuser();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = c.con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, String.valueOf(password));
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean flag= rs.next();
                rs.close();
                pstmt.close();
                c.con.close();
                return flag;
            }
        } catch (SQLException e) {
            return false;
        }
        
    }
//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        emptymsgbox.setText(" ");

    }//GEN-LAST:event_txtUserMouseClicked

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        emptymsgbox.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel emptymsgbox;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
