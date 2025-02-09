package application.form.other;

import application.form.*;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Ratul
 */
public class Addmember extends JPanel {

    public Addmember() {
        setLayout(new MigLayout("fillx,wrap,insets 30 40 50 40, width 520", "[fill]", "[]20[][]15[][]30[]"));
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:20;");
    }

}
