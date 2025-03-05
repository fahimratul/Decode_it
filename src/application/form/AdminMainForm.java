package application.form;

import adminMenu.AdminMenuAction;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import application.form.other.FormDashboard;
import application.form.other.Addmember.AddmemBer;
import adminMenu.AdminMenu;
import application.form.other.AllMember.Allmember;
import application.form.other.MorsecodeChange.MorseChngForm;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;
import application.Application;

/**
 *
 * @author Ratul
 */
public class AdminMainForm extends JLayeredPane {


    private AdminMenu adminmenu;
    private JPanel panelBody;
    private JButton menuButton;

    public AdminMainForm() {
        init();
    }

    private void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        adminmenu = new AdminMenu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!adminmenu.isMenuFull());
        });
        initMenuEvent();
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(adminmenu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        initMenuArrowIcon();
    }

    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("icon/svg/" + icon, 0.8f));
    }

    private void initMenuEvent() {


            adminmenu.addMenuEvent((int index, int subIndex, AdminMenuAction action) -> {
                switch (index) {
                    case 0:
                        Application.showForm_admin(new FormDashboard());
                        break;
                    case 1:
                        Application.showForm_admin(new AddmemBer());
                        break;
                    case 2:
                        Application.showForm_admin(new Allmember());
                        break;
                    case 3:
                        Application.showForm_admin(new MorseChngForm());
                        break;
                    case 4:
                        MessageAlerts.getInstance().showMessage("ARE YOU SURE?", "Are you sure you want to exit?Please Check back you data saved or not.", MessageAlerts.MessageType.WARNING, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                            @Override
                            public void action(PopupController popupController, int i) {
                                if(i== MessageAlerts.YES_OPTION){
                                    Application.logout();
                                }
                            }
                        });
                        break;
                    default:
                        action.cancel();
                        break;
                }
            });




    }

    private void setMenuFull(boolean full) {
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("icon/svg/" + icon, 0.8f));
        adminmenu.setMenuFull(full);
        revalidate();
    }

    public void hideMenu() {
        adminmenu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        adminmenu.setSelectedMenu(index, subIndex);
    }


    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(adminmenu.isMenuFull() ? adminmenu.getMenuMaxWidth() : adminmenu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                adminmenu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (adminmenu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (adminmenu.isMenuFull() ? 0.5f : 0.7f)));
                }
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                panelBody.setBounds(bodyx, y, bodyWidth, bodyHeight);
            }
        }
    }
}
