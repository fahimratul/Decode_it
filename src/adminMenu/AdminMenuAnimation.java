package adminMenu;

import menu.*;
import com.formdev.flatlaf.util.Animator;
import java.util.HashMap;

/**
 *
 * @author Ratul
 */
public class AdminMenuAnimation {

    private static final HashMap<AdminMenuItem, Animator> hash = new HashMap<>();

    public static void animate(AdminMenuItem adminmenu, boolean show) {
        if (hash.containsKey(adminmenu) && hash.get(adminmenu).isRunning()) {
            hash.get(adminmenu).stop();
        }
        adminmenu.setMenuShow(show);
        Animator animator = new Animator(400, new Animator.TimingTarget() {
            @Override
            public void timingEvent(float f) {
                if (show) {
                    adminmenu.setAnimate(f);
                } else {
                    adminmenu.setAnimate(1f - f);
                }
                adminmenu.revalidate();
            }

            @Override
            public void end() {
                hash.remove(adminmenu);
            }
        });
        animator.setResolution(1);
        animator.setInterpolator((float f) -> (float) (1 - Math.pow(1 - f, 3)));
        animator.start();
        hash.put(adminmenu, animator);
    }
}
