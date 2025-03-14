package application.form;

import application.Application;
import application.form.other.Addmember.Uploaddatabase;
import com.formdev.flatlaf.FlatClientProperties;
import connection.Connuser;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import raven.alerts.MessageAlerts;

/**
 *
 * @author Ratul
 */
public class Adminlogin extends javax.swing.JPanel {

    public Adminlogin() {
        initComponents();
        init();
    }

    private void init() {
       setLayout(new MigLayout("al center center"));
       UserLoginBtn.setContentAreaFilled(false);

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new MiscItem.BACKGOUND.Background(5);
        panelLogin1 = new application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new MiscItem.swing.TextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new MiscItem.swing.PasswordField();
        cmdLogin = new MiscItem.swing.Button();
        emptymsgbox = new javax.swing.JLabel();
        UserLoginBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        background1.setBlur(panelLogin1);

        panelLogin1.setOpaque(false);

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Admin Login");
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

        UserLoginBtn.setText("Login as User");
        UserLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLoginBtnActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(598, Short.MAX_VALUE)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(528, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserLoginBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkuser(){
        return (!txtUser.getText().isEmpty() && !txtPass.getText().isEmpty());
    }
    
    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
            if(checkuser()){
            if(checkuser_password(txtUser.getText(),txtPass.getPassword())) {
                try {
                    String username=txtUser.getText();
                    Uploaddatabase service= new Uploaddatabase();
                    service.getUser(username);
                }
                catch(SQLException e) {
                    MessageAlerts.getInstance().showMessage("Login Error", "We could not load you user info. Sorry for the error . Please try again.", MessageAlerts.MessageType.ERROR);
                }
                txtUser.setText("");
                txtPass.setText("");
                Application.adminloginmenu();
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

//GEN-LAST:event_cmdLoginActionPerformed
 private boolean checkuser_password(String name, char[] password) {
        Connuser c = new Connuser();
        String query = "SELECT * FROM usersdata WHERE username = ? AND pass = ?";
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
    
    
    
    
    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        emptymsgbox.setText(" ");

    }//GEN-LAST:event_txtUserMouseClicked

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        emptymsgbox.setText(" ");
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassMouseClicked

    private void UserLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLoginBtnActionPerformed
            Application.logout();

        // TODO add your handling code here:
    }//GEN-LAST:event_UserLoginBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UserLoginBtn;
    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel emptymsgbox;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
