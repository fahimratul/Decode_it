package application;

import Model.User;
import application.form.Adminlogin;
import application.form.LoginForm;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import application.form.MainForm;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import raven.toast.Notifications;
import application.form.AdminMainForm;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Ratul
 */
public class Application extends javax.swing.JFrame {

    private static Application app;
    private final MainForm mainForm;
    private final LoginForm loginForm;
    private final Adminlogin adminlogin;
    private final AdminMainForm adminMainForm;
    public static User user;
    public static  boolean saved;

    public Application() {
        initComponents();
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        mainForm = new MainForm();
        loginForm = new LoginForm();
        adminlogin = new Adminlogin();
        adminMainForm = new AdminMainForm();
        saved = true;
        setContentPane(loginForm);
        getRootPane().putClientProperty(FlatClientProperties.FULL_WINDOW_CONTENT, true);
        Notifications.getInstance().setJFrame(this);
        GlassPanePopup.install(this);
        revalidate();
        repaint();
    }


    public static void main(String args[]) {

        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            app = new Application();
            //  app.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            app.setVisible(true);
        });
    }

    public static void showForm(Component component) {
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }
    public static void showForm_admin(Component component) {
        if(saved){
            component.applyComponentOrientation(app.getComponentOrientation());
            app.adminMainForm.showForm(component);
        }
        else{
            MessageAlerts.getInstance().showMessage("Data is not saved", "It looks like you haven’t saved your data yet. Please make sure to save your work before proceeding to avoid any loss. Do you want to continue", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                @Override
                public void action(PopupController popupController, int i) {
                    if(i== MessageAlerts.YES_OPTION){
                        component.applyComponentOrientation(app.getComponentOrientation());
                        app.adminMainForm.showForm(component);
                    }
                }
            });
        }
    }

    public static void adminLoginshow() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.adminlogin); // Set the content pane to AdminLoginForm
        app.adminlogin.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.adminlogin);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }


    public static void login() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    
    }


    public static void adminloginmenu() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.adminMainForm);
        app.adminMainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.adminMainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.adminMainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }




    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
