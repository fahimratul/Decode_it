package application.form.other;

import application.Application;
import com.formdev.flatlaf.FlatClientProperties;

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
            
            name.setText(Application.user.getName().toUpperCase());
            Rank.setText(Application.user.getRank());
            Email.setText(Application.user.getEmail());
            
            name.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:200% $h2.font");
            Rank.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h2.font");
            Email.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h2.font");
            pic.setIcon(Application.user.getProfile().getAvatarIcon(155,155));

        }
        

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new MiscItem.BACKGOUND.Background();
        lb = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        Rank = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        background1.setBlur(jPanel1);

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Dashboard");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 232, 214));
        jPanel1.setOpaque(false);

        name.setText("jLabel2");
        name.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Email.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rank, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Rank, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Rank;
    private MiscItem.BACKGOUND.Background background1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pic;
    // End of variables declaration//GEN-END:variables
}
