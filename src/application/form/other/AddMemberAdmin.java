package application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import raven.toast.Notifications;
import connection.Connuser;

/**
 *
 * @author Ratul
 */
public class AddMemberAdmin extends javax.swing.JPanel {

    public AddMemberAdmin() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h0.font");

        AddMemPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");

        AddBtn.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        AddBtn.putClientProperty( "JButton.buttonType", "roundRect" );
    
        AddMemNamein.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        AddMemRk.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Rank");
        AddMemEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "xyz@gmail.com");
        AddMemDOB.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DD/MM/YYYY");
        AddMemPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        AddMemMobile.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "+8801XXXXXXXXX");
        AddMemRole.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Admin/User");
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new pannelcolor("#205072");
        AddBtn = new javax.swing.JButton();
        addmemName = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        AddMemNamein = new javax.swing.JTextField();
        addmemRk = new javax.swing.JLabel();
        AddMemRk = new javax.swing.JTextField();
        jEmail = new javax.swing.JLabel();
        AddMemEmail = new javax.swing.JTextField();
        jPass = new javax.swing.JLabel();
        jMobile = new javax.swing.JLabel();
        AddMemMobile = new javax.swing.JTextField();
        jDOB = new javax.swing.JLabel();
        AddMemDOB = new javax.swing.JTextField();
        jRole = new javax.swing.JLabel();
        AddMemRole = new javax.swing.JTextField();
        AddMemPass = new javax.swing.JPasswordField();

        AddBtn.setText("Add Member");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        addmemName.setText("Name");

        lb.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Add New member");

        AddMemNamein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemNameinActionPerformed(evt);
            }
        });

        addmemRk.setText("Rank");

        jEmail.setText("Email");

        jPass.setText("Password");

        jMobile.setText("Mobile No");

        jDOB.setText("DOB");

        AddMemDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemDOBActionPerformed(evt);
            }
        });

        jRole.setText("Role");

        AddMemRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addmemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addmemRk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPass, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMobile))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(AddMemDOB)
                    .addComponent(AddMemNamein)
                    .addComponent(AddMemRk)
                    .addComponent(AddMemEmail)
                    .addComponent(AddMemPass)
                    .addComponent(AddMemMobile)
                    .addComponent(AddMemRole))
                .addGap(111, 111, 111))
            .addComponent(lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddMemNamein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addmemName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddMemRk)
                    .addComponent(addmemRk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddMemEmail)
                    .addComponent(jEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddMemPass)
                    .addComponent(jPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddMemMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddMemDOB)
                    .addComponent(jDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddMemRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddMemDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemDOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemDOBActionPerformed

    private void AddMemRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemRoleActionPerformed

    private void AddMemNameinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemNameinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemNameinActionPerformed

    private  boolean checkfield() {
        boolean flag = true;
        if (AddMemNamein.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Please Enter Name ");
            flag = false;
        }

        if (AddMemRk.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Rank field is empty!");
            flag = false;
        }

        if (AddMemEmail.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Email field is empty!");
            flag = false;
        }

        if (new String(AddMemPass.getPassword()).trim().isEmpty()) { // For PasswordField
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Password field is empty!");
            flag = false;
        }

        if (AddMemMobile.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Mobile No field is empty!");
            flag = false;
        }

        if (AddMemDOB.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "DOB field is empty!");
            flag = false;
        }

        if (AddMemRole.getText().trim().isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Role field is empty!");
            flag = false;
        }
            return flag;
    }

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:


        if (checkfield()) {
            String name = AddMemNamein.getText();
            String rank = AddMemRk.getText();
            String email = AddMemEmail.getText();
            String password = new String(AddMemPass.getPassword());
            String mobile = AddMemMobile.getText();
            String dob = AddMemDOB.getText();
            String role = AddMemRole.getText();
            try {
                Connuser c = new Connuser();
                String query = "INSERT INTO users VALUES ('"+ name +"', '" +rank+"', '"+ email+"', '"+ dob+"', '"+password+"', '"+ role+"', '"+mobile+"');";
                System.out.println(query);
                c.st.executeUpdate(query);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Member added successfully!");
            } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Error Occurred. Please Try Again!");
            }

        };

    }//GEN-LAST:event_AddBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField AddMemDOB;
    private javax.swing.JTextField AddMemEmail;
    private javax.swing.JTextField AddMemMobile;
    private javax.swing.JTextField AddMemNamein;
    private javax.swing.JPasswordField AddMemPass;
    private javax.swing.JTextField AddMemRk;
    private javax.swing.JTextField AddMemRole;
    private javax.swing.JLabel addmemName;
    private javax.swing.JLabel addmemRk;
    private javax.swing.JLabel jDOB;
    private javax.swing.JLabel jEmail;
    private javax.swing.JLabel jMobile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPass;
    private javax.swing.JLabel jRole;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
