package adminMenu;

import menu.*;

/**
 *
 * @author Ratul
 */
public interface AdminMenuEvent {

    public void menuSelected(int index, int subIndex, AdminMenuAction action);
}
