package application.form.other.Addmember;

import java.io.File;
import javax.swing.*;

import raven.extras.AvatarIcon;

/**
 *
 * @author RAVEN
 */
public class UserProfilepic {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    public UserProfilepic(File path) {
        this.path = path;
    }

    public UserProfilepic(byte[] bytes) {
        if (bytes != null) {
            icon = new ImageIcon(bytes);
        }
    }

    public UserProfilepic(Icon icon) {
        this.icon = icon;
    }

    private Icon icon;
    private Icon avatar;
    private File path;

    public Icon getAvatarIcon(int x, int y) {
        if (icon == null) {
            return null;
        }
        if (avatar == null) {
            AvatarIcon ai = new AvatarIcon(icon, x, y, 3f);
            ai.setType(AvatarIcon.Type.MASK_SQUIRCLE);
            avatar = ai;
        }
        return avatar;
    }
}
