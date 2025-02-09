package adminMenu;

import adminMenu.*;
/**
 *
 * @author Ratul
 */
public class AdminMenuAction {

    protected boolean isCancel() {
        return cancel;
    }

    public void cancel() {
        this.cancel = true;
    }

    private boolean cancel = false;
}
