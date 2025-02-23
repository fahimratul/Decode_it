package application.form.other;

import application.Application;
import com.formdev.flatlaf.FlatClientProperties;
import raven.toast.Notifications;

/**
 *
 * @author Ratul
 */
public class FormDashboard extends javax.swing.JPanel {

    public FormDashboard() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        if(Application.user!=null) {
            username.setText(Application.user.getName().toUpperCase());
            rank.setText(Application.user.getRank());
            role.setText(Application.user.getRole());
            mobileno.setText(Application.user.getMobile());
            jName.putClientProperty(FlatClientProperties.STYLE, "" + "font:200% $h2.font");

            username.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:200% $h2.font");
            jRank.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h2.font");

            rank.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:$h2.font");
            jRole.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h2.font");

            role.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:$h2.font");
            JMobile.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h2.font");
            mobileno.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:$h2.font");
        }
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new MiscItem.BACKGOUND.Background();
        jPanel1 = new application.form.other.pannelcolor("#24AF11");
        mobileno = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        rank = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        jName = new javax.swing.JLabel();
        jRole = new javax.swing.JLabel();
        jRank = new javax.swing.JLabel();
        JMobile = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        panel1 = new MiscItem.Fancyborder.Panel();

        background1.setBlur(jPanel1);

        jPanel1.setOpaque(false);

        mobileno.setText("mobileno");

        username.setText("jLabel1");

        rank.setText("jLabel1");

        role.setText("jLabel1");

        jName.setText("Name:");
        jName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jRole.setText("Role:");
        jRole.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jRank.setText("Rank:");
        jRank.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        JMobile.setText("Mobile No: ");
        JMobile.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JMobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(role, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mobileno, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rank, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRank, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRole, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        background1.add(jPanel1);
        jPanel1.setBounds(160, 260, 510, 260);

        jButton1.setText("Show Notifications Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background1.add(jButton1);
        jButton1.setBounds(310, 530, 154, 23);

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Dashboard");
        background1.add(lb);
        lb.setBounds(60, 26, 656, 70);
        background1.add(panel1);
        panel1.setBounds(270, 60, 290, 270);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Hello sample message");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JMobile;
    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jRank;
    private javax.swing.JLabel jRole;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel mobileno;
    private MiscItem.Fancyborder.Panel panel1;
    private javax.swing.JLabel rank;
    private javax.swing.JLabel role;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
