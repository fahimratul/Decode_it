package application.form.other.Addmember;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.File;
import java.sql.Date;
import javaswingdev.picturebox.DefaultPictureBoxRender;
import raven.toast.Notifications;
import javax.management.Notification;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import Model.Userinfo;
import java.io.IOException;
import java.sql.SQLException;
import raven.alerts.MessageAlerts;
/**
 *
 * @author RATUL
 */
public class AddmemberForm extends javax.swing.JPanel {
    private Uploaddatabase uploaddatabase;

    /**
     * Creates new form Create
     */
    public AddmemberForm() {
        initComponents();
        uploaddatabase = new Uploaddatabase();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txtDate);
        pic.setPictureBoxRender(new DefaultPictureBoxRender() {
            @Override
            public Shape render(Rectangle rectangle) {
                return createRound(rectangle, UIScale.scale(10));
            }
        });
        pic.setImage(new FlatSVGIcon("icon/svg/profile.svg", 5f));
        panelPic.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:0,0,0,0,$Component.borderColor,,10;"
                + "background:$TextArea.background");
        AddBtn.setEnabled(false);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new raven.datetime.component.date.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelPic = new javax.swing.JPanel();
        pic = new javaswingdev.picturebox.PictureBox();
        jToolBar1 = new javax.swing.JToolBar();
        cmdBrowse = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Password = new MiscItem.swing.PasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtRank = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Name");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Rank");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Date of Birth");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Mobile No");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Profile Pic");

        panelPic.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        cmdBrowse.setText("Browse");
        cmdBrowse.setFocusable(false);
        cmdBrowse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdBrowse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBrowseActionPerformed(evt);
            }
        });
        jToolBar1.add(cmdBrowse);

        cmdDelete.setForeground(new java.awt.Color(255, 0, 0));
        cmdDelete.setText("Delete");
        cmdDelete.setFocusable(false);
        cmdDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(cmdDelete);

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        panelPic.add(pic, java.awt.BorderLayout.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Email");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Password");

        AddBtn.setText("Add Member");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(panelPic, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRank, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMobile, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(AddBtn)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBrowseActionPerformed
        JnaFileChooser ch = new JnaFileChooser();
        ch.addFilter("Image", "png", "jpg");
        boolean act = ch.showOpenDialog(SwingUtilities.getWindowAncestor(this));
        if (act) {
            File file = ch.getSelectedFile();
            pic.setImage(new ImageIcon(file.getAbsolutePath()));
            profile = new UserProfilepic(file);
        }
    }//GEN-LAST:event_cmdBrowseActionPerformed

    private UserProfilepic profile;

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        pic.setImage(new FlatSVGIcon("/icon/svg/profile.svg", 5f));
        profile = null;
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if(!isFormFilled()){
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,"Please fill all the fields before proceeding.");
            return;
        }
        try{
            Userinfo userinfo=new Userinfo();
            userinfo=getData();
            uploaddatabase.create(userinfo);
            MessageAlerts.getInstance().showMessage("MEMBER ADDED SUCCESSFULLY", userinfo.getName() + " Added Successfully. Please Remember the username and password for next login. Thank you for adding new member.", MessageAlerts.MessageType.SUCCESS);
            cleardata();
        }catch(SQLException| IOException e){
            MessageAlerts.getInstance().showMessage("DATA SERVER ERROR", e.getMessage(), MessageAlerts.MessageType.ERROR);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
           try{
               if(!txtName.getText().equals("")){
                   if(uploaddatabase.search_username(txtName.getText())){
                       Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT,""+txtName.getText()+" is already exist");
                       return;
                   }
                   else{
                    AddBtn.setEnabled(true);
                   }
               }
           }
           catch (SQLException e){

           }
           
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyReleased

    private void cleardata(){
        txtName.setText("");
        txtRank.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
        Password.setText("");

    }


    public Userinfo getData() {
        String name = txtName.getText();
        String rank = txtRank.getText();
        String Mobile = txtMobile.getText();
        Date date = datePicker.isDateSelected() ? Date.valueOf(datePicker.getSelectedDate()) : null;
        String email = txtEmail.getText();
        String pass = String.valueOf(Password.getPassword());
        Userinfo temp =new Userinfo(name, rank, email, date, Mobile,pass, profile);
        return temp;
    }

    public void init() {
        txtName.grabFocus();
    }

    public boolean isFormFilled() {
        return !txtName.getText().trim().isEmpty() &&
               !txtRank.getText().trim().isEmpty() &&
               !txtDate.getText().trim().isEmpty() &&
               !txtMobile.getText().trim().isEmpty() &&
               !txtEmail.getText().trim().isEmpty() &&
               Password.getPassword().length > 0;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private MiscItem.swing.PasswordField Password;
    private javax.swing.JButton cmdBrowse;
    private javax.swing.JButton cmdDelete;
    private raven.datetime.component.date.DatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelPic;
    private javaswingdev.picturebox.PictureBox pic;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRank;
    // End of variables declaration//GEN-END:variables
}
