package application.form.other.AES_1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class CC extends javax.swing.JPanel {

    private MigLayout layout;
    private CCencode Text;
    private CCdecode Morse;
    private Animator animator;
    private boolean flag;

    public void setAnimate(int animate) {
        layout.setComponentConstraints(Text, "pos (50%)-290px-" + animate + " 0.5al n n");
        layout.setComponentConstraints(Morse, "pos (50%)-10px+" + animate + " 0.5al n n");
        if (animate == 30) {
            if (flag) {
                setComponentZOrder(Morse, 0);
            } else {
                setComponentZOrder(Text, 0);
            }
        }
        revalidate();
    }

    public CC() {
        initComponents();
        init();
        initAnimator();
    }

    private void initAnimator() {
        animator = new Animator(1000, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (flag) {
                    Text.setAlpha(fraction);
                    Morse.setAlpha(1f - fraction);
                } else {
                    Text.setAlpha(1f - fraction);
                    Morse.setAlpha(fraction);
                }
            }
        });
        animator.addTarget(new PropertySetter(this, "animate", 0, 30, 0));
        animator.setResolution(0);
    }

    private void init() {
        layout = new MigLayout("fill", "fill", "fill");
        setLayout(layout);
        Text = new CCencode();
        Morse = new CCdecode();
        add(Text, "pos (50%)-290px 0.5al n n");
        add(Morse, "pos (50%)-10px 0.5al n n");
        Text.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                         
                        flag =false;
                        animator.start();
                    
                }
            }
        });
        Morse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                        flag =true;
                        animator.start();
                    
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
